<?php

namespace src\Command;

use src\Command;
use src\Config;

class GenerateServiceCommand extends Command
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
            $this->name = $names[1];
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
        $this->outPut("开始初始化{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-service:{$name}");

        $dir = __ROOT__."../{$modulePrefix}-{$module}";
        $serviceDir = __ROOT__."../{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-service";
        $groupname = implode("/", explode(".", $group));

        if (!is_dir($serviceDir."/src/main/java/{$groupname}/{$module}/service")) {
            $this->error("module:{$modulePrefix}-{$module}不存在...初始化失败，请先执行 generate:module");
        }

        $dirs = [
            $serviceDir."/src/main/java/{$groupname}/{$module}/dto",
            $serviceDir."/src/main/java/{$groupname}/{$module}/api",
            $serviceDir."/src/main/java/{$groupname}/{$module}/service",
            $serviceDir."/src/main/java/{$groupname}/{$module}/mapper",
        ];

        foreach ($dirs as $dir) {
            if (!is_dir($dir)) {
                mkdir($dir, 0755, true);
            }
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

        $this->outPut("初始化完成");
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