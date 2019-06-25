package com.contasapp.models;

public class Payment {
	private int id;
	private String description;
	private String data;
	private String note;
	
	public String getDescricao() {
		return note;
	}
			public void setDescricao(String descricao) {
				this.note = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
