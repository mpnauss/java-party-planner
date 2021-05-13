package com.launchacademy.partyplanner.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PartySeeder implements CommandLineRunner {

  private PartyRepository partyRepository;

  @Autowired
  public PartySeeder(PartyRepository partyRepository) {
    this.partyRepository = partyRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    if (Lists.newArrayList(partyRepository.findAll()).size() == 0) {
      Party party1 = new Party();
      party1.setName("Chadmas");
      party1.setDescription("Party with all the chads");
      party1.setLocation("Start at Pony");
      partyRepository.save(party1);

      Party party2 = new Party();
      party2.setName("Big birthday bash");
      party2.setDescription("Eat all the dumplings");
      party2.setLocation("Din Tai Fung Bellevue");
      partyRepository.save(party2);
    }
  }
}
