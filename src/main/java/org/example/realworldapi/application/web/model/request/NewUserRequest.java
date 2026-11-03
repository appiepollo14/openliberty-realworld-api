package org.example.realworldapi.application.web.model.request;

import jakarta.validation.constraints.NotNull;
import org.example.realworldapi.domain.model.constants.ValidationMessages;
import org.example.realworldapi.domain.model.user.CreateUserInput;

@NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
public class NewUserRequest {
  private String username;
  private String email;
  private String password;

  public CreateUserInput toCreateUserInput() {
    return new CreateUserInput(this.username, this.email, this.password);
  }

  public String getUsername() {
    return this.username;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}
