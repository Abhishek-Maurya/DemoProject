package com.demoproject.services;

import java.util.List;

import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;

public interface Consumer {
	
	public List<UserDetails> getdetails(LoginDTO user);

}
