package com.crm;

import com.crm.feature.client.model.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@SpringBootApplication

public class CrmForHrApplication {

	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}


	//test
	@GetMapping("/getClients")
	public List<Client> getClients(){
		return Stream.of(new Client(),
				new Client()).
				collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(CrmForHrApplication.class, args);
	}

}
