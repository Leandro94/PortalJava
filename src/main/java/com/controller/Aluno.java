package com.controller;

import org.bson.types.ObjectId;

public class Aluno {
	private ObjectId _id;
	private String nome;
	private Integer nota;
	private Integer falta;
	private String periodo;
	private String matricula;
	public Aluno(){}
	
	public Aluno(ObjectId _id, String nome, Integer nota, Integer falta,String periodo, String matricula) 
	{
		super();
		this._id = _id;
		this.nome = nome;
		this.nota = nota;
		this.falta = falta;
		this.periodo = periodo;
		this.matricula = matricula;
	}

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public Integer getFalta() {
		return falta;
	}
	public void setFalta(Integer falta) {
		this.falta = falta;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
