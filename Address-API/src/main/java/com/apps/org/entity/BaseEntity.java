package com.apps.org.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends Auditable<String> implements Serializable {
	
	private static final long serialVersionUID = 4926468583005150706L;

	
	@Column(name = "start_date")
    private Date startDate;
    
	@Column(name = "end_date")
	protected Date endDate;
	
	@Column(name = "due_date")
	protected Date dueDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dueDate, endDate, startDate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof BaseEntity))
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(dueDate, other.dueDate) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseEntity [startDate=").append(startDate).append(", endDate=").append(endDate)
				.append(", dueDate=").append(dueDate).append("]");
		return builder.toString();
	}
	
}
