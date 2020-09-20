package com.biddingclub.biddingsystem.repository;

import com.biddingclub.biddingsystem.entity.Bidder;
import org.springframework.data.repository.CrudRepository;

public interface BidderRepository extends CrudRepository<Bidder, Long> {
}
