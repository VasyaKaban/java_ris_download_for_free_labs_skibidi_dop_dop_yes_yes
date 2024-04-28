package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.AuthService;
import com.vk.shop.business.abstracts.TenantService;
import com.vk.shop.dtos.LoginRequest;
import com.vk.shop.dtos.LoginResponse;
import com.vk.shop.dtos.RefreshRequest;
import com.vk.shop.dtos.TenantRegisterRequest;
import com.vk.shop.entities.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/")
public class AuthController {

    private final AuthService authService;
    private final TenantService tenantService;

    @Autowired
    public AuthController(AuthService authService, TenantService tenantService) {
        this.authService = authService;
        this.tenantService = tenantService;
    }

    @PostMapping("register")
    public Tenant register(@RequestBody TenantRegisterRequest tenantRegisterRequest) {
        return tenantService.saveTenant(tenantRegisterRequest);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("logout")
    public String logout(@RequestBody RefreshRequest refreshRequest) {
        authService.logout(refreshRequest);
        return "LoggedOut";
    }

    @PostMapping("refresh/accessToken")
    public LoginResponse refreshToken(@RequestBody RefreshRequest refreshRequest) {
        return authService.refreshToken(refreshRequest);
    }
}
