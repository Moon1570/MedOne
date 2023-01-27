package model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patients")
public class PatientModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "patient_name")
	private String patientName;

	
	@Column(name = "patient_address")
	private String patientAddress;
	
	
	@Column(name = "patient_phone")
	private String patientPhone;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "patient_dob")
	private Date patientDOB;
	
	@Column(name = "patient_password")
	private String patientPassword;
	
	@Lob
    @Column(name="patient_image", nullable=false, columnDefinition="mediumblob")
    private byte[] patientImage;
	
    @ManyToMany(mappedBy = "patients", fetch = FetchType.EAGER,  cascade = { CascadeType.ALL })
    private Set<DoctorModel> doctors = new HashSet<>();

    @OneToMany(mappedBy="patient")
    private Set<ReportModel> reports;
    
	@Column(name = "patient_relatives")
    private HashMap<Integer, String> relatives = new HashMap<Integer, String>();
    
    

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public Date getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public byte[] getPatientImage() {
		return patientImage;
	}

	public void setPatientImage(byte[] patientImage) {
		this.patientImage = patientImage;
	}

	public Set<DoctorModel> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<DoctorModel> doctors) {
		this.doctors = doctors;
	}

	public Set<ReportModel> getReports() {
		return reports;
	}

	public void setReports(Set<ReportModel> reports) {
		this.reports = reports;
	}

	public HashMap<Integer, String> getRelatives() {
		return relatives;
	}

	public void setRelatives(HashMap<Integer, String> relatives) {
		this.relatives = relatives;
	}

	public void addDoctor(DoctorModel doctorModel) {
        this.doctors.add(doctorModel);
        doctorModel.getPatients().add(this);
    }
  
    public void removeDoctor(DoctorModel doctorModel) {
        this.doctors.remove(doctorModel);
        doctorModel.getPatients().remove(this);
    }

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
	
	
	
}
