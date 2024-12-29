package code.types;

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
@Table(name="t_pts_project_detail")
public class Project 
{
	@Column(name="IRID")
	private String investmentId; 
	
	@Id
	@Column(name="WORK_EFFORT_ID")
	private String workEffortId;

}
