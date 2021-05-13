package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Party;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartyApiRepository extends PagingAndSortingRepository<Party, Integer> {

//  Iterable<Party> findAll();
}
