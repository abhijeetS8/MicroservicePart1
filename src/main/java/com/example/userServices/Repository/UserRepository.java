package com.example.userServices.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userServices.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
