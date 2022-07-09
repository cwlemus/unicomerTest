package sv.com.unicomer.jamaica.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información o propiedes del vendedor")
@Entity
@Table(name = "salesperson")
public class Salesperson {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idSalesperson;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime birthDay;
	private String gender;
	private String cellPhone;
	private String addressHome;
	private String profession;
	private Double incomes;
	
	public Salesperson() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Salesperson(String firstName, String lastName, LocalDateTime birthDay, String gender, String cellPhone,
			String addressHome, String profession, Double incomes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.addressHome = addressHome;
		this.profession = profession;
		this.incomes = incomes;
	}



	public Salesperson(Integer idSalesperson, String firstName, String lastName, LocalDateTime birthDay, String gender,
			String cellPhone, String addressHome, String profession, Double incomes) {
		super();
		this.idSalesperson = idSalesperson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.cellPhone = cellPhone;
		this.addressHome = addressHome;
		this.profession = profession;
		this.incomes = incomes;
	}



	public Integer getIdSalesperson() {
		return idSalesperson;
	}

	public void setIdSalesperson(Integer idSalesperson) {
		this.idSalesperson = idSalesperson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDateTime birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getAddressHome() {
		return addressHome;
	}

	public void setAddressHome(String addressHome) {
		this.addressHome = addressHome;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Double getIncomes() {
		return incomes;
	}

	public void setIncomes(Double incomes) {
		this.incomes = incomes;
	}
	
	
}
