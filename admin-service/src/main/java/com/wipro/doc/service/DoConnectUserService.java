package com.wipro.doc.service;

import java.util.List;

import com.wipro.doc.entity.DoConnectUser;

public interface DoConnectUserService {

    DoConnectUser registerUser(DoConnectUser user);

    DoConnectUser loginUser(String username, String password);

    List<DoConnectUser> getAllUsers();
    
    DoConnectUser getUserById(Long id); // Changed int to Long

    DoConnectUser updateUser(Long id, DoConnectUser user); // Changed int to Long

    void deleteUser(Long id); // Changed int to Long
}
