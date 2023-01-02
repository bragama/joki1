package com.project.projectakhir.service;

import com.project.projectakhir.entity.User;
import com.project.projectakhir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.saveAndFlush(user);
    }
    public User loginUser(String name, String password){
        return userRepository.getUserLogin(name, password);
    }


    public User updateUser(Long id,User user){
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isEmpty()){
            throw new RuntimeException("Id Not Enten");
        }
        return userRepository.saveAndFlush(user);
    }
}
