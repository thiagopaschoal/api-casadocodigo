package br.com.tspaschoal.apicasadocodigo.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
	
	private static final String BASE_RESOURCE = "/v1/books";

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Deve retornar todos os livros já registrados")
	public void testShouldReturnBooksRegistered() throws Exception {
		mockMvc.perform(get(BASE_RESOURCE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0]", equalTo("Inteligência Artificial e ChatGPT")))
				.andExpect(jsonPath("$[1]", equalTo("Product Marketing Essencial")))
				.andExpect(jsonPath("$[2]", equalTo("Transformação digital e cultura de produto")));
	}

}
