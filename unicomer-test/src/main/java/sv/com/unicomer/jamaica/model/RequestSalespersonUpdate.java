package sv.com.unicomer.jamaica.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestSalespersonUpdate {
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
	
	public RequestSalespersonUpdate() {
		// TODO Auto-generated constructor stub
	}

	public RequestSalespersonUpdate(String firstName, String lastName, LocalDateTime birthDay, String gender,
			String cellPhone, String addressHome, String profession, Double incomes) {
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
