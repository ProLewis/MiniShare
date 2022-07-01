package com.cody.miniShare.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="sets")
public class Set {
	// Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Member Variables
	private String setName;
	
	private String releaseDate;
	
	// Data Creation Trackers
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	//Relationships
	@OneToMany(mappedBy = "parentSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Mini> setMinis;
	
	//Constructors
	public Set() {}
	
	// Data Creation Event
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
		

	@PreUpdate
	protected void onUpdate() {
		this.createdAt = new Date();
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Mini> getSetMinis() {
		return setMinis;
	}

	public void setSetMinis(List<Mini> setMinis) {
		this.setMinis = setMinis;
	}
	
	
}
