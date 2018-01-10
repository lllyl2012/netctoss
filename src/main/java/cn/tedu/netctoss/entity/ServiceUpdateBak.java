package cn.tedu.netctoss.entity;

import java.io.Serializable;

public class ServiceUpdateBak implements Serializable {
	private static final long serialVersionUID = 7199827235825091879L;
	Integer id;
	Integer cost_id;
	Integer service_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost_id == null) ? 0 : cost_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((service_id == null) ? 0 : service_id.hashCode());
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
		ServiceUpdateBak other = (ServiceUpdateBak) obj;
		if (cost_id == null) {
			if (other.cost_id != null)
				return false;
		} else if (!cost_id.equals(other.cost_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (service_id == null) {
			if (other.service_id != null)
				return false;
		} else if (!service_id.equals(other.service_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceUpdateBak [id=" + id + ", cost_id=" + cost_id + ", service_id=" + service_id + "]";
	}

}
