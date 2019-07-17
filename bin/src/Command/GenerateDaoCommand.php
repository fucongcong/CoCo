<?php

namespace src\Command;

use src\Command;
use src\Config;

class GenerateDaoCommand extends Command
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
        $this->outPut("开始初始化{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-dao:{$name}");

        $dir = __ROOT__."../{$modulePrefix}-{$module}";
        $daoDir = __ROOT__."../{$modulePrefix}-{$module}/{$modulePrefix}-{$module}-dao";
        $groupname = implode("/", explode(".", $group));

        if (!is_dir($daoDir."/src/main/java/{$groupname}/{$module}/dao")) {
            $this->error("module:{$modulePrefix}-{$module}不存在...初始化失败，请先执行 generate:module");
        }

        if (!is_dir($daoDir."/src/main/java/{$groupname}/{$module}/dao/entity")) {
            mkdir($daoDir."/src/main/java/{$group}/{$module}/dao/entity", 0755, true);
        }
        if (!is_dir($daoDir."/src/main/java/{$groupname}/{$module}/dao/repository")) {
            mkdir($daoDir."/src/main/java/{$group}/{$module}/dao/repository", 0755, true);
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