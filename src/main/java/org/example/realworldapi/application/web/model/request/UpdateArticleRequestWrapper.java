package org.example.realworldapi.application.web.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateArticleRequestWrapper(@Valid @NotNull UpdateArticleRequest article) {}
