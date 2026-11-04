package org.example.realworldapi.domain.model.comment;

import java.util.UUID;

public record NewCommentInput(UUID authorId, String articleSlug, String body) {}
