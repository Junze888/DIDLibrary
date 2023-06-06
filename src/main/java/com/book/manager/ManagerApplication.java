package com.book.manager;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.webank.weid.rpc.WeIdService;
import com.webank.weid.service.impl.WeIdServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger; //必须导这个包
import org.slf4j.LoggerFactory;

@EnableSwaggerBootstrapUI
@EnableJpaRepositories
@SpringBootApplication
public class ManagerApplication {
	public static WeIdService weIdService;
	public static void main(String[] args) {

		weIdService = new WeIdServiceImpl();
		SpringApplication.run(ManagerApplication.class, args);
		System.out.println("| ---------------------------------------------------------------------------------- |");
		System.out.println("|                                    Started Success                                 |");
		System.out.println("| ---------------------------------------------------------------------------------- |");
	}

}
