package com.demoproject.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoproject.Repositories.UserDetailsRepository;
import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;
@Service
public class ConsumerClass implements Consumer {
	
	@Autowired
	private UserDetailsRepository getuser;

	//Consumer Service implementation to get records
	@Override
	public List<UserDetails> getdetails(LoginDTO user)
	{
		if((user.getUsername()!=null)&&(user.getPassword()!=null))
			{
			//Find all records
			List<UserDetails> alluser= getuser.findAll();
			//Filter the Records and get all the records for required user
			List<UserDetails> requser=alluser.stream().filter(p ->p.getUsername().equals(user.getUsername())&& p.getPassword().equals(user.getPassword())).collect(Collectors.toList());
			if(requser.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);	//throws exception is no record is found			
			else
				return requser;	
			}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST); //throws exception if details of user logging in is incomplete

	}
}
