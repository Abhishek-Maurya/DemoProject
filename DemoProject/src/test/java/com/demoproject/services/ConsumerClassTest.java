package com.demoproject.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demoproject.Repositories.UserDetailsRepository;
import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;

@ExtendWith(MockitoExtension.class)
class ConsumerClassTest {
	
	@InjectMocks
	ConsumerClass consumer;
	
	@Mock
	UserDetailsRepository repo;

	@Test
	void testGetdetails() {
		// Setup
		UserDetails Data1 = new UserDetails("test", "test");
		UserDetails Data2 = new UserDetails("test1", "test1");
		UserDetails Data3 = new UserDetails("test1", "test1");
		List<UserDetails> dummyData = new ArrayList<UserDetails>();
		dummyData.add(Data1);
		dummyData.add(Data2);
		dummyData.add(Data3);
		LoginDTO dummy = new LoginDTO();
		dummy.setPassword("test");
		dummy.setUsername("test");
		LoginDTO dummy1 = new LoginDTO();
		dummy1.setPassword("test1");
		dummy1.setUsername("test1");
		Mockito.when(repo.findAll()).thenReturn(dummyData);

		// Act
		List<UserDetails> result = consumer.getdetails(dummy);
		List<UserDetails> result1 = consumer.getdetails(dummy1);

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(2, result1.size());

	}

}
