package com.amauri.sve.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Hidden
@RestController
@Configuration
public class SwaggerConfig {
	
	@GetMapping(value = "/")
	public void swagger(HttpServletRequest request, HttpServletResponse httpServletResponse) {	    
		String loc = "/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config";		
		httpServletResponse.setHeader("Location", loc);
	    httpServletResponse.setStatus(302);
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
		String appVersion = "1.0.0";
	   return new OpenAPI()
	    .components(new Components().addSecuritySchemes("basicScheme",
	            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
	    .info(new Info().title("Projeto SVE - API").version(appVersion)
	            .license(new License().name("SVE - Sistema de Vendas Eletrônico").url("http://amauri.seve.com")));
	}

}
