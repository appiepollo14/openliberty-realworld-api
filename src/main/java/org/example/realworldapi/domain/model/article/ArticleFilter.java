package org.example.realworldapi.domain.model.article;

import java.util.List;
import java.util.UUID;

public record ArticleFilter(
    int offset,
    int limit,
    UUID loggedUserId,
    List<String> tags,
    List<String> authors,
    List<String> favorited) {}
