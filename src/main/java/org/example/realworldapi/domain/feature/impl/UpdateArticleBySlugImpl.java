package org.example.realworldapi.domain.feature.impl;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.time.LocalDateTime;
import org.example.realworldapi.domain.feature.CreateSlugByTitle;
import org.example.realworldapi.domain.feature.FindArticleBySlug;
import org.example.realworldapi.domain.feature.UpdateArticleBySlug;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.article.ArticleRepository;
import org.example.realworldapi.domain.model.article.UpdateArticleInput;
import org.example.realworldapi.domain.validator.ModelValidator;

@Singleton
public class UpdateArticleBySlugImpl implements UpdateArticleBySlug {

  @Inject private FindArticleBySlug findArticleBySlug;
  @Inject private CreateSlugByTitle createSlugByTitle;
  @Inject private ArticleRepository articleRepository;
  @Inject private ModelValidator modelValidator;

  @Override
  public Article handle(UpdateArticleInput updateArticleInput) {
    final var article = findArticleBySlug.handle(updateArticleInput.slug());
    if (atLeastOneFieldIsNotBlank(updateArticleInput)) {
      if (isNotBlank(updateArticleInput.title())) {
        article.setSlug(createSlugByTitle.handle(updateArticleInput.title()));
        article.setTitle(updateArticleInput.title());
      }
      if (isNotBlank(updateArticleInput.description())) {
        article.setDescription(updateArticleInput.description());
      }
      if (isNotBlank(updateArticleInput.body())) {
        article.setBody(updateArticleInput.body());
      }
      article.setUpdatedAt(LocalDateTime.now());
      articleRepository.update(modelValidator.validate(article));
    }
    return article;
  }

  private boolean atLeastOneFieldIsNotBlank(UpdateArticleInput updateArticleInput) {
    return isNotBlank(updateArticleInput.title())
        || isNotBlank(updateArticleInput.description())
        || isNotBlank(updateArticleInput.body());
  }
}
