package types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SIMPLE_ENTITY")
public class SimpleEntity 
{
	public SimpleEntity()
	{}
	
	public SimpleEntity(String simpleValue)
	{
		this.simpleValue=simpleValue;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SIMPLE_ID")	
	private int simpleId;
	@Column(name="SIMPLE_VALUE")
	private String simpleValue;
	
	public int getSimpleId() {
		return simpleId;
	}
	public void setSimpleId(int simpleId) {
		this.simpleId = simpleId;
	}
	public String getSimpleValue() {
		return simpleValue;
	}
	public void setSimpleValue(String simpleValue) {
		this.simpleValue = simpleValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + simpleId;
		result = prime * result + ((simpleValue == null) ? 0 : simpleValue.hashCode());
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
		SimpleEntity other = (SimpleEntity) obj;
		if (simpleId != other.simpleId)
			return false;
		if (simpleValue == null) {
			if (other.simpleValue != null)
				return false;
		} else if (!simpleValue.equals(other.simpleValue))
			return false;
		return true;
	}
	
}
