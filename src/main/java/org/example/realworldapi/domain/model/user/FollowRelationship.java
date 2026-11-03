package org.example.realworldapi.domain.model.user;

import java.util.Objects;

public class FollowRelationship {
  private User user;
  private User followed;

  public User getUser() {
    return this.user;
  }

  public User getFollowed() {
    return this.followed;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof FollowRelationship that)) return false;
      return Objects.equals(getUser(), that.getUser()) && Objects.equals(getFollowed(), that.getFollowed());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUser(), getFollowed());
  }

  @Override
  public String toString() {
    return "FollowRelationship(user=" + this.getUser() + ", followed=" + this.getFollowed() + ")";
  }

  public FollowRelationship(final User user, final User followed) {
    this.user = user;
    this.followed = followed;
  }
}
