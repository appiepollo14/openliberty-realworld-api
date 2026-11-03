package org.example.realworldapi.domain.model.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.user.User;

public class Comment {
  @NotNull private final UUID id;
  @NotNull private final User author;
  @NotNull private final Article article;
  @NotBlank private final String body;
  @NotNull private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  public UUID getId() {
    return this.id;
  }

  public User getAuthor() {
    return this.author;
  }

  public Article getArticle() {
    return this.article;
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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Comment comment = (Comment) o;
    return Objects.equals(getId(), comment.getId()) && Objects.equals(getAuthor(), comment.getAuthor()) && Objects.equals(getArticle(), comment.getArticle()) && Objects.equals(getBody(), comment.getBody()) && Objects.equals(getCreatedAt(), comment.getCreatedAt()) && Objects.equals(getUpdatedAt(), comment.getUpdatedAt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getAuthor(), getArticle(), getBody(), getCreatedAt(), getUpdatedAt());
  }

  @Override
  public String toString() {
    return "Comment(id="
        + this.getId()
        + ", author="
        + this.getAuthor()
        + ", article="
        + this.getArticle()
        + ", body="
        + this.getBody()
        + ", createdAt="
        + this.getCreatedAt()
        + ", updatedAt="
        + this.getUpdatedAt()
        + ")";
  }

  protected Comment(
      final UUID id,
      final User author,
      final Article article,
      final String body,
      final LocalDateTime createdAt,
      final LocalDateTime updatedAt) {
    this.id = id;
    this.author = author;
    this.article = article;
    this.body = body;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
