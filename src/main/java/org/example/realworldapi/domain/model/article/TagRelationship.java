package org.example.realworldapi.domain.model.article;

import org.example.realworldapi.domain.model.tag.Tag;

public record TagRelationship(Article article, Tag tag) {}
