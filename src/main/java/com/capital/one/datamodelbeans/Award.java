package com.capital.one.datamodelbeans;

import org.springframework.stereotype.Component;

@Component
public class Award {
	
	private int awardId;
	private int awardType;
	private String awardName;
	private int creditCost;
	// NOTE: I am not assigning a specific creditTypeId here...it will be a business decision what credit types can be used to purchase
	// a given awardType
	
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public int getCreditCost() {
		return creditCost;
	}
	public void setCreditCost(int creditCost) {
		this.creditCost = creditCost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + awardId;
		result = prime * result + ((awardName == null) ? 0 : awardName.hashCode());
		result = prime * result + awardType;
		result = prime * result + creditCost;
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
		Award other = (Award) obj;
		if (awardId != other.awardId)
			return false;
		if (awardName == null) {
			if (other.awardName != null)
				return false;
		} else if (!awardName.equals(other.awardName))
			return false;
		if (awardType != other.awardType)
			return false;
		if (creditCost != other.creditCost)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Award [awardId=" + awardId + ", awardType=" + awardType + ", awardName=" + awardName + ", creditCost="
				+ creditCost + "]";
	}
	
	
	

	

}
