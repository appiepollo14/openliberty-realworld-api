package org.example.realworldapi.infrastructure.repository.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FAVORITE_RELATIONSHIP")
@NamedQueries({
  @NamedQuery(
      name = "FVREisFavorited",
      query =
          "select count(f) from FavoriteRelationshipEntity f where f.article.id = :articleId and f.user.id = :currentUserId"),
  @NamedQuery(
      name = "FVREfavoritesCount",
      query = "select count(f) from FavoriteRelationshipEntity f where f.article.id = :articleId"),
  @NamedQuery(
      name = "FVREfindByArticleAndUserID",
      query =
          "select f from FavoriteRelationshipEntity f where f.article.id = :articleId and f.user.id = :currentUserId")
})
public class FavoriteRelationshipEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(updatable = false)
  private ArticleEntity article;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(updatable = false)
  private UserEntity user;

  public FavoriteRelationshipEntity(UserEntity user, ArticleEntity article) {
    this.user = user;
    this.article = article;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FavoriteRelationshipEntity that = (FavoriteRelationshipEntity) o;
    return Objects.equals(user, that.user) && Objects.equals(article, that.article);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, article);
  }

  public Long getId() {
    return this.id;
  }

  public ArticleEntity getArticle() {
    return this.article;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setArticle(final ArticleEntity article) {
    this.article = article;
  }

  public void setUser(final UserEntity user) {
    this.user = user;
  }

  public FavoriteRelationshipEntity() {}
}
