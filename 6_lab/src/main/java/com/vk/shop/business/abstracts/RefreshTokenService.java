package com.vk.shop.business.abstracts;

import com.vk.shop.entities.RefreshToken;


public interface RefreshTokenService {

    RefreshToken getRefreshTokenByToken(String refreshToken);

    RefreshToken generateRefreshToken(String email);

    void deleteRefreshToken(String refreshToken);

}
