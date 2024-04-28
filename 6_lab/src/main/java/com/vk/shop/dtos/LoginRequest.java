package com.vk.shop.dtos;

public record LoginRequest(
        String email,
        String password
) { }
