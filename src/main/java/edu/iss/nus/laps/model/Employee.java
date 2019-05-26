package edu.iss.nus.laps.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.PostLoad;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.iss.nus.laps.repository.EmployeeRepo;
import edu.iss.nus.laps.repository.ManagerRepo;

@Entity
public class Employee {
	
	@Id
	@NotBlank(message = "Name may not be empty")
	@Column(name = "empid")
	private String empid;
	private String empname;
	private String emppassword;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future
	private LocalDate endDate;
	private String leaveType;
	private String status;
	private String reason;
	private String managerComment;
	private int annualLeave;
	private int medicalLeave;
	private int noOfLeave;
	private int weekends;
	private int publicholidays;
	@Transient
	private String newdate;
	@Transient
	private String radio;

	@ManyToOne(targetEntity=Manager.class)
	private Manager managerfk;
	
	@OneToMany(mappedBy = "arcemployee", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<UserArchive> arcemplist;
	
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getManagerComment() {
		return managerComment;
	}
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	public int getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}
	public int getMedicalLeave() {
		return medicalLeave;
	}
	public void setMedicalLeave(int medicalLeave) {
		this.medicalLeave = medicalLeave;
	}
	public int getNoOfLeave() {
		return noOfLeave;
	}
	public void setNoOfLeave(int noOfLeave) {
		this.noOfLeave = noOfLeave;
	}
	public int getWeekends() {
		return weekends;
	}
	public void setWeekends(int weekends) {
		this.weekends = weekends;
	}
	public int getPublicholidays() {
		return publicholidays;
	}
	public void setPublicholidays(int publicholidays) {
		this.publicholidays = publicholidays;
	}
	public String getNewdate() {
		return newdate;
	}
	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	
	public Employee() {
		super();
	}

	public Manager getManagerfk() {
		return managerfk;
	}

	public void setManagerfk(Manager managerfk) {
		this.managerfk = managerfk;
	}

	
	public List<UserArchive> getArcemplist() {
		return arcemplist;
	}

	public void setArcemplist(List<UserArchive> arcemplist) {
		this.arcemplist = arcemplist;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", emppassword=" + emppassword + ", startDate="
				+ startDate + ", endDate=" + endDate + ", leaveType=" + leaveType + ", status=" + status + ", reason="
				+ reason + ", managerComment=" + managerComment + ", annualLeave=" + annualLeave + ", medicalLeave="
				+ medicalLeave + ", noOfLeave=" + noOfLeave + ", weekends=" + weekends + ", publicholidays="
				+ publicholidays + ", newdate=" + newdate + ", radio=" + radio + "]";
	}

	

	
	

	

	


	



	
	
	
	
	

}
