package com.helpdesk_auth_service.repository;

import com.helpdesk_auth_service.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, UUID> {

    boolean existsByEmail(String email);
    AuthUser findByEmail(String email);
}
