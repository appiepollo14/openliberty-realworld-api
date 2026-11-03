package org.example.realworldapi.application.web.model.request;

import jakarta.validation.Valid;

public record NewCommentRequestWrapper(@Valid NewCommentRequest comment) {}
