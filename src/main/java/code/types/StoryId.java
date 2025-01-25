package code.types;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StoryId implements Serializable
{
	
	//@Column(name = "KEY")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String key;
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "INSTANCE")
	private Integer instance;
}
