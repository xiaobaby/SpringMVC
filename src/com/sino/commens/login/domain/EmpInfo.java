package com.sino.commens.login.domain;

public class EmpInfo {

	//店主代码
	public String empNo;
	//店主姓名
	public String empName;
	//门店代码
	public String deptNo;
	//门店名称
	public String deptName;
	//门店名称
	public String deptFullName;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
