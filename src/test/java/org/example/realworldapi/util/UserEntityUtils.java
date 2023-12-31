package org.example.realworldapi.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.realworldapi.infrastructure.repository.entity.UserEntity;

import java.util.UUID;

public class UserEntityUtils {

    public static UserEntity create(String username, String email, String userPassword) {
        final var userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setUsername(username);
        userEntity.setEmail(email);
        userEntity.setPassword(BCrypt.withDefaults().hashToString(12, userPassword.toCharArray()));
        return userEntity;
    }

    public static UserEntity create(UUID id, String username, String email, String userPassword) {
        final var userEntity = create(username, email, userPassword);
        userEntity.setId(id);
        return userEntity;
    }

    public static UserEntity create(
            String username, String email, String userPassword, String bio, String image) {
        final var userEntity = create(username, email, userPassword);
        userEntity.setBio(bio);
        userEntity.setImage(image);
        return userEntity;
    }
}
