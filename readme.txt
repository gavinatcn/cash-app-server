V1.0.0

1. A simple project with Spring-boot web API structure.
2. Realizing the first web interface for application initialization with digital signature and validation.
3. Database configuration is necessary.

v1.1.0
1. Add mybatis-generator support by following steps:
    1) Add generatorConfig.xml;
    2) Add plugin, org.mybatis.generator, in pom.xml;
    3) Configure maven command, mybatis-generator;
    4) Configure file, generatorConfig.xml, for mysql;
    5) Specially, in "jdbc:mysql://127.0.0.1:3306/cash", "cash" is schema.
2. Support mybatis in Spring,
    1) Add dependency for mybatis, org.mybatis.spring.boot, in pom.xml;
    2) Modify CashAppServerApplication.java, adding "@MapperScan("com.yumi.cash.app.server.dal*")".
3. Configure database connection and mybatis properties in application.properties.
    Specially, in "jdbc:mysql://127.0.0.1:3306/cash", "cash" is schema.

v1.1.1
1. API, /proddetail
2. Update file, generatorConfig.xml, by setting "defaultModelType="flat"" to prevent genenrating "ResultMapWithBLOBs"


v1.2.0
1. Add log support using LogBack