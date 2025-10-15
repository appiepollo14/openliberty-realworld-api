package org.example.realworldapi.domain.model.comment;

import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public record DeleteCommentInput(UUID commentId, UUID authorId, String articleSlug) {}
