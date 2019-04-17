package com.bilqu.wage.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "emp_wage")
public class EmpWage {
	
	@Id
	private Integer id;
	
	@Column(name = "roll")
	private String roll ;
	
	@Column(name = "wage")
	private float wage;
	
	public EmpWage() {
		
	}

	public EmpWage(Integer id, float wage, String roll) {
		super();
		this.id = id;
		this.roll = roll;
		this.wage = wage;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getWage() {
		return wage;
	}

	public void setWage(float wage) {
		this.wage = wage;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

}
