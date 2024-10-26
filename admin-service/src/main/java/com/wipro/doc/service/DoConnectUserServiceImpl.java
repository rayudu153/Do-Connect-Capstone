package com.wipro.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doc.entity.DoConnectUser;
import com.wipro.doc.exception.ResourceNotFoundException;
import com.wipro.doc.repository.DoConnectUserRepository;

@Service
public class DoConnectUserServiceImpl implements DoConnectUserService {
    @Autowired
    private DoConnectUserRepository userRepository;

    @Override
    public DoConnectUser registerUser(DoConnectUser user) {
        return userRepository.save(user);
    }

    @Override
    public DoConnectUser loginUser(String username, String password) {
        DoConnectUser user = userRepository.findByUsername(username).orElse(null);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    @Override
    public List<DoConnectUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public DoConnectUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public DoConnectUser updateUser(Long id, DoConnectUser user) {
        DoConnectUser existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setRole(user.getRole());
        existingUser.setActive(user.isActive());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}