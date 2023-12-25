package br.com.tspaschoal.apicasadocodigo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello world");
	}
	
	@GetMapping(path = "/{name}")
	public ResponseEntity<String> hello(@PathVariable String name) {
		return ResponseEntity.ok(String.format("hello, %s", name.toUpperCase()));
	}

}
