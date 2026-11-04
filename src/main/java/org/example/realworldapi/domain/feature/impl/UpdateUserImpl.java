package org.example.realworldapi.domain.feature.impl;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.util.UUID;
import org.example.realworldapi.domain.exception.EmailAlreadyExistsException;
import org.example.realworldapi.domain.exception.UsernameAlreadyExistsException;
import org.example.realworldapi.domain.feature.FindUserById;
import org.example.realworldapi.domain.feature.UpdateUser;
import org.example.realworldapi.domain.model.user.UpdateUserInput;
import org.example.realworldapi.domain.model.user.User;
import org.example.realworldapi.domain.model.user.UserRepository;
import org.example.realworldapi.domain.validator.ModelValidator;

@Dependent
public class UpdateUserImpl implements UpdateUser {

  @Inject private FindUserById findUserById;
  @Inject private UserRepository userRepository;
  @Inject private ModelValidator modelValidator;

  @Override
  public User handle(UpdateUserInput updateUserInput) {
    final var user = findUserById.handle(updateUserInput.id());
    checkValidations(updateUserInput, updateUserInput.id());
    updateFields(user, updateUserInput);
    userRepository.update(modelValidator.validate(user));
    return user;
  }

  private void updateFields(User user, UpdateUserInput updateUserInput) {
    if (isPresent(updateUserInput.username())) {
      user.setUsername(updateUserInput.username());
    }

    if (isPresent(updateUserInput.email())) {
      user.setEmail(updateUserInput.email());
    }

    if (isPresent(updateUserInput.bio())) {
      user.setBio(updateUserInput.bio());
    }

    if (isPresent(updateUserInput.image())) {
      user.setImage(updateUserInput.image());
    }
  }

  private void checkValidations(UpdateUserInput updateUserInput, UUID excludeId) {

    if (isPresent(updateUserInput.username())) {
      checkUsername(excludeId, updateUserInput.username());
    }

    if (isPresent(updateUserInput.email())) {
      checkEmail(excludeId, updateUserInput.email());
    }
  }

  private boolean isPresent(String property) {
    return property != null && !property.isEmpty();
  }

  private void checkUsername(UUID selfId, String username) {
    if (userRepository.existsUsername(selfId, username)) {
      throw new UsernameAlreadyExistsException();
    }
  }

  private void checkEmail(UUID selfId, String email) {
    if (userRepository.existsEmail(selfId, email)) {
      throw new EmailAlreadyExistsException();
    }
  }
}
