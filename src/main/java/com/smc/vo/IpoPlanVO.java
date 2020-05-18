package com.smc.vo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @Description: IPO plan for request/response DTO object.
 * @author Chen Wei
 * @date May 18, 2020
 *
 */
public class IpoPlanVO {
	private String id;

	@NotNull(message = "Price per share cann't be null")
	private BigDecimal pricePerShare;

	@NotNull(message = "Total share cann't be null!")
	private BigDecimal totalShare;

	@NotNull(message = "Open date cann't be null!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date openDate;

	private String remarks;

	private String compId; // company Id

	private String exchangeId; // stock exchange Id

	public IpoPlanVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

}
