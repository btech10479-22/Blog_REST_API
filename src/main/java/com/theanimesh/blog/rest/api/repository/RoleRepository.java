package com.theanimesh.blog.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import javax.management.relation.Role;
import com.theanimesh.blog.rest.api.entity.Role;

//Changed Above Import For smooth Run otherwise throw error

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}

