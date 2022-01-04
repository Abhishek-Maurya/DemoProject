package com.demoproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demoproject.dto.LoginDTO;
import com.demoproject.model.UserDetails;
import com.demoproject.services.Consumer;
import com.demoproject.services.UserLogin;


@RestController
public class MainController {

	@Autowired
	private Consumer prd;
	@Autowired
	private UserLogin login;

	// Producer Login To Create Records
	@PostMapping("/login")
	public ResponseEntity<UserDetails> check(@RequestBody LoginDTO users) {
		UserDetails obj = login.login(users);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);//returns status code as 201 when created and the details of new created records
	}

	// Consumer Login To Check Records
	@GetMapping("/consumerlogin")
	public ResponseEntity<List<UserDetails>> getdetails(@RequestBody LoginDTO users) {
		List<UserDetails> all = prd.getdetails(users);
		return new ResponseEntity<>(all, HttpStatus.FOUND);//returns status code as 302 when records are found and the list of records

	}
}
