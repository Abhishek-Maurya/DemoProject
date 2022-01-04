package com.demoproject.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDetailsTest {

	@Test
	void testusermodel() {

		// setup and act
		UserDetails user = new UserDetails();
		user.setId("dummyID");
		user.setDate("2022-01-01");
		user.setEntryTime("22:12");
		user.setProductCode(1);
		user.setProductprice(12);
		user.setProductStock(2);
		user.setProductWeight(14);
		user.setUserval(1);
		UserDetails.setUsercount(4);

		// Assert

		assertEquals("dummyID", user.getId());
		assertEquals("2022-01-01", user.getDate());
		assertEquals("22:12", user.getEntryTime());
		assertEquals(1, user.getProductCode());
		assertEquals(12, user.getProductprice());
		assertEquals(2, user.getProductStock());
		assertEquals(14, user.getProductWeight());
		assertEquals(1, user.getUserval());
		assertEquals(4, UserDetails.getUsercount());
	}

}
