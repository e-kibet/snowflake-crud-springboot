package com.ekibet.snowflakecrud.services;

import com.ekibet.snowflakecrud.entity.User;
import com.ekibet.snowflakecrud.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> findAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public Optional<User> update(User user) {
        return userRepository.findById(user.getId()).map(d -> {
            d.setFirstname(user.getFirstname());
            d.setLastname(user.getLastname());
            d.setLocation(user.getLocation());
            d.setActive(user.getActive());
            return d;
        });
    }

    @Transactional
    public Optional<User> delete(User user) {
        return userRepository.findById(user.getId()).map(d -> {
            userRepository.delete(d);
            return d;
        });
    }

}
