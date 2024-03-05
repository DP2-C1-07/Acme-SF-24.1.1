
package acme.entities.trainingmodules;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrainingModules extends AbstractEntity {

	//Serialisation identifier -----------------------------------------------------------------

	private static final long		serialVersionUID	= 1L;

	//Attributes --------------------------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}")
	String							code;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	Date							creationMoment;

	@NotBlank
	@Length(max = 100)
	String							details;

	@NotNull
	TrainingModuleDifficultyLevel	difficultyLevel;

	//TODO: cuando sepamos hacer servicios añadir la restricción de que el updateMoment debe ser posterior al creationMoment
	@Past
	Date							updateMoment;

	@URL
	String							link;

	@NotNull
	Integer							totalTime;

}