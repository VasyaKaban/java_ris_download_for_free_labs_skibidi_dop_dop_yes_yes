package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.RoleService;
import com.vk.shop.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles/")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

//    @PreAuthorize("hasAnyRole('AUTHORITY_ADMIN')")
    @PostMapping("add")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }
}
