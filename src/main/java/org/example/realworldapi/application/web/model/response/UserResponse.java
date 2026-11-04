package org.example.realworldapi.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.example.realworldapi.domain.model.user.User;

@JsonRootName("user")
public class UserResponse {
  private String username;
  private String bio;
  private String image;
  private String email;
  private String token;

  public UserResponse(User user, String token) {
    this.username = user.getUsername();
    this.bio = user.getBio();
    this.image = user.getImage();
    this.email = user.getEmail();
    this.token = token;
  }

  public String getUsername() {
    return this.username;
  }

  public String getBio() {
    return this.bio;
  }

  public String getImage() {
    return this.image;
  }

  public String getEmail() {
    return this.email;
  }

  public String getToken() {
    return this.token;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public void setBio(final String bio) {
    this.bio = bio;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setToken(final String token) {
    this.token = token;
  }
}
