package com.apps.org.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
	
	@CreatedBy
    protected U initiatedBy;
    
	@LastModifiedBy
	protected String updatedBy;

	@CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	protected Date initiatedOn;
 
	@LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedOn;
	
	
	public String getInitiatedBy() {
		return (String) initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = (U) initiatedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getInitiatedOn() {
		return initiatedOn;
	}

	public void setInitiatedOn(Date initiatedOn) {
		this.initiatedOn = initiatedOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(initiatedBy, initiatedOn, updatedBy, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Auditable))
			return false;
		Auditable<?> other = (Auditable<?>) obj;
		return Objects.equals(initiatedBy, other.initiatedBy) && Objects.equals(initiatedOn, other.initiatedOn)
				&& Objects.equals(updatedBy, other.updatedBy) && Objects.equals(updatedOn, other.updatedOn);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("BaseEntity { ")
				.append("initiatedBy=").append(initiatedBy).append(", updatedBy=").append(updatedBy)
				.append(", initiatedOn=").append(initiatedOn).append(", updatedOn=").append(updatedOn).append(" }");
		return builder.toString();
	}
    
}
