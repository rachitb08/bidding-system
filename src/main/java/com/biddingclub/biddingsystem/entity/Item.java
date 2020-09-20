package com.biddingclub.biddingsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "step_rate", nullable = false)
	private Double stepRate;

	@Column(name = "minimum_base_price", nullable = false)
	private Double minimumBasePrice;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;

	@Column(name = "auction_status_id", nullable = false)
	private Long auctionStatusId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accepted_bid_id")
	private Bid bid;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;


}
