<?php

namespace src;

class Console
{
    protected $argv;

    /**
     * 命令的定义集合
     *
     */
    protected $options = [
        'generate:module' => [
            'args' => 'moduleName',
            'command' => 'src\Command\GenerateModuleCommand',
            'help' => '初始化一个自定义模块'
        ],
        'generate:api' => [
            'args' => 'moduleName:name',
            'command' => 'src\Command\GenerateApiCommand',
            'help' => '初始化一个自定义api(moduleName:模块名, name:名称,以驼峰命名)'
        ],
        'generate:service' => [
            'args' => 'moduleName:name',
            'command' => 'src\Command\GenerateServiceCommand',
            'help' => '初始化一个自定义service(moduleName:模块名, name:名称,以驼峰命名)'
        ],
        'generate:dao' => [
            'args' => 'moduleName:name --table=表名称(可不填)',
            'command' => 'src\Command\GenerateDaoCommand',
            'help' => '初始化一个自定义dao(moduleName:模块名, name:名称,以驼峰命名)'
        ]
    ];

    protected $help = "
\033[35m              
  ____  ____   ____  ____  
_/ ___\/  _ \_/ ___\/  _ \ 
\  \__(  <_> )  \__(  <_> )
 \___  >____/ \___  >____/ 
     \/           \/       
\033[0m
\033[31m 使用帮助: \033[0m
\033[33m Usage: bin/console [options] [args...] \033[0m

";

    public function __construct($argv)
    {
        $this->argv = $argv;
    }

    /**
     * run the console
     *
     */
    public function run()
    {
        $this->checkArgv();

        printf($this->help);
        foreach ($this->options as $command => $option) {
            $option['args'] = isset($option['args']) ? $option['args'] : '';
            printf("%-70s %-s".PHP_EOL, "\033[32m ".$command."\033[0m"."\033[33m ".$option['args']."\033[0m", $option['help']);
        }
    }

    /**
     * 检查输入的参数与命令
     *
     */
    protected function checkArgv()
    {
        $argv = $this->argv;
        if (!isset($argv[1])) return;
        $options = $this->options;
        if (!isset($options[$argv[1]]['command'])) {

            $this->help = "\033[31m错误的命令！\033[0m".PHP_EOL;
            return;
        }

        $command = new $options[$argv[1]]['command'];
        $command->setArgv($argv);
        $command->init();
        die;
    }
}
