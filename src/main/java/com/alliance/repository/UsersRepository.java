package com.alliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.model.Users;

/**
 * @author Riya
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findByName(String name);

	//List<Users> findOne(Integer id);

}