package org.example.realworldapi.infrastructure.repository.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.example.realworldapi.domain.model.article.Article;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ARTICLES")
@NamedQueries({
  @NamedQuery(
      name = "ArticleEntity.findBySlugIgnoreCaseAndAuthor_Id",
      query =
          "select a from ArticleEntity a where upper(a.slug) = :slug and a.author.id = :authorId")
})
public class ArticleEntity {
  @Id
  @Column(nullable = false, columnDefinition = "uuid")
  private UUID id;

  private String slug;
  private String title;
  private String description;
  private String body;
  @CreationTimestamp private LocalDateTime createdAt;
  @UpdateTimestamp private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
  private UserEntity author;

  @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
  private List<CommentEntity> comments;

  @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
  private List<TagRelationshipEntity> tags;

  @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
  private List<FavoriteRelationshipEntity> favorites;

  public ArticleEntity(Article article, UserEntity author) {
    this.id = article.getId();
    this.createdAt = article.getCreatedAt();
    this.author = author;
    update(article);
  }

  public void update(Article article) {
    this.slug = article.getSlug();
    this.title = article.getTitle();
    this.description = article.getDescription();
    this.body = article.getBody();
    this.updatedAt = article.getUpdatedAt();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ArticleEntity that = (ArticleEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public UUID getId() {
    return this.id;
  }

  public String getSlug() {
    return this.slug;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public String getBody() {
    return this.body;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public UserEntity getAuthor() {
    return this.author;
  }

  public List<CommentEntity> getComments() {
    return this.comments;
  }

  public List<TagRelationshipEntity> getTags() {
    return this.tags;
  }

  public List<FavoriteRelationshipEntity> getFavorites() {
    return this.favorites;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public void setSlug(final String slug) {
    this.slug = slug;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public void setBody(final String body) {
    this.body = body;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setAuthor(final UserEntity author) {
    this.author = author;
  }

  public void setComments(final List<CommentEntity> comments) {
    this.comments = comments;
  }

  public void setTags(final List<TagRelationshipEntity> tags) {
    this.tags = tags;
  }

  public void setFavorites(final List<FavoriteRelationshipEntity> favorites) {
    this.favorites = favorites;
  }

  public ArticleEntity(
      final UUID id,
      final String slug,
      final String title,
      final String description,
      final String body,
      final LocalDateTime createdAt,
      final LocalDateTime updatedAt,
      final UserEntity author,
      final List<CommentEntity> comments,
      final List<TagRelationshipEntity> tags,
      final List<FavoriteRelationshipEntity> favorites) {
    this.id = id;
    this.slug = slug;
    this.title = title;
    this.description = description;
    this.body = body;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.author = author;
    this.comments = comments;
    this.tags = tags;
    this.favorites = favorites;
  }

  public ArticleEntity() {}
}
