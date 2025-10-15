package org.example.realworldapi.domain.model.article;

import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public record UpdateArticleInput(
    UUID authorId, String slug, String title, String description, String body) {}
