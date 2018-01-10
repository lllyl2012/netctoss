package cn.tedu.netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cost implements Serializable{
	private static final long serialVersionUID = 576237316582104163L;
	private Integer cost_id;
	private String name;
	private Integer base_duration;
	private Double base_cost;
	private Double unit_cost;
	private String status;
	private String descr;
	private Timestamp creatime;
	private Timestamp startime;
	private String cost_type;
	
	public Cost() {
		super();
	}

	public Cost(Integer cost_id, String name, Integer base_duration, Double base_cost, Double unit_cost, String status,
			String descr, Timestamp creatime, Timestamp startime, String cost_type) {
		super();
		this.cost_id = cost_id;
		this.name = name;
		this.base_duration = base_duration;
		this.base_cost = base_cost;
		this.unit_cost = unit_cost;
		this.status = status;
		this.descr = descr;
		this.creatime = creatime;
		this.startime = startime;
		this.cost_type = cost_type;
	}

	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBase_duration() {
		return base_duration;
	}

	public void setBase_duration(Integer base_duration) {
		this.base_duration = base_duration;
	}

	public Double getBase_cost() {
		return base_cost;
	}

	public void setBase_cost(Double base_cost) {
		this.base_cost = base_cost;
	}

	public Double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(Double unit_cost) {
		this.unit_cost = unit_cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Timestamp getCreatime() {
		return creatime;
	}

	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}

	public Timestamp getStartime() {
		return startime;
	}

	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}

	public String getCost_type() {
		return cost_type;
	}

	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base_cost == null) ? 0 : base_cost.hashCode());
		result = prime * result + ((base_duration == null) ? 0 : base_duration.hashCode());
		result = prime * result + ((cost_id == null) ? 0 : cost_id.hashCode());
		result = prime * result + ((cost_type == null) ? 0 : cost_type.hashCode());
		result = prime * result + ((creatime == null) ? 0 : creatime.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startime == null) ? 0 : startime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unit_cost == null) ? 0 : unit_cost.hashCode());
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
		Cost other = (Cost) obj;
		if (base_cost == null) {
			if (other.base_cost != null)
				return false;
		} else if (!base_cost.equals(other.base_cost))
			return false;
		if (base_duration == null) {
			if (other.base_duration != null)
				return false;
		} else if (!base_duration.equals(other.base_duration))
			return false;
		if (cost_id == null) {
			if (other.cost_id != null)
				return false;
		} else if (!cost_id.equals(other.cost_id))
			return false;
		if (cost_type == null) {
			if (other.cost_type != null)
				return false;
		} else if (!cost_type.equals(other.cost_type))
			return false;
		if (creatime == null) {
			if (other.creatime != null)
				return false;
		} else if (!creatime.equals(other.creatime))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startime == null) {
			if (other.startime != null)
				return false;
		} else if (!startime.equals(other.startime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (unit_cost == null) {
			if (other.unit_cost != null)
				return false;
		} else if (!unit_cost.equals(other.unit_cost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cost [cost_id=" + cost_id + ", name=" + name + ", base_duration=" + base_duration + ", base_cost="
				+ base_cost + ", unit_cost=" + unit_cost + ", status=" + status + ", descr=" + descr + ", creatime="
				+ creatime + ", startime=" + startime + ", cost_type=" + cost_type + "]";
	}
	
	
	
}
