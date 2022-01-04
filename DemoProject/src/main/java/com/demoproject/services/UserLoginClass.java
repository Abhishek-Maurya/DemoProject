package com.demoproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoproject.Repositories.UserDetailsRepository;
import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;
@Service
public class UserLoginClass implements UserLogin {

	@Autowired
	private UserDetailsRepository adduser;

	//Producer Service to create new entry
	@Override
	public UserDetails login(LoginDTO user) {
		//check if user details are complete
		if((user.getPassword()!=null)&&(user.getUsername()!=null)&&(user.getPassword()!="")&&(user.getUsername()!="")&&(user.getPassword().length()>8)) {

			//Pass the user value to main model class to create new entry
			UserDetails obj=new UserDetails(user.getUsername(),user.getPassword());
			//save user details
			return adduser.save(obj);			
	}
		 throw new ResponseStatusException(HttpStatus.BAD_REQUEST);//throws exception if user details is incomplete
	}
}

	
	