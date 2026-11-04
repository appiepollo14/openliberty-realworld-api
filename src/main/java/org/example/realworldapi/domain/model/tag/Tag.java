package org.example.realworldapi.domain.model.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class Tag {
  @NotNull private UUID id;
  @NotBlank private String name;

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Tag tag)) return false;
    return Objects.equals(getId(), tag.getId()) && Objects.equals(getName(), tag.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }

  @Override
  public String toString() {
    return "Tag(id=" + this.getId() + ", name=" + this.getName() + ")";
  }

  protected Tag(final UUID id, final String name) {
    this.id = id;
    this.name = name;
  }
}
