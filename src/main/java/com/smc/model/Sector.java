package com.smc.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity 
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_sector")
public class Sector {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name = "name", length = 64)
	@NotNull
	@Size(min = 3, max = 64)
	private String name;

	@Column(name = "brief", length = 256)
	@Size(min = 0, max = 256)
	private String brief;
	
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
}
