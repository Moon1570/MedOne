package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "doctors")
public class DoctorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int doctorId;
	
	@Column(name = "doctor_name")
	private String doctorName;

	
	@Column(name = "doctor_address")
	private String doctorAddress;
	
	
	@Column(name = "doctor_phone")
	private String doctorPhone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "doctor_dob")
	private Date doctorDOB;
	
	@Column(name = "doctor_password")
	private String doctorPassword;
	
	@Lob
    @Column(name="doctor_image", nullable=false, columnDefinition="mediumblob")
    private byte[] doctorImage;
	
	@Lob
    @Column(name="doctor_cert", nullable=false, columnDefinition="mediumblob")
    private byte[] doctorCert;
	
	@ManyToMany(targetEntity = PatientModel.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)  
	@JoinTable(name = "doctor_patient",   
	            joinColumns = { @JoinColumn(name = "doctor_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "patient_id") })  
	private Set<PatientModel> patients = new HashSet<>();
	
	
	

	public DoctorModel(String doctorName, String doctorAddress, String doctorPhone, Date doctorDOB,
			String doctorPassword, byte[] doctorImage, byte[] doctorCert) {
		super();
		this.doctorName = doctorName;
		this.doctorAddress = doctorAddress;
		this.doctorPhone = doctorPhone;
		this.doctorDOB = doctorDOB;
		this.doctorPassword = doctorPassword;
		this.doctorImage = doctorImage;
		this.doctorCert = doctorCert;
	}

	public DoctorModel() {
		// TODO Auto-generated constructor stub
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public Date getDoctorDOB() {
		return doctorDOB;
	}

	public void setDoctorDOB(Date doctorDOB) {
		this.doctorDOB = doctorDOB;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	public byte[] getDoctorImage() {
		return doctorImage;
	}

	public void setDoctorImage(byte[] doctorImage) {
		this.doctorImage = doctorImage;
	}

	public Set<PatientModel> getPatients() {
		return patients;
	}

	public void setPatients(Set<PatientModel> patients) {
		this.patients = patients;
	}

	public byte[] getDoctorCert() {
		return doctorCert;
	}

	public void setDoctorCert(byte[] doctorCert) {
		this.doctorCert = doctorCert;
	}


	
	
}
