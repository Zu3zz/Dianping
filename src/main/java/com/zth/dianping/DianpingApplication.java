package com.zth.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.zth.dianping"})
@MapperScan("com.zth.dianping.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DianpingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DianpingApplication.class, args);
	}

}
