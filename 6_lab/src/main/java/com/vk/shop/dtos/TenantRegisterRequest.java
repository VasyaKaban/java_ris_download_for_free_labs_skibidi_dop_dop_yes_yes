package com.vk.shop.dtos;

public record TenantRegisterRequest(
        String email,
        String fullName,
        String password
) { }
