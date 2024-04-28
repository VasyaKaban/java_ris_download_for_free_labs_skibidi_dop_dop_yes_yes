package com.vk.shop.dtos;

public record LoginResponse (
        String userId,
        String email,
        String accessToken,
        String refreshToken
) { }
