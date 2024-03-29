package com.alliance.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alliance.model.Users;
import com.alliance.repository.UsersRepository;

/**
 * @author Riya
 *
 */
@RestController
@RequestMapping("/rest/users")

public class UsersResource {
	@Autowired
	UsersRepository usersRepository;

	@GetMapping("/all")
	public List<Users> getAll() {
		return usersRepository.findAll();
	}

	@GetMapping("/{name}")
	public List<Users> getUser(@PathVariable("name") final String name) {
		return usersRepository.findByName(name);

	}

	@GetMapping("/id/{id}")
	public Users getId(@PathVariable("id") final Integer id) {
		return usersRepository.findById(id).get();
	}

	@GetMapping("/update/{id}/{name}")
	public Users update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {

		Users users = getId(id);
		users.setName(name);

		return usersRepository.save(users);
	}
}
