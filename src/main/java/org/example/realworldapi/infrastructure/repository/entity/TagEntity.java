package org.example.realworldapi.infrastructure.repository.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import org.example.realworldapi.domain.model.tag.Tag;

@Entity
@Table(name = "TAGS")
@NamedQueries({
  @NamedQuery(
      name = "TagEntity.findByNamesIgnoreCase",
      query = "select t from TagEntity t where upper(t.name) in :names")
})
public class TagEntity {
  @Id
  @Column(columnDefinition = "uuid")
  private UUID id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private List<TagRelationshipEntity> articlesTags;

  public TagEntity(Tag tag) {
    this.id = tag.getId();
    this.name = tag.getName();
  }

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

  public TagEntity() {}
}
