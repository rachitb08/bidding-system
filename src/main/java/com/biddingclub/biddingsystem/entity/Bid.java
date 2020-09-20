package com.biddingclub.biddingsystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="bid")
public class Bid implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bidder_id", nullable = false)
	private Bidder bidder;

	@Column(name = "bid_price", nullable = false)
	private Double bidPrice;

	@Column(name = "bid_time", nullable = false)
	private Date bidTime;

	@Column(name = "bid_status_id", nullable = false)
	private Long bidStatusId;
}