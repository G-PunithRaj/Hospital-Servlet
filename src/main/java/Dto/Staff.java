package Dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Staff {
	@Id
	@GeneratedValue(generator = "staffid")
	@SequenceGenerator(initialValue = 25001, allocationSize = 1, name = "staffid",sequenceName="staffid")
	private int ID;
	private String NAME;
	private long MOBILE;
	private String GMAIL;
	private String PASSWORD;
	private String GENDER;
	private Date DOB;
	private int AGE;
	private boolean STATUS;
}
