package org.example.realworldapi.domain.model.user;

import java.util.UUID;

public record UpdateUserInput(UUID id, String username, String bio, String image, String email) {}
