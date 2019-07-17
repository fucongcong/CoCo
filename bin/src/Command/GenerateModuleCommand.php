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

        $names = explode(":", $input[0]);
        if (count($names) == 2) {
            $this->name = strtolower($names[1]);
            $this->module = strtolower($names[0]);
        } else {
            $this->error("正确的格式为 moduleName:name");
        }

        if (!preg_match('/^[a-zA-Z\s]+$/', $this->name)) {
            $this->error("名称只能为英文！");
        }

        $group = $this->group;
        $modulePrefix = $this->modulePrefix;
        $name = $this->name;
        $module = $this->module;
        $this->outPut("开始初始化{$modulePrefix}-{$module}-api:{$name}");

        $dir = __ROOT__."{$modulePrefix}-{$module}";
        //$serviceDir = __ROOT__."{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-service";
        $apiDir = __ROOT__."{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-api";
        //$daoDir = __ROOT__."{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-dao";

        $this->outPut('正在生成目录...');

        // if (is_dir($dir)) {
        //     $this->error('目录已存在...初始化失败');
        // }

        $groupname = implode("/", explode(".", $group));
        //mkdir($serviceDir."/src/main/java/{$group}/{$module}/service", 0755, true);
        if (!is_dir($apiDir."/src/main/java/{$groupname}/{$module}/api")) {
            //mkdir($apiDir."/src/main/java/{$groupname}/{$module}/api", 0755, true);
        }
        //mkdir($daoDir."/src/main/java/{$group}/{$module}/dao", 0755, true);

        $this->outPut('开始创建模板...');
        if (!file_exists($apiDir."/build.gradle")) {
            $data = $this->getFile("api/build.gradle.tpl");
            file_put_contents ($apiDir."/build.gradle", $data);
        } else {
            $this->outPut($apiDir."/build.gradle 文件已存在，已跳过");
        }

        // $data = $this->getFile("service.build.gradle.tpl", $service, $groupname);
        // file_put_contents ($serviceDir."/build.gradle", $data);

        // $data = $this->getFile("api.build.gradle.tpl", $service, $groupname);
        // file_put_contents ($apiDir."/build.gradle", $data);


        // $data = $this->getFile("Service.java.tpl", $service, $groupname);
        // file_put_contents ($apiDir."/src/main/java/{$groupname}/{$service}/api/".ucfirst($service)."Service.java", $data);
        // $data = $this->getFile("ServiceImpl.java.tpl", $service, $groupname);
        // file_put_contents ($serviceDir."/src/main/java/".ucfirst($service)."ServiceImpl.java", $data);
        // //exec("javac -d ".$serviceDir."/src/main/java/ ".ucfirst($service)."ServiceImpl.java");
        // $data = $this->getFile("ServiceProvider.java.tpl", $service, $groupname);
        // file_put_contents ($serviceDir."/src/main/java/ServiceProvider.java", $data);

        // //更新settings.gradle
        // $data = $this->getFile("settings.gradle.tpl", $service, $groupname);
        // file_put_contents(__ROOT__."settings.gradle", $data, FILE_APPEND);
        $this->outPut("初始化完成");

        //exec("gradle");
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