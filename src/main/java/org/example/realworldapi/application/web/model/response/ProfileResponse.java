package org.example.realworldapi.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.example.realworldapi.domain.model.user.User;

@JsonRootName("profile")
public class ProfileResponse {
  private String username;
  private String bio;
  private String image;
  private boolean following;

  public ProfileResponse(User user) {
    this.username = user.getUsername();
    this.bio = user.getBio();
    this.image = user.getImage();
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

  public void setUsername(final String username) {
    this.username = username;
  }

  public void setBio(final String bio) {
    this.bio = bio;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public void setFollowing(final boolean following) {
    this.following = following;
  }
}
