package com.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    
    @GetMapping("/login")
    public String adminLoginForm() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute("admin", "true");
            return "redirect:/dashboard";
        } else {
            return "admin-login";
        }
    }
}
