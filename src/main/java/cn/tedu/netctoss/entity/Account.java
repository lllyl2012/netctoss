package cn.tedu.netctoss.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Account implements Serializable {
	private static final long serialVersionUID = -3444752586325413583L;
	private Integer account_id;
	private Integer recommender_id;
	private String login_name;
	private String login_passwd;
	private String status;
	private Timestamp create_date;
	private Timestamp pause_date;
	private Timestamp close_date;
	private String real_name;
	private String idcard_no;
	private Date birthdate;
	private String gender;
	private String occupation;
	private String telephone;
	private String email;
	private String mailaddress;
	private String zipcode;
	private String qq;
	private Timestamp last_login_time;
	private String last_login_ip;

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Integer getRecommender_id() {
		return recommender_id;
	}

	public void setRecommender_id(Integer recommender_id) {
		this.recommender_id = recommender_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
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

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getPause_date() {
		return pause_date;
	}

	public void setPause_date(Timestamp pause_date) {
		this.pause_date = pause_date;
	}

	public Timestamp getClose_date() {
		return close_date;
	}

	public void setClose_date(Timestamp close_date) {
		this.close_date = close_date;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getIdcard_no() {
		return idcard_no;
	}

	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Timestamp getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", recommender_id=" + recommender_id + ", login_name=" + login_name
				+ ", login_passwd=" + login_passwd + ", status=" + status + ", create_date=" + create_date
				+ ", pause_date=" + pause_date + ", close_date=" + close_date + ", real_name=" + real_name
				+ ", idcard_no=" + idcard_no + ", birthdate=" + birthdate + ", gender=" + gender + ", occupation="
				+ occupation + ", telephone=" + telephone + ", email=" + email + ", mailaddress=" + mailaddress
				+ ", zipcode=" + zipcode + ", qq=" + qq + ", last_login_time=" + last_login_time + ", last_login_ip="
				+ last_login_ip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_id == null) ? 0 : account_id.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((close_date == null) ? 0 : close_date.hashCode());
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((idcard_no == null) ? 0 : idcard_no.hashCode());
		result = prime * result + ((last_login_ip == null) ? 0 : last_login_ip.hashCode());
		result = prime * result + ((last_login_time == null) ? 0 : last_login_time.hashCode());
		result = prime * result + ((login_name == null) ? 0 : login_name.hashCode());
		result = prime * result + ((login_passwd == null) ? 0 : login_passwd.hashCode());
		result = prime * result + ((mailaddress == null) ? 0 : mailaddress.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((pause_date == null) ? 0 : pause_date.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result + ((real_name == null) ? 0 : real_name.hashCode());
		result = prime * result + ((recommender_id == null) ? 0 : recommender_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Account other = (Account) obj;
		if (account_id == null) {
			if (other.account_id != null)
				return false;
		} else if (!account_id.equals(other.account_id))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (close_date == null) {
			if (other.close_date != null)
				return false;
		} else if (!close_date.equals(other.close_date))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (idcard_no == null) {
			if (other.idcard_no != null)
				return false;
		} else if (!idcard_no.equals(other.idcard_no))
			return false;
		if (last_login_ip == null) {
			if (other.last_login_ip != null)
				return false;
		} else if (!last_login_ip.equals(other.last_login_ip))
			return false;
		if (last_login_time == null) {
			if (other.last_login_time != null)
				return false;
		} else if (!last_login_time.equals(other.last_login_time))
			return false;
		if (login_name == null) {
			if (other.login_name != null)
				return false;
		} else if (!login_name.equals(other.login_name))
			return false;
		if (login_passwd == null) {
			if (other.login_passwd != null)
				return false;
		} else if (!login_passwd.equals(other.login_passwd))
			return false;
		if (mailaddress == null) {
			if (other.mailaddress != null)
				return false;
		} else if (!mailaddress.equals(other.mailaddress))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (pause_date == null) {
			if (other.pause_date != null)
				return false;
		} else if (!pause_date.equals(other.pause_date))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (real_name == null) {
			if (other.real_name != null)
				return false;
		} else if (!real_name.equals(other.real_name))
			return false;
		if (recommender_id == null) {
			if (other.recommender_id != null)
				return false;
		} else if (!recommender_id.equals(other.recommender_id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
