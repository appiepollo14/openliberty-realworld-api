package org.example.realworldapi.domain.model.article;

import java.util.List;

public record PageResult<T>(List<T> result, long total) {}
