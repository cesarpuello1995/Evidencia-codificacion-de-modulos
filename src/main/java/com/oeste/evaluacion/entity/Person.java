package com.oeste.evaluacion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_schema")
public class Person implements Serializable{

	private static final long serialVersionUID = 6633873855081582784L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Long age;
	
	@Column(nullable = false)
	private String gender;
	
	private String code;
	
	private Date createAt;
	
//	@ColumnDefault(value = "true")
	@Column(columnDefinition = "tinyint(1) default true")
	private Boolean enabled;

	public Person() {}
	
	public Person(String name, Long age) {
		this.name = name;
		this.age = age;
		this.createAt = new Date();
		this.gender = genero("");
		this.enabled = true;
		this.code = cadenaAleatoria(10);
	}
	
	public Person(String name, Long age, String gender) {
		this.name = name;
		this.age = age;
		this.createAt = new Date();
		this.gender = genero(gender);
		this.enabled = true;
		this.code = cadenaAleatoria(10);	
	}

	public static String genero(String gender) {
		switch (gender) {
		case "M":
		case "H":
			return gender;
		default:
			return "";
		}
	}
	
	public static String cadenaAleatoria(int longitud) {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    StringBuilder bld = new StringBuilder();
	    for (int x = 0; x < longitud; x++) {
	        int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        bld.append(caracterAleatorio);
	    }
	    return bld.toString();
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }


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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
