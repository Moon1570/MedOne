package model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "communications")
public class ThreadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thread_id")
	private int id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date threadDate;

	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private PatientModel patientModel;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private DoctorModel doctorModel;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<MessageModel> messageList;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
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

	public Date getThreadDate() {
		return threadDate;
	}

	public void setThreadDate(Date threadDate) {
		this.threadDate = threadDate;
	}
	
	
	
}
