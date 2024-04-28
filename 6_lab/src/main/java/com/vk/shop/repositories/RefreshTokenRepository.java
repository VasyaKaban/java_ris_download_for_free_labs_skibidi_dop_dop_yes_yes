package com.vk.shop.repositories;


import com.vk.shop.entities.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {

    Optional<RefreshToken> getRefreshTokenByToken(String refreshToken);

    RefreshToken saveRefreshToken(RefreshToken refreshToken);

    void deleteRefreshToken(String refreshToken);
}
