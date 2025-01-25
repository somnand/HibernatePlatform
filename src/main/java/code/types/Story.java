package code.types;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jira_story")
@IdClass(value = StoryId.class)
public class Story 
{
	
	//Composite Primary Key
	@Id
	@Column(name = "STORY_KEY")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "HibernateSequence",initialValue = 1,allocationSize = 1)
	private String key;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "HibernateSequence",initialValue = 1,allocationSize = 1)
	@Column(name = "INSTANCE")
	private Integer instance;
	
	@Column(name = "PLANVIEW_ID")
	private String planviewId;
	
	
	@ManyToOne
	@JoinColumn(name = "PLANVIEW_ID" , referencedColumnName = "PLANVIEW_ID", insertable = false, updatable = false)
	@JsonIgnore
	private Epic epic;
	
	//@Column(name="PLANVIEW_ID")
	//private String planviewId;//Same as Work Effort Id in Project 
	
	@Column(name="FIX_VERSION")
	private String fixVersion;
	
	//Story extra fields
//	@Column(name = "CREATE_DATE")
//	private Date createDate;
//	@Column(name = "UPDATE_DATE")
//	private Date updateDate;
//	@Column(name = "ISSUE_ID")
//	private String issueId;
//	@Column(name = "PTS_ID")
//	private String ptsId;
//	@Column(name = "REPORTER")
//	private String reporter;
//	@Column(name = "SPRINT")
//	private String sprint;
//	@Column(name = "STATUS")
//	private String status;
//	@Column(name = "SUMMARY")
//	private String summary;
//	@Column(name = "PARENT_PLAN_VIEW")
//	private String parentPlanView;
}
