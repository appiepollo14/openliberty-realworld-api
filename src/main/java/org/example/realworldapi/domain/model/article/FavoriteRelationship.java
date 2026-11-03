package org.example.realworldapi.domain.model.article;

import java.util.Objects;
import org.example.realworldapi.domain.model.user.User;

public class FavoriteRelationship {
  private User user;
  private Article article;

  public User getUser() {
    return this.user;
  }

  public Article getArticle() {
    return this.article;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  public void setArticle(final Article article) {
    this.article = article;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof FavoriteRelationship that)) return false;
      return Objects.equals(getUser(), that.getUser()) && Objects.equals(getArticle(), that.getArticle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUser(), getArticle());
  }

  @Override
  public String toString() {
    return "FavoriteRelationship(user=" + this.getUser() + ", article=" + this.getArticle() + ")";
  }

  public FavoriteRelationship(final User user, final Article article) {
    this.user = user;
    this.article = article;
  }
}
