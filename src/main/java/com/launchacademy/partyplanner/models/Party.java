package com.launchacademy.partyplanner.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="parties")
@NoArgsConstructor
@Getter
@Setter
public class Party {
  @Id
  @SequenceGenerator(name="party_generator", sequenceName = "parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_generator")
  @Column(name="id", nullable = false)
  private Integer id;

  @Column(name="name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name="location", nullable = false)
  private String location;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name="parties_friends",
      joinColumns = { @JoinColumn(name="party_id")},
      inverseJoinColumns = { @JoinColumn(name="friend_id")}
  )
  Set<Friend> invitees = new HashSet();

  public void addInvitee(Friend friend) {
    this.invitees.add(friend);

  }
}
