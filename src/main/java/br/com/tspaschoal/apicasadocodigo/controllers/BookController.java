package br.com.tspaschoal.apicasadocodigo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
	
	private final List<String> booksMocked = List.of("Inteligência Artificial e ChatGPT", "Product Marketing Essencial", "Transformação digital e cultura de produto");
	
	@GetMapping
	public ResponseEntity<List<String>> books() {
		return ResponseEntity.ok(booksMocked);
	}

}
