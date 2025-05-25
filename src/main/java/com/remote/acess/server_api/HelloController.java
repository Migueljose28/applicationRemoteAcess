package com.remote.acess.server_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

	@GetMapping("/hello")
	public String hello(){
		return "Olá do servidor Spring Boot!";
}

	@GetMapping("/status")
	public String status(){
		return "Servidor está online e funcionando!";


}
}


