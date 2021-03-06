package com.coelhorapido.crud.model;

import java.io.Serializable;

public class DeliveryMan implements Serializable {

	private static final long serialVersionUID = 8764484389875443211L;
	private long id;
	private String name;

	public DeliveryMan() {
	}

	public DeliveryMan(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		DeliveryMan other = (DeliveryMan) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
