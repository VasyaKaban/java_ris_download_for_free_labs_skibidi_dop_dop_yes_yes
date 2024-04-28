package com.vk.shop.business.abstracts.concretes;

import com.vk.shop.business.abstracts.RoleService;
import com.vk.shop.config.concerns.loging.ToLog;
import com.vk.shop.entities.Role;
import com.vk.shop.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @ToLog
    @Transactional
    @Override
    public Role addRole(Role role) {
        return roleRepository.insert(role);
    }
}
