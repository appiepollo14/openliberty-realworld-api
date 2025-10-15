package org.example.realworldapi.domain.feature.impl;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.UUID;
import org.example.realworldapi.domain.feature.IsArticleFavorited;
import org.example.realworldapi.domain.model.article.Article;
import org.example.realworldapi.domain.model.article.FavoriteRelationshipRepository;

@Singleton
public class IsArticleFavoritedImpl implements IsArticleFavorited {

  @Inject private FavoriteRelationshipRepository favoriteRelationshipRepository;

  @Override
  public boolean handle(Article article, UUID currentUserId) {
    return favoriteRelationshipRepository.isFavorited(article, currentUserId);
  }
}
