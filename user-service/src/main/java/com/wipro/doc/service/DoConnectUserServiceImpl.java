package com.wipro.doc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.doc.entity.DoConnectUser;
import com.wipro.doc.repository.DoConnectUserRepository;

@Service
public class DoConnectUserServiceImpl implements DoConnectUserService {
    @Autowired
    private DoConnectUserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public DoConnectUser registerUser(DoConnectUser user) {
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public DoConnectUser loginUser(String username, String password) {
        DoConnectUser user = userRepository.findByUsername(username).orElse(null);
        return (user != null && passwordEncoder.matches(password, user.getPassword())) ? user : null;
    }

    @Override
    public List<DoConnectUser> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public DoConnectUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public DoConnectUser updateUser(Long id, DoConnectUser user) {
        DoConnectUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setRole(user.getRole());
            existingUser.setActive(user.isActive());
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(user.getPassword())); // Hash new password if provided
            }
            return userRepository.save(existingUser);
        }
        return null; // Or throw an exception if not found
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
