package com.vk.shop.business.abstracts.concretes;

import com.vk.shop.business.abstracts.RefreshTokenService;
import com.vk.shop.config.jwt.JwtProviderService;
import com.vk.shop.entities.RefreshToken;
import com.vk.shop.repositories.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProviderService jwtProviderService;

    @Autowired
    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository,
                                   JwtProviderService jwtProviderService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtProviderService = jwtProviderService;
    }

    @Override
    public RefreshToken getRefreshTokenByToken(String refreshToken) {

        return refreshTokenRepository.getRefreshTokenByToken(refreshToken)
                .orElse(null);
    }

    @Transactional
    @Override
    public RefreshToken generateRefreshToken(String email) {

        String generatedRefreshToken = jwtProviderService.generateRefreshToken(email);

        RefreshToken refreshToken = new RefreshToken(
                generatedRefreshToken,
                email,
                new Date()
            );

        return refreshTokenRepository.saveRefreshToken(refreshToken);
    }

    @Transactional
    @Override
    public void deleteRefreshToken(String refreshToken) {
        boolean present = refreshTokenRepository.getRefreshTokenByToken(refreshToken).isPresent();

        if (!present)
            throw new RuntimeException("Refresh Token not found");

        refreshTokenRepository.deleteRefreshToken(refreshToken);
    }
}
