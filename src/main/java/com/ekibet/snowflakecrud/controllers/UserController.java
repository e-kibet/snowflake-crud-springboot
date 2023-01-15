package com.ekibet.snowflakecrud.controllers;


import com.ekibet.snowflakecrud.entity.User;
import com.ekibet.snowflakecrud.helpers.ApiResponse;
import com.ekibet.snowflakecrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            User userPost = userService
                    .createUser(new User(user.getFirstname(), user.getLastname(), user.getLocation(), user.getActive()));
            User customerList = userService.createUser(userPost);
            map.put("user", customerList);
            return ApiResponse.getApiResponse(true, "User info saved successfully.", 200, HttpStatus.OK, map);
        }catch (Exception e){
            e.printStackTrace();
            map.put("user", null);
            return ApiResponse.getApiResponse(false, e.getMessage(), 404, HttpStatus.NOT_FOUND, map);
        }
    }

    @GetMapping(value = "users")
    public ResponseEntity<Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        try{
            List<User> customer = userService.findAllUsers();
            map.put("users", customer);
            return ApiResponse.getApiResponse(true, "Request executed successful.",200, HttpStatus.OK, map);
        }catch (NoSuchElementException e){
            map.put("users", null);
            return ApiResponse.getApiResponse(false,"No records found.", 404, HttpStatus.NOT_FOUND, map);
        }
    }

    @PutMapping(value = "users")
    public ResponseEntity<Object> update(@RequestBody User user) {
        Optional customer1 =  userService.update(user);
        Map<String, Object> map = new HashMap<>();
        if(customer1.isPresent()){
            map.put("user", null);
            return ApiResponse.getApiResponse(true,"A user detail has been updated successful.", 200, HttpStatus.OK, map);
        }else {
            map.put("user", null);
            return ApiResponse.getApiResponse(false,"No update has been made.", 400, HttpStatus.NOT_FOUND, map);
        }
    }

    @DeleteMapping(value = "users")
    public ResponseEntity<Object> delete(@RequestBody User user) {
        Optional customer1 =  userService.delete(user);
        Map<String, Object> map = new HashMap<>();
        if(customer1.isPresent()){
            map.put("user", null);
            return ApiResponse.getApiResponse(true,"A user detail has been deleted successful.", 200, HttpStatus.OK, map);
        }else {
            map.put("user", null);
            return ApiResponse.getApiResponse(false,"No record found to be deleted.", 400, HttpStatus.NOT_FOUND, map);
        }
    }
}
