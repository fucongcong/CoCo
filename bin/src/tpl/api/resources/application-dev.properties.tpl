server.port = 8012

spring.flyway.check-location=false

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.datasource.url=jdbc:mysql://192.168.0.200:3306/cmcndb?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true
spring.datasource.username=cm
spring.datasource.password=123

spring.devtools.restart.enabled=true

### 日志

debug=false
trace=false

logging.file=runtime/log/{{ modulePrefix }}-{{ module }}.log
logging.level.{{ group }}=DEBUG
