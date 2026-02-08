package com.helpdesk_auth_service.DTO;

import com.helpdesk_auth_service.entity.enums.Role;

import java.util.UUID;

public record UserCreatedEventDTO(UUID userId, String email, Role role) {}
