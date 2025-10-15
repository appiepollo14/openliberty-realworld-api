package org.example.realworldapi.domain.model.article;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewArticleInput {
  private UUID authorId;
  private String title;
  private String description;
  private String body;
  private List<String> tagList;
}
