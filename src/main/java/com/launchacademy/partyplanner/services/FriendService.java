package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

  private FriendRepository friendRepository;

  @Autowired
  public FriendService(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  public List<Friend> findAll() {
    return (List<Friend>) friendRepository.findAll();
  }

  public void save(Friend friend) {
    friendRepository.save(friend);
  }

  public Friend findById(Integer index) {
    return friendRepository.findById(index).get();
  }

}
