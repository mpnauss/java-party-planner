package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.repositories.FriendApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/friends")
public class FriendsApiV1Controller {
  private FriendApiRepository friendRepo;

  @Autowired
  public FriendsApiV1Controller(
      FriendApiRepository friendRepo) {
    this.friendRepo = friendRepo;
  }

  @GetMapping
  public Iterable<Friend> getList() {
    return friendRepo.findAll();
  }
}
