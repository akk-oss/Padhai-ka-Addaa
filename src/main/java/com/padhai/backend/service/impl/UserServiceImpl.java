package com.padhai.backend.service.impl;

import com.padhai.backend.entity.User;
import com.padhai.backend.repository.UserRepository;
import com.padhai.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    @Override
    public User updateUser(Long id, User user) {

        User existing = getUserById(id);

        existing.setFullName(user.getFullName());
        existing.setEmail(user.getEmail());
        existing.setPhoneNumber(user.getPhoneNumber());
        existing.setRole(user.getRole());

        return userRepository.save(existing);

    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}