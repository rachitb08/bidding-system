package com.biddingclub.biddingsystem.repository;

import com.biddingclub.biddingsystem.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
