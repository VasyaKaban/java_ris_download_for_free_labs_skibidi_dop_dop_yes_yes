package com.vk.shop.business.abstracts;

import com.vk.shop.dtos.LoginRequest;
import com.vk.shop.dtos.LoginResponse;
import com.vk.shop.dtos.RefreshRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    void logout(RefreshRequest refreshRequest);

    LoginResponse refreshToken(RefreshRequest refreshRequest);
}
