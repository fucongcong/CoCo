
### 脚手架使用

``` 
              
  ____  ____   ____  ____  
_/ ___\/  _ \_/ ___\/  _ \ 
\  \__(  <_> )  \__(  <_> )
 \___  >____/ \___  >____/ 
     \/           \/       

 使用帮助: 
 Usage: bin/console [options] [args...] 

 generate:module moduleName                          初始化一个自定义模块
 generate:api moduleName:name                        初始化一个自定义api(moduleName:模块名, name:名称,以驼峰命名)
 generate:service moduleName:name                    初始化一个自定义service(moduleName:模块名, name:名称,以驼峰命名)
 generate:dao moduleName:name                        初始化一个自定义dao(moduleName:模块名, name:名称,以驼峰命名)

```

#### 参数配置-前缀与包

修改 bin/config 文件的参数即可

### 应用模块

一个大模块分为3个子模块,3个模块互相独立(有依赖关系)
- api
- dao
- service

### 涉及到的组件

- spring-boot
- spring-data-jpa
- flyway
- lombok
- jackson
- mapstruct
- jwt
