package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer>{

    Optional<Role> findByRoleName(String roleName);

}