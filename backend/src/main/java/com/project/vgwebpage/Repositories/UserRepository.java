package com.project.vgwebpage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vgwebpage.Entities.User;

//Check to change to JpaRepository
public interface UserRepository extends JpaRepository<User,Integer> {
    
}
