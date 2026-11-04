package org.example.realworldapi.application.web.model.request;

import java.util.List;
import java.util.UUID;
import org.example.realworldapi.domain.model.article.NewArticleInput;

public class NewArticleRequest {
  private String title;
  private String description;
  private String body;
  private List<String> tagList;

  public NewArticleInput toNewArticleInput(UUID loggedUserId) {
    return new NewArticleInput(loggedUserId, this.title, this.description, this.body, this.tagList);
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

  public void setTagList(final List<String> tagList) {
    this.tagList = tagList;
  }
}
