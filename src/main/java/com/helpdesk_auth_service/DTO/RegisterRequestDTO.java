package com.helpdesk_auth_service.DTO;

import com.helpdesk_auth_service.entity.enums.Role;

public record RegisterRequestDTO(String email, String password, Role role) {}
