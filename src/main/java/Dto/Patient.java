package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Patient {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int ID;
String NAME;
long MOBILE;
Date Dob;
int Age;

@Lob
byte[] Picture;

@OneToMany
List<Appointment> Appointments;
}
