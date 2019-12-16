<?php

return [
    //初始化包和模块的信息配置
    'group' => "com.clothesmake",
    'modulePrefix' => "cm",

    //数据库配置 用于初始化entity字段
    'db' => [            
        "driver" => "pdo_mysql",
        "host" => "192.168.0.200",
        "port" => "3306",
        "dbname" => "cmcndb",
        "user" => "cm",
        "password" => "123",
    ],
];