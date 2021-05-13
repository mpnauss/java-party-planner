package com.launchacademy.partyplanner.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="friends")
@Getter
@Setter
//@ToString(includeFieldNames = false)
@NoArgsConstructor
public class Friend {
  @Id
  @SequenceGenerator(name = "friends_generator", sequenceName = "friends_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friends_generator")
  @Column(name="id", nullable = false, unique = true)
  @ToString.Exclude private Integer id;

  @NotBlank
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @ManyToMany(mappedBy = "invitees")
  private Set<Party> parties = new HashSet<>();

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
