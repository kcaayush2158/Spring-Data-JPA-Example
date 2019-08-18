package com.application.demo.service;

import com.application.demo.dao.UserRepository;
import com.application.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initDB(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Aayush","IT",18));
        users.add(new User(2,"Rounak","Sales",17));
        users.add(new User(3,"Json","IT",23));
        users.add(new User(4,"Casper","IT",18));
        userRepository.saveAll(users);
    }

    public List<User> getUser(){

        return  userRepository.findAll();
    }

    public List<User> getUserByProfession(String profession){

        return userRepository.findByProfession(profession);
    }

    public long getCount(int age){
        return userRepository.countByAge(age);
    }
    public List<User> deleteUser(String name) {
        return userRepository.deleteByName(name);
    }

    public  List<User> findByMultipleCondition(String profession,int age){
        return userRepository.findByProfessionAndAge(profession,age);
    }

    public List<User> getUserIgnoreCase(String profession){
        return userRepository.findByProfessionIgnoreCase(profession);
    }

    public List<User> getUserSort(String field){
       return userRepository.findAll(new Sort(field));
    }

    public Page<User> getPaginatedUser(){
       return userRepository.findAll(new PageRequest(0,3));
    }

    public List<User> getUserCustomQuery(){
        return userRepository.getUserCustomQuery();
    }

}
