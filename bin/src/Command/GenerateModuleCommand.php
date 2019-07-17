<?php

namespace src\Command;

use src\Command;
use src\Config;

class GenerateModuleCommand extends Command
{   
    protected $group;

    protected $modulePrefix;

    protected $name;

    protected $module;

    public function init()
    {   
        $this->group = Config::get("app::group");
        $this->modulePrefix = Config::get("app::modulePrefix");

        $input = $this->getArgv();
        if (!isset($input[0])) {
            $this->error("参数不能为空！");
        }

        $this->name = $input[0];
        $this->module = strtolower($input[0]);

        if (!preg_match('/^[a-zA-Z\s]+$/', $this->name)) {
            $this->error("名称只能为英文！");
        }

        $group = $this->group;
        $modulePrefix = $this->modulePrefix;
        $name = $this->name;
        $module = $this->module;
        $this->outPut("开始初始化{$modulePrefix}-{$module}-api:{$name}");

        $dir = __ROOT__."../{$modulePrefix}-{$module}";
        $serviceDir = __ROOT__."../{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-service";
        $apiDir = __ROOT__."../{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-api";
        $daoDir = __ROOT__."../{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-dao";

        $this->outPut('正在生成目录...');

        if (is_dir($dir)) {
            $this->error('目录已存在...初始化失败');
        }

        $groupname = implode("/", explode(".", $group));
        mkdir($serviceDir."/src/main/java/{$groupname}/{$module}/service", 0755, true);
        mkdir($apiDir."/src/main/java/{$groupname}/{$module}/web", 0755, true);
        mkdir($daoDir."/src/main/java/{$groupname}/{$module}/dao", 0755, true);

        $this->outPut('开始创建模板...');
        if (!file_exists($apiDir."/build.gradle")) {
            $data = $this->getFile("api/build.gradle.tpl");
            file_put_contents ($apiDir."/build.gradle", $data);
        } else {
            $this->outPut($apiDir."/build.gradle 文件已存在，已跳过");
        }

        if (!file_exists($serviceDir."/build.gradle")) {
            $data = $this->getFile("service/build.gradle.tpl");
            file_put_contents ($serviceDir."/build.gradle", $data);
        } else {
            $this->outPut($serviceDir."/build.gradle 文件已存在，已跳过");
        }

        if (!file_exists($daoDir."/build.gradle")) {
            $data = $this->getFile("dao/build.gradle.tpl");
            file_put_contents ($daoDir."/build.gradle", $data);
        } else {
            $this->outPut($daoDir."/build.gradle 文件已存在，已跳过");
        }

        if (!file_exists($dir."/build.gradle")) {
            $data = $this->getFile("build.gradle.tpl");
            file_put_contents ($dir."/build.gradle", $data);
        } else {
            $this->outPut($dir."/build.gradle 文件已存在，已跳过");
        }

        $dirs = [
            $serviceDir."/src/main/java/{$groupname}/{$module}/dto",
            $serviceDir."/src/main/java/{$groupname}/{$module}/api",
            $serviceDir."/src/main/java/{$groupname}/{$module}/service",
            $serviceDir."/src/main/java/{$groupname}/{$module}/mapper",
            $daoDir."/src/main/java/{$groupname}/{$module}/dao/entity",
            $daoDir."/src/main/java/{$groupname}/{$module}/dao/repository",
            $apiDir."/src/main/java/{$groupname}/{$module}/web/controller",
            $apiDir."/src/main/resources/db/migration",
        ];

        foreach ($dirs as $dir) {
            if (!is_dir($dir)) {
                mkdir($dir, 0755, true);
            }
        }

        $data = $this->getFile("api/resources/banner.txt.tpl");
        file_put_contents($apiDir."/src/main/resources/banner.txt", $data);
        $data = $this->getFile("api/resources/application-dev.properties.tpl");
        file_put_contents($apiDir."/src/main/resources/application-dev.properties", $data);
        $data = $this->getFile("api/resources/application.properties.tpl");
        file_put_contents($apiDir."/src/main/resources/application.properties", $data);

        $data = $this->getFile("api/Application.java.tpl");
        file_put_contents($apiDir."/src/main/java/{$groupname}/{$module}/Application.java", $data);

        if (file_exists($apiDir."/src/main/java/{$groupname}/{$module}/web/controller/".ucfirst($name)."Controller.java")) {
            $this->outPut(ucfirst($name)."Controller.java 已存在");
        } else {
            $data = $this->getFile("api/Controller.java.tpl");
            file_put_contents($apiDir."/src/main/java/{$groupname}/{$module}/web/controller/".ucfirst($name)."Controller.java", $data);
        }

        if (file_exists($daoDir."/src/main/java/{$groupname}/{$module}/dao/entity/".ucfirst($name)."Entity.java")) {
            $this->outPut(ucfirst($name)."Entity.java 已存在");
        } else {
            $data = $this->getFile("dao/Entity.java.tpl");
            file_put_contents($daoDir."/src/main/java/{$groupname}/{$module}/dao/entity/".ucfirst($name)."Entity.java", $data);
        }

        if (file_exists($daoDir."/src/main/java/{$groupname}/{$module}/dao/repository/".ucfirst($name)."Repository.java")) {
            $this->outPut(ucfirst($name)."Repository.java 已存在");
        } else {
            $data = $this->getFile("dao/Repository.java.tpl");
            file_put_contents($daoDir."/src/main/java/{$groupname}/{$module}/dao/repository/".ucfirst($name)."Repository.java", $data);
        }

        if (file_exists($serviceDir."/src/main/java/{$groupname}/{$module}/api/".ucfirst($name)."Service.java")) {
            $this->outPut(ucfirst($name)."Service.java 已存在");
        } else {
            $data = $this->getFile("service/Service.java.tpl");
            file_put_contents($serviceDir."/src/main/java/{$groupname}/{$module}/api/".ucfirst($name)."Service.java", $data);
        }

        if (file_exists($serviceDir."/src/main/java/{$groupname}/{$module}/dto/".ucfirst($name)."Dto.java")) {
            $this->outPut(ucfirst($name)."Dto.java 已存在");
        } else {
            $data = $this->getFile("service/Dto.java.tpl");
            file_put_contents($serviceDir."/src/main/java/{$groupname}/{$module}/dto/".ucfirst($name)."Dto.java", $data);
        }

        if (file_exists($serviceDir."/src/main/java/{$groupname}/{$module}/mapper/".ucfirst($name)."Mapper.java")) {
            $this->outPut(ucfirst($name)."Mapper.java 已存在");
        } else {
            $data = $this->getFile("service/Mapper.java.tpl");
            file_put_contents($serviceDir."/src/main/java/{$groupname}/{$module}/mapper/".ucfirst($name)."Mapper.java", $data);
        }

        if (file_exists($serviceDir."/src/main/java/{$groupname}/{$module}/service/".ucfirst($name)."ServiceImpl.java")) {
            $this->outPut(ucfirst($name)."ServiceImpl.java 已存在");
        } else {
            $data = $this->getFile("service/ServiceImpl.java.tpl");
            file_put_contents($serviceDir."/src/main/java/{$groupname}/{$module}/service/".ucfirst($name)."ServiceImpl.java", $data);
        }

        $data = $this->getFile("settings.gradle.tpl");
        file_put_contents(__ROOT__."../settings.gradle", $data, FILE_APPEND);

        $this->outPut("初始化完成，Refresh Your Gradle project");
    }

    private function getFile($tpl)
    {
        $data = file_get_contents(__DIR__."/../tpl/{$tpl}");

        return $this->getData($data);
    }

    private function getData($data)
    {   
        $data = str_replace("{{ group }}", $this->group, $data);
        $data = str_replace("{{ module }}", $this->module, $data);
        $data = str_replace("{{ modulePrefix }}", $this->modulePrefix, $data);
        $data = str_replace("{{ name }}", $this->name, $data);
        return str_replace("{{ Uname }}", ucfirst($this->name), $data);
    }
}