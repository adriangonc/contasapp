package com.contasapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(
	    strategy = GenerationType.AUTO
	)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DATA")
	private String data;
	
	@Column(name = "NOTE")
	private String note;
	
	public String getDescricao() {
		return note;
	}
			public void setDescricao(String descricao) {
				this.note = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return description;
	}
	public void setNome(String nome) {
		this.description = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
