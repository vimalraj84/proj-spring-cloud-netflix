package com.vimal.wage.determine.bo;

import java.math.BigDecimal;

public class EmpPayroll {
	
	private Integer id;
	private String roll ;
	private float wage;
	private float hours;
	private BigDecimal totalPay;
	
	
	public EmpPayroll() {
		
	}
	
	public EmpPayroll(Integer id, String roll, float wage, float hours, BigDecimal totalPay) {
		super();
		this.id = id;
		this.roll = roll;
		this.wage = wage;
		this.hours = hours;
		this.totalPay = totalPay;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public float getWage() {
		return wage;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public BigDecimal getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}
	
}
