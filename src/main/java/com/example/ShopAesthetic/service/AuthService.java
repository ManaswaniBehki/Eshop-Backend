package com.example.ShopAesthetic.service;

import com.example.ShopAesthetic.entity.Role;
import com.example.ShopAesthetic.payload.LoginDto;
import com.example.ShopAesthetic.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(String name);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}