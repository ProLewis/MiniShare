package com.cody.miniShare.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="collections")
public class Collection {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Member Variables
	private String collectionName;
	
	//Data Creation Trackers
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	//Relationships
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User collectionCreator;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "collections_minis",
		joinColumns = @JoinColumn(name = "collection_id"),
		inverseJoinColumns = @JoinColumn(name = "mini_id")
	)
	private List<Mini> minis;
	
	
	
	
	//Constructors 
	public Collection() {}
	
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

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
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

	public User getCollectionCreator() {
		return collectionCreator;
	}

	public void setCollectionCreator(User collectionCreator) {
		this.collectionCreator = collectionCreator;
	}

	public List<Mini> getMinis() {
		return minis;
	}

	public void setMinis(List<Mini> minis) {
		this.minis = minis;
	}
	
}
