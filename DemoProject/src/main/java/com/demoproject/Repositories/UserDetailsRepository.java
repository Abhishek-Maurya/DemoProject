package com.demoproject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.model.UserDetails;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

}
