package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="Student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="Id")
private int id;

@Column(name="Name")
private String name;

@Column(name="Standard")
private int standard;

public Student() {

}

public Student(int id, String name, int standard) {
	super();
	this.id = id;
	this.name = name;
	this.standard = standard;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public int getStandard() {
	return standard;
}

public void setStandard(int standard) {
	this.standard = standard;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", standard=" + standard + "]";
}


}
