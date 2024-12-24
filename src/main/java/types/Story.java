package types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bb_jira_story")
public class Story 
{
	
	//Composite Primary Key
	
	@Id
	@Column(name="PLANVIEW_ID")
	private String planviewId;//Same as Work Effort Id in Project 

}
