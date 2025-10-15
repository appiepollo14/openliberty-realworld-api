package org.example.realworldapi.domain.feature.impl;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.UUID;
import org.example.realworldapi.domain.exception.ArticleNotFoundException;
import org.example.realworldapi.domain.feature.FindArticleByAuthorAndSlug;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.article.ArticleRepository;

@Singleton
public class FindArticleByAuthorAndSlugImpl implements FindArticleByAuthorAndSlug {

  @Inject private ArticleRepository articleRepository;

  @Override
  public Article handle(UUID authorId, String slug) {
    return articleRepository
        .findByAuthorAndSlug(authorId, slug)
        .orElseThrow(ArticleNotFoundException::new);
  }
}
