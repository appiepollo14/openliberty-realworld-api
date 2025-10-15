package org.example.realworldapi.application.web.model.request;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.realworldapi.domain.model.article.UpdateArticleInput;
import org.example.realworldapi.infrastructure.web.validation.constraint.AtLeastOneFieldMustBeNotNull;

@Getter
@Setter
@NoArgsConstructor
@AtLeastOneFieldMustBeNotNull
public class UpdateArticleRequest {

  private String title;

  private String description;

  private String body;

  public UpdateArticleInput toUpdateArticleInput(UUID authorId, String slug) {
    return new UpdateArticleInput(authorId, slug, this.title, this.description, this.body);
  }
}
