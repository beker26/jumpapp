package com.jump.jump.controller.dto;

import com.jump.jump.domain.Estate;

public class EstateDto {

	private String tradingName;
	private String companyName;
	private String cnpj;
	private String telephone;

	public EstateDto(Estate estate) {
		this.tradingName = estate.getTradingName();
		this.companyName = estate.getCompanyName();
		this.cnpj = estate.getCnpj();
		this.telephone = estate.getTelephone();
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static EstateDto parse(Estate imobialiaria) {
		return new EstateDto(imobialiaria);
	}

	

}
