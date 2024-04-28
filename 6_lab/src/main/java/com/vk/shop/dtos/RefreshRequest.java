package com.vk.shop.dtos;

public record RefreshRequest (
        String refreshToken,
        String email
) {
}
