package com.abcmover.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="shipping_line")
@Setter
@Getter
@ToString
public class ShippingLine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="shippingLineName")
	private String shippingLineName;
	
	@Column(name="lineCode")
	private String lineCode;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="shipping")
	private Set<Vessel> vessel;
	
}
