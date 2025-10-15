package org.example.realworldapi.domain.feature.impl;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import org.example.realworldapi.domain.feature.FindArticleBySlug;
import org.example.realworldapi.domain.feature.FindCommentsByArticleSlug;
import org.example.realworldapi.domain.model.comment.Comment;
import org.example.realworldapi.domain.model.comment.CommentRepository;

@Singleton
public class FindCommentsByArticleSlugImpl implements FindCommentsByArticleSlug {

  @Inject private FindArticleBySlug findArticleBySlug;
  @Inject private CommentRepository commentRepository;

  @Override
  public List<Comment> handle(String slug) {
    final var article = findArticleBySlug.handle(slug);
    return commentRepository.findCommentsByArticle(article);
  }
}
