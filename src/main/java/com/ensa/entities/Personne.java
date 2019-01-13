package com.ensa.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ensa.adapter.JaxbDateAdapter;

@XmlRootElement(name="personne")
public class Personne {

	
	private Long id ;
	private String name;
	private Date dob;
	
	
	
	public Personne(Long id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}


	@XmlAttribute(name = "refId")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@XmlElement(name="dob")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getCsvDob() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(getDob());
		}

}
