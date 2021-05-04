package com.jump.jump.controller.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jump.jump.domain.Estate;

public class EstateForm {

	@NotNull
	@NotEmpty
	@Length(min = 3)
	private String tradingName;
	@NotNull
	@NotEmpty
	@Length(min = 3)
	private String companyName;
	@NotNull
	@NotEmpty
	@Length(min = 14, max = 14)
	private String cnpj;
	@NotNull
	@NotEmpty
	@Length(min = 8, max = 9)
	private String telephone;

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

	public Estate toEstate() {
		return new Estate(this.tradingName, this.companyName, this.cnpj, this.telephone);
	}



}
