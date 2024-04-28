package com.vk.shop.business.abstracts;

import com.vk.shop.entities.Role;

public interface RoleService {

    Role findByRoleName(String roleName);

    Role addRole(Role role);

}
