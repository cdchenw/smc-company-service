package com.smc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * 
 * @Description: Company entity for JPA persist that mapping to tb_company table,
 *               Meanwhile it's taken as the request/response DTO object.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name = "name", length = 32)
	@NotBlank(message = "{company.name.required}")
	@Size(min = 3, max = 128, message = "{company.name.outrange}")
	private String name;

	@Column(name = "turn_over")
	private BigDecimal turnOver;

	@Column(name = "ceo", length = 128)
	@Size(min = 0, max = 128)
	private String ceo;

	@Column(name = "board_of_directors", length = 256)
	@Size(min = 0, max = 256)
	private String boardOfDirectors;
	
	@Column(name = "brief_write_up", length = 256)
	@Size(min = 0, max = 256)
	private String briefWriteUp;

	@ManyToMany
	@JoinTable(name = "tb_company_sector", 
		joinColumns = @JoinColumn(name = "tb_company_id"), 
		inverseJoinColumns = @JoinColumn(name = "tb_sector_id"))
	private List<Sector> sectors = new ArrayList<Sector>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="comp_id") 
	private List<CompanyExchange> companyExchanges = new ArrayList<CompanyExchange>();

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

	public Number getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(BigDecimal turnOver) {
		this.turnOver = turnOver;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getBriefWriteUp() {
		return briefWriteUp;
	}

	public void setBriefWriteUp(String briefWriteUp) {
		this.briefWriteUp = briefWriteUp;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public List<CompanyExchange> getCompanyExchanges() {
		return companyExchanges;
	}

	public void setCompanyExchanges(List<CompanyExchange> companyExchanges) {
		this.companyExchanges = companyExchanges;
	}
}
