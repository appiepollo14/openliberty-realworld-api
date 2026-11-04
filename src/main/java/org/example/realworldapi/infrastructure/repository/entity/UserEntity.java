package org.example.realworldapi.infrastructure.repository.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import org.example.realworldapi.domain.model.user.User;

@Entity
@Table(name = "USERS")
public class UserEntity {
  @Id
  @Column(nullable = false, columnDefinition = "uuid")
  private UUID id;

  private String username;
  private String bio;
  private String image;
  private String password;
  private String email;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
  private List<ArticleEntity> articles;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<FollowRelationshipEntity> following;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "followed")
  private List<FollowRelationshipEntity> followedBy;

  public UserEntity(User user) {
    this.id = user.getId();
    update(user);
  }

  public void update(User user) {
    this.username = user.getUsername();
    this.bio = user.getBio();
    this.image = user.getImage();
    this.password = user.getPassword();
    this.email = user.getEmail();
  }

  public UUID getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getBio() {
    return this.bio;
  }

  public String getImage() {
    return this.image;
  }

  public String getPassword() {
    return this.password;
  }

  public String getEmail() {
    return this.email;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public void setBio(final String bio) {
    this.bio = bio;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public UserEntity() {}
}
