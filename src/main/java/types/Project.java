package types;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Project 
{
	@Column(name="IRID")
	private String investmentId; 

}
