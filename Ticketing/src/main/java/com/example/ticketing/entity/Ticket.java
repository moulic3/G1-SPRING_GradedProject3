package com.example.ticketing.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
//	private Date creation = new Date();

	public Ticket() {
	}

	public Ticket(int id, String title, String description, Date creation) {
		this.id = id;
		this.title = title;
		this.description = description;
//		this.creation = creation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Date getCreation() {
//		return creation;
//	}

//	public void setCreation(Date creation) {
//		this.creation = creation;
//	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", creation=" + 
				"]";
	}

}
