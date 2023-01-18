package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//XPF84-N4GC9-RXKJ9-434H4-2KCKM

@Entity
@Table(name = "reports")
public class ReportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date reportCreateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date reportModifyDate;

	@Lob
    @Column(name="report_file", nullable=false, columnDefinition="mediumblob")
    private byte[] reportFile;
	
    
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private PatientModel patient;


	public int getReportId() {
		return reportId;
	}


	public void setReportId(int reportId) {
		this.reportId = reportId;
	}


	public Date getReportCreateDate() {
		return reportCreateDate;
	}


	public void setReportCreateDate(Date reportCreateDate) {
		this.reportCreateDate = reportCreateDate;
	}


	public Date getReportModifyDate() {
		return reportModifyDate;
	}


	public void setReportModifyDate(Date reportModifyDate) {
		this.reportModifyDate = reportModifyDate;
	}


	public byte[] getReportFile() {
		return reportFile;
	}


	public void setReportFile(byte[] reportFile) {
		this.reportFile = reportFile;
	}


	public PatientModel getPatient() {
		return patient;
	}


	public void setPatient(PatientModel patient) {
		this.patient = patient;
	}
    
    
    
    
}
