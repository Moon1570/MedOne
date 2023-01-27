package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "admin_phone")
	private String adminPhone;
	
	@Column(name = "admin_password")
	private String adminPassword;
	

	@Lob
    @Column(name="admin_image", nullable=false, columnDefinition="mediumblob")
    private byte[] adminImage;

	public int getAdminId() {
		return adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}
	
	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public byte[] getAdminImage() {
		return adminImage;
	}

	public void setAdminImage(byte[] adminImage) {
		this.adminImage = adminImage;
	}
	

}
