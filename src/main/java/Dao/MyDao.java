package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import Dto.Appointment;
import Dto.Doctor;
import Dto.Patient;
import Dto.Staff;

public class MyDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hospital");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void Savestaff(Staff staff) {
		entityTransaction.begin();
		entityManager.persist(staff);
		entityTransaction.commit();
	}

	public void SaveDoc(Doctor doctor) {
		entityTransaction.begin();
		entityManager.persist(doctor);
		entityTransaction.commit();
	}

	public void Savepatient(Patient patient) {
		entityTransaction.begin();
		entityManager.persist(patient);
		entityTransaction.commit();
	}

	public Staff fetchstaff(long mobile) {
		List<Staff> lst = entityManager.createQuery("Select x from Staff x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}
	}

	public Staff fetchstaff(String gmail) {
		List<Staff> list = entityManager.createQuery("Select x from Staff x where gmail=?1").setParameter(1, gmail)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Staff fetchstaff(int ID) {
		List<Staff> lis = entityManager.createQuery("Select x from Staff x where ID=?1").setParameter(1, ID)
				.getResultList();
		if (lis.isEmpty()) {
			return null;
		} else {
			return lis.get(0);
		}
	}

	public Doctor fetchdoctor(int ID) {
		List<Doctor> file = entityManager.createQuery("Select x from Doctor x where ID=?1").setParameter(1, ID)
				.getResultList();
		if (file.isEmpty()) {
			return null;
		} else {
			return file.get(0);
		}
	}

	public Doctor fetchdoctor(long mobile) {
		List<Doctor> lst = entityManager.createQuery("Select x from Doctor x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}
	}

	public Doctor fetchdoctor(String gmail) {
		List<Doctor> list = entityManager.createQuery("Select x from Doctor x where gmail=?1").setParameter(1, gmail)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Patient fetchPatient(int id) {
		return entityManager.find(Patient.class, id);
	}

	public void update(Staff data) {
		entityTransaction.begin();
		entityManager.merge(data);
		entityTransaction.commit();
	}

	public void update(Doctor file) {
		entityTransaction.begin();
		entityManager.merge(file);
		entityTransaction.commit();
	}

	public List<Staff> fetchallStaff() {
		List<Staff> list = entityManager.createQuery("Select x from Staff x", Staff.class).getResultList();
		return list;
	}

	public List<Doctor> fetchallDoctor() {
		List<Doctor> list = entityManager.createQuery("Select x from Doctor x", Doctor.class).getResultList();
		return list;
	}

	public List<Patient> fetchallpatient() {
		List<Patient> list = entityManager.createQuery("Select x from Patient x", Patient.class).getResultList();
		return list;
	}

	public List<Doctor> fetchavailableDoctor() {
		return entityManager.createQuery("Select x from Doctor x where AVAILABLITY=true").getResultList();
	}

	public void saveappointement(Appointment appointment) {
		entityTransaction.begin();
		entityManager.persist(appointment);
		entityTransaction.commit();
	}

	public Appointment fetchappointment(int id) {
		return entityManager.find(Appointment.class, id);

	}
	public void UpdateAppointment(Appointment appointment){
		entityTransaction.begin();
		entityManager.merge(appointment);
		entityTransaction.commit();
	}
}
