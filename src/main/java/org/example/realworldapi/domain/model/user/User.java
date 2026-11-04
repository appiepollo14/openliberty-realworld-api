package org.example.realworldapi.domain.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;
import org.example.realworldapi.domain.model.constants.ValidationMessages;

public class User {
  @NotNull private UUID id;

  @NotBlank(message = ValidationMessages.USERNAME_MUST_BE_NOT_BLANK)
  private String username;

  @Email
  @NotBlank(message = ValidationMessages.EMAIL_MUST_BE_NOT_BLANK)
  private String email;

  @NotBlank(message = ValidationMessages.PASSWORD_MUST_BE_NOT_BLANK)
  private String password;

  private String bio;
  private String image;

  public UUID getId() {
    return this.id;
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

  public String getBio() {
    return this.bio;
  }

  public String getImage() {
    return this.image;
  }

  public void setId(final UUID id) {
    this.id = id;
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

  public void setBio(final String bio) {
    this.bio = bio;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof User user)) return false;
    return Objects.equals(getId(), user.getId())
        && Objects.equals(getUsername(), user.getUsername())
        && Objects.equals(getEmail(), user.getEmail())
        && Objects.equals(getPassword(), user.getPassword())
        && Objects.equals(getBio(), user.getBio())
        && Objects.equals(getImage(), user.getImage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUsername(), getEmail(), getPassword(), getBio(), getImage());
  }

  @Override
  public String toString() {
    return "User(id="
        + this.getId()
        + ", username="
        + this.getUsername()
        + ", email="
        + this.getEmail()
        + ", password="
        + this.getPassword()
        + ", bio="
        + this.getBio()
        + ", image="
        + this.getImage()
        + ")";
  }

  protected User(
      final UUID id,
      final String username,
      final String email,
      final String password,
      final String bio,
      final String image) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.bio = bio;
    this.image = image;
  }
}
