package code.types;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jira_epic")
@IdClass(EpicId.class)
public class Epic implements Serializable 
{
	@Id
	@Column(name = "INSTANCE")
	private Integer instance;
	
	@Id
	@Column(name = "EPIC_KEY")
	private String key;
	
	@Column(name = "PLANVIEW_ID" , nullable = false, unique = true)
	private String planviewId;//This is same as PLANVIEW_ID in Story 
	
	@OneToMany(mappedBy = "epic" , cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Story> stories;

}
