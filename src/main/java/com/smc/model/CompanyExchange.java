package com.smc.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_company_exchange")
public class CompanyExchange {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;
	
	@Column(name = "comp_id")
	private String compId;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="exchange_id", nullable=true)
    private StockExchange stockExchange;
	
	@OneToOne(cascade=CascadeType.REMOVE)
    private IpoPlanned ipoPlanned;

	@Column(name = "stock_code", length = 8)
    @Size(min = 3, max = 8)
	private String stockCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public IpoPlanned getIpoPlanned() {
		return ipoPlanned;
	}

	public void setIpoPlanned(IpoPlanned ipoPlanned) {
		this.ipoPlanned = ipoPlanned;
	}
}
