package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "communications")
public class ThreadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thread_id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PatientModel patientModel;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DoctorModel doctorModel;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<MessageModel> messageList;
	
	@Column(name = "attached_report_id")
	@ElementCollection
	private Set<ReportModel> attachedReport;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PatientModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientModel patientModel) {
		this.patientModel = patientModel;
	}

	public DoctorModel getDoctorModel() {
		return doctorModel;
	}

	public void setDoctorModel(DoctorModel doctorModel) {
		this.doctorModel = doctorModel;
	}

	public Set<MessageModel> getMessageList() {
		return messageList;
	}

	public void setMessageList(Set<MessageModel> messageList) {
		this.messageList = messageList;
	}

	public Set<ReportModel> getAttachedReport() {
		return attachedReport;
	}

	public void setAttachedReport(Set<ReportModel> attachedReport) {
		this.attachedReport = attachedReport;
	}
	
	
}
