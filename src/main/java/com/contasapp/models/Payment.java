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
	@Column(
	    columnDefinition = "NUMERIC(19,0)"
	)
	private Long id;
	
	private String description;
	private String data;
	private String note;
	
	public String getDescricao() {
		return note;
	}
			public void setDescricao(String descricao) {
				this.note = descricao;
	}
	public long getId() {
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
