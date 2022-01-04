package com.demoproject.services;

import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;

public interface UserLogin {

	public UserDetails login(LoginDTO user);

}
