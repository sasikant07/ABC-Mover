package com.abcmover.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vessel")
@Setter
@Getter
@ToString

public class Vessel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="vesselName")
	private String vesselName;
	
	@Column(name="vesselCode")
	private String vesselCode;
	
	@Column(name="ETA")
	private Date estimateTimeArrival;
	
	@Column(name="ATA")
	private Date actualArrivalTime;
	
	@ManyToOne
	@JoinColumn(name = "shipping_id")
	private ShippingLine shippingLine;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="vessel")
	private Set<Container> container;
	
	
}
