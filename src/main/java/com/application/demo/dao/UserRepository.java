package com.application.demo.dao;

import com.application.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByProfession(String profession);

    public long countByAge(int age);

    public List<User> deleteByName(String name);

    //multiple condition
    public List<User> findByProfessionAndAge(String profession ,int age);

    //ignore case
    public List<User> findByProfessionIgnoreCase(String profession);

    @Modifying
    @Query("select u from User u")
    public List<User> getUserCustomQuery();

}
