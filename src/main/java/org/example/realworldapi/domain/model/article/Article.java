package org.example.realworldapi.domain.model.article;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import org.example.realworldapi.domain.model.constants.ValidationMessages;
import org.example.realworldapi.domain.model.user.User;

public class Article {
  @NotNull private UUID id;
  @NotBlank private String slug;

  @NotBlank(message = ValidationMessages.TITLE_MUST_BE_NOT_BLANK)
  private String title;

  @NotBlank(message = ValidationMessages.DESCRIPTION_MUST_BE_NOT_BLANK)
  private String description;

  @NotBlank(message = ValidationMessages.BODY_MUST_BE_NOT_BLANK)
  private String body;

  @NotNull private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  @NotNull private User author;

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

  public User getAuthor() {
    return this.author;
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

  public void setAuthor(final User author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Article article)) return false;
    return Objects.equals(getId(), article.getId())
        && Objects.equals(getSlug(), article.getSlug())
        && Objects.equals(getTitle(), article.getTitle())
        && Objects.equals(getDescription(), article.getDescription())
        && Objects.equals(getBody(), article.getBody())
        && Objects.equals(getCreatedAt(), article.getCreatedAt())
        && Objects.equals(getUpdatedAt(), article.getUpdatedAt())
        && Objects.equals(getAuthor(), article.getAuthor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(),
        getSlug(),
        getTitle(),
        getDescription(),
        getBody(),
        getCreatedAt(),
        getUpdatedAt(),
        getAuthor());
  }

  @Override
  public String toString() {
    return "Article(id="
        + this.getId()
        + ", slug="
        + this.getSlug()
        + ", title="
        + this.getTitle()
        + ", description="
        + this.getDescription()
        + ", body="
        + this.getBody()
        + ", createdAt="
        + this.getCreatedAt()
        + ", updatedAt="
        + this.getUpdatedAt()
        + ", author="
        + this.getAuthor()
        + ")";
  }

  protected Article(
      final UUID id,
      final String slug,
      final String title,
      final String description,
      final String body,
      final LocalDateTime createdAt,
      final LocalDateTime updatedAt,
      final User author) {
    this.id = id;
    this.slug = slug;
    this.title = title;
    this.description = description;
    this.body = body;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.author = author;
  }
}
