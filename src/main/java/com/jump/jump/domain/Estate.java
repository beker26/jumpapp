package com.jump.jump.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 128, unique = true)
	private String tradingName;
	@Column(length = 128, unique = true)
	private String companyName;
	@Column(length = 128, unique = true)
	private String cnpj;
	@Column(length = 128, unique = true)
	private String telephone;

	public Estate() {
	}

	public Estate(String tradingName, String companyName, String cnpj, String telephone) {
		this.tradingName = tradingName;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.telephone = telephone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estate other = (Estate) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
