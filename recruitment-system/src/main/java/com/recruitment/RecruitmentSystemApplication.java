package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 招聘网站主启动类
 *
 * @SpringBootApplication 是组合注解，包含：
 * - @SpringBootConfiguration  这是一个配置类
 * - @EnableAutoConfiguration  按 classpath 自动装配
 * - @ComponentScan            扫描当前包及子包
 */
@SpringBootApplication
public class RecruitmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentSystemApplication.class, args);
        System.out.println("""

                ====================================
                  招聘网站后端启动成功！
                  Spring Boot 版本: 3.2.2
                  Java 版本: 17
                ====================================
                """);
    }
}