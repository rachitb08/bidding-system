package com.biddingclub.biddingsystem.repository;

import com.biddingclub.biddingsystem.entity.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository extends CrudRepository<Bid, Long> {
}
