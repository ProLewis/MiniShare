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
@Table(name = "minis")
public class Mini {
	
	// Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Member Variables
	private String name;
	
	private String size;
	
	private Boolean painted;
	
	private String description;
	
	private String rarity;
	
	private Integer quantity;
	
	private Integer setNum;
	
	
	// Data Creation Trackers
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	// Relationships
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "set_id")
	private Set parentSet;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "collections_minis",
		joinColumns = @JoinColumn(name = "mini_id"),
		inverseJoinColumns = @JoinColumn(name = "collection_id")
	)
	private List<Collection> collections;
	
	//Constructors
	public Mini() {}
	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Boolean getPainted() {
		return painted;
	}


	public void setPainted(Boolean painted) {
		this.painted = painted;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRarity() {
		return rarity;
	}


	public void setRarity(String rarity) {
		this.rarity = rarity;
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSetNum() {
		return setNum;
	}

	public void setSetNum(Integer setNum) {
		this.setNum = setNum;
	}

	public Set getParentSet() {
		return parentSet;
	}

	public void setParentSet(Set parentSet) {
		this.parentSet = parentSet;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
}
