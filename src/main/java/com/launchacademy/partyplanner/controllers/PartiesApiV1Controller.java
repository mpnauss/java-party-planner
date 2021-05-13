package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parties")
public class PartiesApiV1Controller {
  private PartyApiRepository partyRepo;

  @Autowired

  public PartiesApiV1Controller(
      PartyApiRepository partyRepo) {
    this.partyRepo = partyRepo;
  }

  @GetMapping
  public Iterable<Party> getList() {
    return partyRepo.findAll();
  }
}
