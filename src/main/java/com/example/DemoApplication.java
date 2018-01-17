package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan("microservice.qssj.mapper")// 也可以在每个mapper上添加@Mapper注释,否则会出现扫描不到mapper接口的情况
@EnableTransactionManagement// 如果mybatis中service实现类中加入事务注解，需要此处添加该注解
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
