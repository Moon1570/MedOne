package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.annotation.Generated;

@Entity
@Table(name = "drugs")
public class DrugModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drug_id")
	private int drugId;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="dosage_form")
	private String dosageForm;
	
	@Column(name = "generics")
	private String generics;
	
	@Column(name ="manufacturer")
	private String manufacturer;
	
	@Column(name = "package_container")
	private String packageContainer;
	
	@Column(name = "package_size")
	private String packageSize;

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public String getGenerics() {
		return generics;
	}

	public void setGenerics(String generics) {
		this.generics = generics;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPackageContainer() {
		return packageContainer;
	}

	public void setPackageContainer(String packageContainer) {
		this.packageContainer = packageContainer;
	}

	public String getPackageSize() {
		return packageSize;
	}

	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}
	
	
	
}
