package com.example.pcsb.Controladores;

import com.example.pcsb.Servicios.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ServiceUser serviceUser;

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestParam String email, @RequestParam String password) {
        if (serviceUser.registerUser(email, password) != null) {
            return ResponseEntity.ok("Usuario registrado correctamente");
        }else {
            return ResponseEntity.badRequest().body("Usuario no registrado");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestParam String email, @RequestParam String password) {
        if (serviceUser.loginUser(email, password) != null) {
            return ResponseEntity.ok("Usuario logeado correctamente");
        }else {
            return ResponseEntity.status(401).body("Usuario no logeado");
        }
    }


}
