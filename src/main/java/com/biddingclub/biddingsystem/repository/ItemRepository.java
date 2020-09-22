package com.biddingclub.biddingsystem.repository;

import com.biddingclub.biddingsystem.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByAuctionStatusId(int auctionStatusId);
}
