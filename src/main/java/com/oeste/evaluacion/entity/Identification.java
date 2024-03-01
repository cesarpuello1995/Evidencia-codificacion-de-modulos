package com.oeste.evaluacion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identification_schema")
public class Identification implements Serializable{

	private static final long serialVersionUID = -6778223459569060695L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(length = 50, nullable = false)
	private String identificationName;
	
	@Column(nullable = false)
	private Long description;
	
	private Date createAt;
	
//	@ColumnDefault(value = "true")
	@Column(columnDefinition = "tinyint(1) default true")
	private Boolean enabled;

	public Identification() {}
	
	public Identification(String identificationName, Long description) {
		this.identificationName = identificationName;
		this.description = description;
		this.createAt = new Date();
		this.enabled = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificationName() {
		return identificationName;
	}

	public void setIdentificationName(String identificationName) {
		this.identificationName = identificationName;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
