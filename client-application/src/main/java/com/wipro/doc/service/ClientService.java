package com.wipro.doc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.doc.dto.DoConnectUserDTO;

@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_API_URL = "http://localhost:8082/api";

    public DoConnectUserDTO loginUser(String username, String password) {
        DoConnectUserDTO[] users = restTemplate.getForObject(BASE_API_URL + "/users", DoConnectUserDTO[].class);
        List<DoConnectUserDTO> userList = Arrays.asList(users);
        
        System.out.println(userList.size());
        return userList.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public List<DoConnectUserDTO> getAllUsers() {
        DoConnectUserDTO[] users = restTemplate.getForObject(BASE_API_URL + "/users", DoConnectUserDTO[].class);
        return Arrays.asList(users);
    }

    public DoConnectUserDTO getUserById(Long id) {
        String url = BASE_API_URL + "/users/" + id;
        return restTemplate.getForObject(url, DoConnectUserDTO.class);
    }

    public boolean registerUser(DoConnectUserDTO userDTO) {
        String url = BASE_API_URL + "/users/register";
        DoConnectUserDTO response = restTemplate.postForObject(url, userDTO, DoConnectUserDTO.class);
        return response != null;
    }

    public DoConnectUserDTO updateUser(Long id, DoConnectUserDTO userDTO) {
        String url = BASE_API_URL + "/users/" + id;
        restTemplate.put(url, userDTO);
        return userDTO;
    }

    public void deleteUserById(Long id) {
        String url = BASE_API_URL + "/users/" + id;
        restTemplate.delete(url);
    }

    public DoConnectUserDTO getFirstUser() {
        List<DoConnectUserDTO> userList = getAllUsers();
        return userList.isEmpty() ? null : userList.get(0);
    }
}
