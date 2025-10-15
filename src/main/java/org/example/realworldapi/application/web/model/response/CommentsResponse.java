package org.example.realworldapi.application.web.model.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsResponse {

  private List<CommentResponse> comments;

  public CommentsResponse(List<CommentResponse> comments) {
    this.comments = comments;
  }
}
