package cn.tedu.netctoss.entity;

import java.io.Serializable;
import java.sql.Date;

public class Service implements Serializable {
	private static final long serialVersionUID = 8946755832671311020L;
	private Integer service_id;
	private Integer account_id;
	private String unix_host;
	private String os_username;
	private String login_passwd;
	private String status;
	private Date create_date;
	private Date pause_date;
	private Date close_date;
	private Integer cost_id;

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getUnix_host() {
		return unix_host;
	}

	public void setUnix_host(String unix_host) {
		this.unix_host = unix_host;
	}

	public String getOs_username() {
		return os_username;
	}

	public void setOs_username(String os_username) {
		this.os_username = os_username;
	}

	public String getLogin_passwd() {
		return login_passwd;
	}

	public void setLogin_passwd(String login_passwd) {
		this.login_passwd = login_passwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getPause_date() {
		return pause_date;
	}

	public void setPause_date(Date pause_date) {
		this.pause_date = pause_date;
	}

	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_id == null) ? 0 : account_id.hashCode());
		result = prime * result + ((close_date == null) ? 0 : close_date.hashCode());
		result = prime * result + ((cost_id == null) ? 0 : cost_id.hashCode());
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((login_passwd == null) ? 0 : login_passwd.hashCode());
		result = prime * result + ((os_username == null) ? 0 : os_username.hashCode());
		result = prime * result + ((pause_date == null) ? 0 : pause_date.hashCode());
		result = prime * result + ((service_id == null) ? 0 : service_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unix_host == null) ? 0 : unix_host.hashCode());
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
		Service other = (Service) obj;
		if (account_id == null) {
			if (other.account_id != null)
				return false;
		} else if (!account_id.equals(other.account_id))
			return false;
		if (close_date == null) {
			if (other.close_date != null)
				return false;
		} else if (!close_date.equals(other.close_date))
			return false;
		if (cost_id == null) {
			if (other.cost_id != null)
				return false;
		} else if (!cost_id.equals(other.cost_id))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (login_passwd == null) {
			if (other.login_passwd != null)
				return false;
		} else if (!login_passwd.equals(other.login_passwd))
			return false;
		if (os_username == null) {
			if (other.os_username != null)
				return false;
		} else if (!os_username.equals(other.os_username))
			return false;
		if (pause_date == null) {
			if (other.pause_date != null)
				return false;
		} else if (!pause_date.equals(other.pause_date))
			return false;
		if (service_id == null) {
			if (other.service_id != null)
				return false;
		} else if (!service_id.equals(other.service_id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (unix_host == null) {
			if (other.unix_host != null)
				return false;
		} else if (!unix_host.equals(other.unix_host))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", account_id=" + account_id + ", unix_host=" + unix_host
				+ ", os_username=" + os_username + ", login_passwd=" + login_passwd + ", status=" + status
				+ ", create_date=" + create_date + ", pause_date=" + pause_date + ", close_date=" + close_date
				+ ", cost_id=" + cost_id + "]";
	}

}
