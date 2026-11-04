package org.example.realworldapi.application.web.model.request;

import java.util.UUID;
import org.example.realworldapi.domain.model.article.UpdateArticleInput;
import org.example.realworldapi.infrastructure.web.validation.constraint.AtLeastOneFieldMustBeNotNull;

@AtLeastOneFieldMustBeNotNull
public class UpdateArticleRequest {
  private String title;
  private String description;
  private String body;

  public UpdateArticleInput toUpdateArticleInput(UUID authorId, String slug) {
    return new UpdateArticleInput(authorId, slug, this.title, this.description, this.body);
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

  public void setTitle(final String title) {
    this.title = title;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public void setBody(final String body) {
    this.body = body;
  }
}
