package org.example.realworldapi.domain.model.tag;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.UUID;
import org.example.realworldapi.domain.validator.ModelValidator;

@Singleton
public class TagBuilder {
  @Inject private ModelValidator modelValidator;

  public Tag build(String name) {
    return modelValidator.validate(new Tag(UUID.randomUUID(), name));
  }

  public Tag build(UUID id, String name) {
    return modelValidator.validate(new Tag(id, name));
  }
}
