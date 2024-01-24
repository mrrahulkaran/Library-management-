package com.library.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entities.User;
import com.library.management.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll() {
        return userRepo.findAll();
    }
	public User save(User user) {
        return userRepo.save(user);
    }

}
