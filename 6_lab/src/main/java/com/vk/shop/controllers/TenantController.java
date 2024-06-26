package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.TenantService;
import com.vk.shop.entities.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("tenants/")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("getByEmail/{email}")
    public Tenant getByEmail(@PathVariable String email) {
        return tenantService.getTenantByEmail(email);
    }

    @PreAuthorize("hasAnyRole('TENANT')")
    @PostMapping("updateProfilePic/{userId}")
    public Tenant updateProfilePicture(@PathVariable String userId, @RequestPart("picture") MultipartFile multipartFile) {
        return tenantService.updateProfilePicture(userId, multipartFile);
    }
}
