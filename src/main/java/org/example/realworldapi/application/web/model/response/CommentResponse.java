package org.example.realworldapi.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import java.util.UUID;
import org.example.realworldapi.domain.model.comment.Comment;

@JsonRootName("comment")
public class CommentResponse {
  private UUID id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime createdAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime updatedAt;

  private String body;
  private ProfileResponse author;

  public CommentResponse(Comment comment, ProfileResponse author) {
    this.id = comment.getId();
    this.createdAt = comment.getCreatedAt();
    this.updatedAt = comment.getUpdatedAt();
    this.body = comment.getBody();
    this.author = author;
  }

  public UUID getId() {
    return this.id;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getBody() {
    return this.body;
  }

  public ProfileResponse getAuthor() {
    return this.author;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setBody(final String body) {
    this.body = body;
  }

  public void setAuthor(final ProfileResponse author) {
    this.author = author;
  }
}
