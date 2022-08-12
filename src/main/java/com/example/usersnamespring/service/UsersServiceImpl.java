package com.example.usersnamespring.service;


import com.example.usersnamespring.model.User;
import com.example.usersnamespring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        User user1 = userRepository.getOne(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        userRepository.save(user1);
    }

}