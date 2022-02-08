## springcloud 集成dubbo

spring cloud 集成 dubbo，注册中心，使用nacos

## provider

### dependencies
```
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-dubbo</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.spring</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>1.0.11</version>
        </dependency>

    </dependencies>
```

### application.yml

```yaml
    server:
      port: 8080 # 自己定义
    
    spring:
      application:
        name: dubbo-provider
      main:
        allow-bean-definition-overriding: true
        allow-circular-references: true
      cloud:
        nacos:
          discovery:
            ephemeral: false
            server-addr: 127.0.0.1:8848
            username: nacos
            password: nacos
    
    # dubbo配置
    dubbo:
      scan:
        base-packages: com.example.provider.service
      registry:
        address: spring-cloud://localhost # 使用spring cloud的注册中心
        username: nacos
        password: nacos
      protocol:
        name: dubbo
        port: -1 # 端口从20880开始，自动增加

```

## consumer

### dependencies
```
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-dubbo</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.spring</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>1.0.11</version>
        </dependency>
    </dependencies>
```

### application.yml

```yaml
    server:
      port: 8081 # 重新开一个端口
    
    spring:
      application:
        name: dubbo-consumer
      main:
        allow-bean-definition-overriding: true
        allow-circular-references: true
      cloud:
        nacos:
          discovery:
            ephemeral: false
            server-addr: 127.0.0.1:8848
            username: nacos
            password: nacos
    
    # 配置dubbo
    dubbo:
      registry:
        address: spring-cloud://localhost # 使用spring cloud的注册中心
        username: nacos
        password: nacos
      protocol:
        name: dubbo
        port: -1 # 端口从20880开始，自动增加
      consumer:
        check: false

```
