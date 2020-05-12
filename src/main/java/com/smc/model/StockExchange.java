package com.smc.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity 
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_stock_exchange")
public class StockExchange {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name = "name", length = 64)
	@NotNull
	@Size(min = 3, max = 64)
	private String name;
	
	@Column(name = "short_name", length = 8)
	@NotNull
	@Size(min = 3, max = 8)
	private String shortName;
	
	@Column(name = "region", length = 64)
	@Size(min = 3, max = 64)
	private String region;
	
	@Column(name = "brief", length = 512)
	@Size(min = 0, max = 512)
	private String brief;
	
	@Column(name = "contact_address", length = 128)
	@Size(min = 0, max = 128)
	private String contactAddress;
	
	@Column(name = "remarks", length = 256)
	@Size(min = 0, max = 256)
	private String remarks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
