package br.com.tspaschoal.apicasadocodigo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
	
	private static final String BASE_RESOURCE = "/hello";

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Deve retornar a mensagem 'hello world'")
	public void testShouldReturnHelloWorldMessage() throws Exception {
		mockMvc.perform(get(BASE_RESOURCE))
				.andExpect(status().isOk())
				.andExpect(content().string("hello world"));
	}

	@Test
	@DisplayName("Deve retornar a mensagem 'hello world' com nome concatenado")
	public void testShouldReturnHelloWorldWithNameMessage() throws Exception {
		mockMvc.perform(get(BASE_RESOURCE + "/{name}", "thiago"))
			.andExpect(status().isOk())
			.andExpect(content().string("hello, THIAGO"));
	}

}
