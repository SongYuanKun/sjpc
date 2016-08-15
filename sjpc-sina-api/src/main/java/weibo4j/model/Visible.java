package weibo4j.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

@Entity
@Table(name = "visible")
public class Visible {
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	private Integer type;
	private Integer list_id;

	public Visible() {
	}

	public Visible(JSONObject json) throws JSONException {
		this.type = json.getInt("type");
		this.list_id = json.getInt("list_id");
	}

	public Integer getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + list_id;
		result = prime * result + type;
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
		Visible other = (Visible) obj;
		if (list_id != other.list_id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visible [type=" + type + ", list_id=" + list_id + "]";
	}

}
