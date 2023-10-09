package com.grpc.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

	private final GClientService gClientService;

	@GetMapping("/greeting")
	public String gerGreeting() {
		return gClientService.receiveGreeting();
	}
}
