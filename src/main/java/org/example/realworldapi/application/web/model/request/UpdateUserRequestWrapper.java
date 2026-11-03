package org.example.realworldapi.application.web.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.realworldapi.domain.model.constants.ValidationMessages;

public record UpdateUserRequestWrapper(
    @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
        UpdateUserRequest user) {}
