package org.example.realworldapi.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.tag.Tag;

@JsonRootName("article")
public class ArticleResponse {
  private String slug;
  private String title;
  private String description;
  private String body;
  private final List<String> tagList;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime createdAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime updatedAt;

  private boolean favorited;
  private final long favoritesCount;
  private ProfileResponse author;

  public ArticleResponse(
      Article article, ProfileResponse author, long favoritesCount, List<Tag> tags) {
    this.slug = article.getSlug();
    this.title = article.getTitle();
    this.description = article.getDescription();
    this.body = article.getBody();
    this.createdAt = article.getCreatedAt();
    this.updatedAt = article.getUpdatedAt();
    this.author = author;
    this.favoritesCount = favoritesCount;
    this.tagList = tags.stream().map(Tag::getName).collect(Collectors.toList());
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

  public List<String> getTagList() {
    return this.tagList;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public ProfileResponse getAuthor() {
    return this.author;
  }

  public boolean isFavorited() {
    return this.favorited;
  }

  public long getFavoritesCount() {
    return this.favoritesCount;
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

  public void setFavorited(final boolean favorited) {
    this.favorited = favorited;
  }

  public void setAuthor(final ProfileResponse author) {
    this.author = author;
  }
}
