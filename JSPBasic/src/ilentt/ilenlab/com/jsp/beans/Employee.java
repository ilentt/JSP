package ilentt.ilenlab.com.jsp.beans;

public class Employee {

	private String EmpNo;
	private String EmpName;
	
	public Employee() {
		// constructor
		this.EmpNo = "";
		this.EmpName ="";
	}
	
	public String getEmpNo() {
		return this.EmpNo;
	}
	
	public void setEmpNo(String EmpNo) {
		this.EmpNo = EmpNo;
	}
	
	public String getEmpName() {
		return this.EmpName;
	}
	
	public void setEmpName(String EmpName) {
		this.EmpName = EmpName;
	}
}

