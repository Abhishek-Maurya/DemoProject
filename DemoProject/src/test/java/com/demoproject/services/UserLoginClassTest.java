package com.demoproject.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demoproject.Repositories.UserDetailsRepository;
import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;


@ExtendWith(MockitoExtension.class)
class UserLoginClassTest {
	
	@InjectMocks
	UserLoginClass producer;
	
	@Mock
	UserDetailsRepository repo;

	@Test
	void testcheck() {
		// Setup
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword("0321654987");
		dummy.setUsername("22222");

		// Act
		UserDetails testresult = producer.login(dummy);
		List<UserDetails> result = new ArrayList<UserDetails>();
		result.add(testresult);

		// assert
		assertNotNull(result);
		assertEquals(1, result.size());
	}

}
