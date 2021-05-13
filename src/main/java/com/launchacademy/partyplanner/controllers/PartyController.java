package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.FriendService;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class PartyController {

  private PartyService partyService;
  private FriendService friendService;

  @Autowired
  public PartyController(PartyService partyService, FriendService friendService) {
    this.partyService = partyService;
    this.friendService = friendService;
  }



  @GetMapping
  public String root() {
    return "redirect:/parties";
  }

  @GetMapping("/parties")
  public String getPartyList(Model model) {
    model.addAttribute("parties", partyService.findAll());
    return "parties/index";
  }

  @GetMapping("/parties/{index}")
  public String getPartyById(@PathVariable Integer index, Model model) {
    model.addAttribute("friends", friendService.findAll());
    model.addAttribute("party", partyService.findById(index));
    return "parties/show";
  }

  @GetMapping("/parties/new")
  public String addPartyForm(@ModelAttribute Party party) {
    return "parties/new";
  }

  @PostMapping
  public String addParty(@ModelAttribute Party party) {
    partyService.save(party);
    return "redirect:/parties/" + party.getId();
  }

  @PostMapping("parties/{index}")
  public String inviteFriend(@PathVariable Integer index, @ModelAttribute Friend friend, Model model) {
    Party party = partyService.findById(index);
//    Friend friendEntry = friendService.findById()
//    party.addInvitee(friend);
    System.out.println(friend.getId());
    partyService.addInvitee(party.getId(), friend.getId());
    model.addAttribute("friends", friendService.findAll());
    model.addAttribute("party", party);
    return "parties/show";
  }
}
