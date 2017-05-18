package com.dm.stu.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.dm.stu.dao")
public class MyBatisConfig {

}
