package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_PERFIL")
	private long id;
	
	@NotNull
	@Column(name = "NO_PERFIL")
	private String caracteristica;
	
	@NotNull
	@Column(name = "DS_PERFIL")
	private String descricao;
	
	@NotNull
	@Column(name = "DT_HORA_INCLUSAO", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataIn;
	
	@Column(name = "DT_HORA_ALTERACAO", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataAl;
	
	public Perfil() {
		
	}

	public Perfil(@NotNull String caracteristica, @NotNull String descricao, LocalDateTime dataIn, LocalDateTime dataAl) {
		super();
		this.caracteristica = caracteristica;
		this.descricao = descricao;
		this.dataIn = dataIn;
		this.dataAl = dataAl;
	}
	
}
