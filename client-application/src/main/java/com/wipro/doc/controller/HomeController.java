package com.wipro.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.doc.dto.DoConnectUserDTO;
import com.wipro.doc.service.ClientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String getHome() {
        return "homepage"; // Returns the homepage JSP
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; // Returns the login JSP page
    }
    
    @GetMapping("/adminHome")
    public String showAdminHomePage(Model model, HttpSession session) {
        DoConnectUserDTO user = (DoConnectUserDTO) session.getAttribute("user");
        if (user != null && "ADMIN".equalsIgnoreCase(user.getRole())) {
            List<DoConnectUserDTO> users = clientService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("adminName", user.getUsername());
            return "adminHome"; // Returns the adminHome JSP page
        } else {
            return "redirect:/login"; // Redirect to login if the user is not an admin
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        DoConnectUserDTO user = clientService.loginUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                List<DoConnectUserDTO> users = clientService.getAllUsers();
                model.addAttribute("users", users);
                model.addAttribute("adminName", user.getUsername());
                return "adminHome";
            } else {
                return "userHome";
            }
        } else {
            model.addAttribute("error", "Please provide a valid User Name or Password.");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute DoConnectUserDTO userDTO, Model model) {
        userDTO.setActive(true);

        boolean isRegistered = clientService.registerUser(userDTO);
        if (isRegistered) {
            model.addAttribute("success", "User registered successfully.");
            return "login";
        } else {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "register";
        }
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<DoConnectUserDTO> users = clientService.getAllUsers();
        model.addAttribute("users", users);
        return "manageUsers";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        DoConnectUserDTO user = clientService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute DoConnectUserDTO userDTO, Model model) {
        DoConnectUserDTO updatedUser = clientService.updateUser(id, userDTO);
        if (updatedUser == null) {
            model.addAttribute("error", "User not found.");
        }
        return "redirect:/users";
    }

    @GetMapping("/users/view/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        DoConnectUserDTO user = clientService.getUserById(id);
        model.addAttribute("user", user);
        return "viewUser";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        clientService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
    @GetMapping("/users/create")
    public String showCreateUserPage(Model model) {
        model.addAttribute("user", new DoConnectUserDTO());
        return "createUser"; // Returns the createUser JSP page
    }
    
    @PostMapping("/users/create")
    public String createUser(@ModelAttribute DoConnectUserDTO userDTO, Model model) {
        userDTO.setActive(true);

        boolean isRegistered = clientService.registerUser(userDTO);
        if (isRegistered) {
            model.addAttribute("success", "User registered successfully.");
            return "redirect:/users"; // Redirect to the user list after successful registration
        } else {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "createUser";
        }
    }
}
