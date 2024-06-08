package com.tutor.service;

import com.tutor.entity.User;
import com.tutor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        return all;
    }

    public User createUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public User findByEmail(String email){
        User byEmail = userRepository.findByEmail(email);
        return byEmail;
    }

    public List<User> findByName(String name){
        List<User> byName = userRepository.findByName(name);
        return byName;
    }

    public void deleteByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    public boolean isEmailVerified(String email) {
        User user = userRepository.findByEmail(email);
        return user != null && user.isEmailVerified();
    }
}
