package com.abcmover.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="container")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Container {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="")
	private int containerNumber;
	
	@Column(name="")
	private String containerISOCode;
	
	@Column(name="")
	private boolean containerFullOrEmpty;
	
	@Enumerated(EnumType.STRING)
	@Column(name="")
	private ContainerType containerType;
	
	@Column(name="")
	private double width;
	
	@Column(name="")
	private double length;
	
	@Column(name="")
	private double height;
	
	@Column(name="")
	private double grossWeight;
	
	@Column(name="")
	private int sealNumber;
	
	@Column(name="")
	private boolean isDGGoods;
	
	@ManyToOne
	@JoinColumn(name = "vessel_id")
	private Vessel vessel;

	public Container(int containerNumber, String containerISOCode) {
		super();
		this.containerNumber = containerNumber;
		this.containerISOCode = containerISOCode;
	}

	public Container(int containerNumber, String containerISOCode, boolean containerFullOrEmpty) {
		super();
		this.containerNumber = containerNumber;
		this.containerISOCode = containerISOCode;
		this.containerFullOrEmpty = containerFullOrEmpty;
	}

	public Container(int containerNumber, String containerISOCode, boolean containerFullOrEmpty,
			ContainerType containerType, Vessel vessel) {
		super();
		this.containerNumber = containerNumber;
		this.containerISOCode = containerISOCode;
		this.containerFullOrEmpty = containerFullOrEmpty;
		this.containerType = containerType;
		this.vessel = vessel;
	}
	
}
