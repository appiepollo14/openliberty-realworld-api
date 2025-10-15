package org.example.realworldapi.domain.model.article;

import lombok.AllArgsConstructor;
import org.example.realworldapi.domain.model.tag.Tag;

@AllArgsConstructor
public record TagRelationship(Article article, Tag tag) {}
