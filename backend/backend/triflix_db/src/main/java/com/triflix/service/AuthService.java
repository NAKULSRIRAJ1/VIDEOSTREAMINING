package com.triflix.service;

import com.triflix.model.User;
import com.triflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register User
    public void registerUser(User user) {
        // Encrypt the password before saving it to the database
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    // Authenticate User
    public String authenticateUser(User user) {
        // Validate the user's credentials (for simplicity, assume successful authentication here)
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generate a token (you can use JWT here)
            return "GeneratedAuthToken";  // Replace with actual token generation logic
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
