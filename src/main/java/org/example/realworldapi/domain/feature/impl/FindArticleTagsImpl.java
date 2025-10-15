package org.example.realworldapi.domain.feature.impl;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;
import org.example.realworldapi.domain.feature.FindArticleTags;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.article.TagRelationshipRepository;
import org.example.realworldapi.domain.model.tag.Tag;

@Singleton
public class FindArticleTagsImpl implements FindArticleTags {

  @Inject private TagRelationshipRepository tagRelationshipRepository;

  @Override
  public List<Tag> handle(Article article) {
    return tagRelationshipRepository.findArticleTags(article);
  }
}
