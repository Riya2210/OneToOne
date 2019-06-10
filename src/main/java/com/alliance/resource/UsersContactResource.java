package com.alliance.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alliance.model.Users;
import com.alliance.model.UsersContact;
import com.alliance.repository.UsersContactRepository;

/**
 * @author Riya
 *
 */
@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactResource {

	private UsersContactRepository usersContactRepository;

	public UsersContactResource(UsersContactRepository usersContactRepository) {
		this.usersContactRepository = usersContactRepository;
	}

	@GetMapping(value = "/all")
	public List<UsersContact> getUsersContact() {
		return usersContactRepository.findAll();
	}

	@GetMapping(value = "/update/{name}")
	public List<UsersContact> update(@PathVariable final String name) {

		UsersContact usersContact = new UsersContact();

		Users users = new Users();
		users.setTeamName("Development").setSalary(10000).setName(name);

		usersContact.setPhoneNo(11111).setUsers(users);

		usersContactRepository.save(usersContact);

		return usersContactRepository.findAll();

	}

}