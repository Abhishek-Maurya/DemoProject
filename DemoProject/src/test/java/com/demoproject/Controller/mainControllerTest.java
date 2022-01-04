package com.demoproject.Controller;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.demoproject.dto.LoginDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class mainControllerTest {

	@Autowired
	MockMvc mockMvc;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Test
	void testcontroller_Producer_successfull() throws Exception {

		// setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword("test1111111111");
		dummy.setUsername("test88888888");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(dummy);

		// Act and assert
		mockMvc.perform(post("http://localhost:8080/login").contentType(APPLICATION_JSON_UTF8).content(value))
				.andExpect(status().isCreated());
	}

	@Test
	void testcontroller_Consumer_successfull() throws Exception {

		// setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword("test1111111111");
		dummy.setUsername("test88888888");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(dummy);

		// Act and assert
		mockMvc.perform(get("http://localhost:8080/consumerlogin").contentType(APPLICATION_JSON_UTF8).content(value))
				.andExpect(status().isFound());
	}

	@Test
	void testcontroller_Consumer_NotFound() throws Exception {

		// setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword("");
		dummy.setUsername("test88888888");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(dummy);

		// Act and assert
		mockMvc.perform(get("http://localhost:8080/consumerlogin").contentType(APPLICATION_JSON_UTF8).content(value))
				.andExpect(status().isNotFound());
	}

	@Test
	void testcontroller_Consumer_BadRequest() throws Exception {

		// setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword(null);
		dummy.setUsername("test88888888");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(dummy);

		// Act and assert
		mockMvc.perform(get("http://localhost:8080/consumerlogin").contentType(APPLICATION_JSON_UTF8).content(value))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testcontroller_Producer_BadRequest() throws Exception {

		// setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword(null);
		dummy.setUsername("test88888888");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String value = ow.writeValueAsString(dummy);

		// Act and assert
		mockMvc.perform(post("http://localhost:8080/login").contentType(APPLICATION_JSON_UTF8).content(value))
				.andExpect(status().isBadRequest());
	}
}
