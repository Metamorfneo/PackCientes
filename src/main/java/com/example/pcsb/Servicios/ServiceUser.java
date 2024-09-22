package com.example.pcsb.Servicios;


import com.example.pcsb.Interfaces.UserRepository;
import com.example.pcsb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(PasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && PasswordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
