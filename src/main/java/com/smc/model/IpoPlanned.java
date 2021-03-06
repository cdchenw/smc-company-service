package com.smc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * @Description: IPO plan entity for JPA persist that mapping to tb_ipo_planned table,
 *               Meanwhile it's taken as the request/response DTO object.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_ipo_planned")
//@PrimaryKeyJoinColumn(name="ce_id")
//@DiscriminatorValue("tb_ipo_planned")
public class IpoPlanned implements Serializable{// extends CompanyExchange{

	private static final long serialVersionUID = 624852327712974139L;

	@Id
    @Column(name = "id")
    private String id;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id") 
    private CompanyExchange companyExchange;

	@Column(name = "price_per_share")
	private BigDecimal pricePerShare;

	@Column(name = "total_share")
	private BigDecimal totalShare;
	
	@Column(name = "open_date")
	private Date openDate;
	
	@Column(name = "remarks", length = 256)
	@Size(min = 0, max = 256)
	private String remarks;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompanyExchange getCompanyExchange() {
		return companyExchange;
	}

	public void setCompanyExchange(CompanyExchange companyExchange) {
		this.companyExchange = companyExchange;
	}

	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public BigDecimal getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(BigDecimal totalShare) {
		this.totalShare = totalShare;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
