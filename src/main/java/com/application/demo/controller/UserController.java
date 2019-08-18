package com.application.demo.controller;

import com.application.demo.model.User;
import com.application.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

     @Autowired
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public List<User> getAllUser(){
        return userService.getUser();
    }

    @GetMapping(value = "/getUserByProfession/{profession}")
    public List<User> getUserByProfession(@PathVariable String profession){
        return userService.getUserByProfession(profession);
    }

    @GetMapping(value = "/getUserCount/{age}")
    public String getCountAge(@PathVariable int age){
         long userAge =  userService.getCount(age);
         return "Total no of records : "+userAge;
    }

    @RequestMapping(value = "/delete/{name}",method = RequestMethod.DELETE)
    public List<User> deleteUser(@PathVariable String name) {
        return userService.deleteUser(name);
    }

    @GetMapping(value = "/findMultiCondition/{profession}/{age}")
    public List<User> getUserByProfessionAndAge(@PathVariable  String profession , @PathVariable int age){
        return userService.findByMultipleCondition(profession,age);
    }
    //get the user by the profession
    @GetMapping(value = "/getUserIgnoreCase")
    public List<User> getUserByIgnoreCase(@RequestParam("profession") String profession){
        return userService.getUserIgnoreCase(profession);

    }
    //Shorting the data by using the field ie name ,age ,profession or id
    @GetMapping(value = "/getShort/{field}")
    public List<User> getSortedUser(@PathVariable String field){
        return userService.getUserSort(field);

    }
    // Pagination of the user with  only 3 data
    @GetMapping(value = "/getPaginatedData")
    public Page<User> getPaginatedRecords(){
        return userService.getPaginatedUser();
    }
    //Get the records by using the custom query
    @GetMapping(value = "/getRecordsByCustomQuery")
    public List<User> getUserByCostumQuery(){
        return userService.getUserCustomQuery();
    }



}
