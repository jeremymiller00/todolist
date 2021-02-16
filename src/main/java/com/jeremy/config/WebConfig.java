package com.jeremy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 Configure the spring container (context)
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.jeremy")
public class WebConfig {



}
