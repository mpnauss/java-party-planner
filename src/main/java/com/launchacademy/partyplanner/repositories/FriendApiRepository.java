package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Friend;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FriendApiRepository extends PagingAndSortingRepository<Friend, Integer> {

}
