package org.example.realworldapi.application.web.model.request;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import org.example.realworldapi.domain.model.comment.NewCommentInput;
import org.example.realworldapi.domain.model.constants.ValidationMessages;

public class NewCommentRequest {
  @NotBlank(message = ValidationMessages.BODY_MUST_BE_NOT_BLANK)
  private String body;

  public NewCommentInput toNewCommentInput(UUID authorId, String articleSlug) {
    return new NewCommentInput(authorId, articleSlug, this.body);
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(final String body) {
    this.body = body;
  }
}
