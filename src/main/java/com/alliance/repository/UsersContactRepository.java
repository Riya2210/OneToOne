package com.alliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alliance.model.UsersContact;

/**
*@author Riya
*
*/
@Repository
public interface UsersContactRepository extends JpaRepository<UsersContact, Integer> {
}
