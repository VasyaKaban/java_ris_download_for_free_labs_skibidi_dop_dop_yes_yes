package com.vk.shop.business.abstracts;


import com.vk.shop.dtos.ReserveHouseRequest;
import com.vk.shop.dtos.TenantRegisterRequest;
import com.vk.shop.entities.House;
import com.vk.shop.entities.Tenant;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


public interface TenantService {

    Tenant getTenantByEmail(String email);

    Tenant saveTenant(TenantRegisterRequest tenantRegisterRequest);

    void addHouseToTenantsOwnHouse(House house, String email);
    void removeHouseFromTenantsOwnHouse(House house, String email);

    Tenant updateProfilePicture(String userId, MultipartFile multipartFile);

    void addHouseToTenantsVisitedHouses(House house, ReserveHouseRequest reserveHouseRequest);
}
