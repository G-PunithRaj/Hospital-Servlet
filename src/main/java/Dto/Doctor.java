package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "Doctorid")
	@SequenceGenerator(initialValue = 55001, allocationSize = 1, name = "Doctorid", sequenceName = "Doctorid")
	private int ID;
	private String NAME;
	private long MOBILE;
	private String GMAIL;
	private String PASSWORD;
	private String GENDER;
	private Date DOB;
	private int AGE;
	private boolean STATUS;
	private String QUALIFICATION;
	private String SPECIALIZATION;
	boolean AVAILABLITY;

	@OneToMany
	List<Appointment> appointments;
}
