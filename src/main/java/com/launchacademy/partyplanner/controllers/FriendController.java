package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friends")
public class FriendController {
  private FriendService friendService;

  @Autowired
  public FriendController(FriendService friendService) {
    this.friendService = friendService;
  }

  @GetMapping
  public String getFriendsList(Model model) {
    model.addAttribute("friends", friendService.findAll());
    return "friends/index";
  }

  @GetMapping("/new")
  public String addFriendForm(@ModelAttribute Friend friend) {
    return "friends/new";
  }

  @PostMapping
  public String addFriend(@ModelAttribute Friend friend) {
    friendService.save(friend);
    return "redirect:/friends";
  }


}
