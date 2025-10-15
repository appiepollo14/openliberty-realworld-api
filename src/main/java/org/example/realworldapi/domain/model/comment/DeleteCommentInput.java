package org.example.realworldapi.domain.model.comment;

import java.util.UUID;

public record DeleteCommentInput(UUID commentId, UUID authorId, String articleSlug) {}
