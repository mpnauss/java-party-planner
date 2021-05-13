package com.launchacademy.partyplanner.services;
import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

  private PartyRepository partyRepository;

  @Autowired
  public PartyService(PartyRepository partyRepository) {
    this.partyRepository = partyRepository;
  }

  public List<Party> findAll() {
    return (List<Party>) this.partyRepository.findAll();
  }

  public Party findById(Integer index) {
    return partyRepository.findById(index).get();
  }

  public void save(Party party) {
    partyRepository.save(party);
  }

  @Modifying
  @Query( value="INSERT INTO parties_friends(party_id, friend_id) VALUES (:party, :friend)", nativeQuery = true)
  public void addInvitee(@Param("party")Integer partyId, @Param("friend")Integer friendId) {

  }
}
