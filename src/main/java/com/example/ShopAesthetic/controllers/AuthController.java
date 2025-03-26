package com.example.ShopAesthetic.controllers;

import com.example.ShopAesthetic.entity.Role;
import com.example.ShopAesthetic.payload.LoginDto;
import com.example.ShopAesthetic.payload.RegisterDto;
import com.example.ShopAesthetic.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        var data = authService.login(loginDto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto) {
        var data = authService.register(registerDto);
        return ResponseEntity.ok(data);
    }
//
//    @PostMapping("/role")
//    public ResponseEntity<String> createRole(@RequestBody String name) {
//        var data = authService.createRole(name);
//        return ResponseEntity.ok(data);
//    }
@PostMapping("/role")
public ResponseEntity<String> createRole(@RequestBody Map<String, String> request) {
    String roleName = request.get("name"); // Extract the name properly
    var data = authService.createRole(roleName);
    return ResponseEntity.ok(data);
}


    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        var data = authService.getAllRoles();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<String> getRoleByName(@PathVariable("name") String name) {
        var data = authService.getRoleByName(name);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/role/{name}")
    public ResponseEntity<String> deleteRole(@PathVariable("name") String name) {
        var data = authService.deleteRole(name);
        return ResponseEntity.ok(data);
    }

}