package org.example.realworldapi.domain.validator;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;
import org.example.realworldapi.domain.exception.ModelValidationException;

@Singleton
public class ModelValidator {

  @Inject private Validator validator;

  public <T> T validate(T model) {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(model);

    if (!constraintViolations.isEmpty()) {
      final var messages =
          constraintViolations.stream()
              .map(ConstraintViolation::getMessage)
              .collect(Collectors.toList());
      throw new ModelValidationException(messages);
    }

    return model;
  }
}
