package com.stefanini.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_ENDERECO")
    private Long id;

    @Column(name = "DS_CEP")
    private String cep;

    @Column(name = "CO_UF")
    private String uf;

    @Column(name = "DS_CIDADE")
    private String localidade;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Column(name = "DS_LOGRADOURO")
    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "co_seq_pessoa", referencedColumnName = "co_seq_pessoa", nullable = false)
    private Pessoa pessoa;
    
    public Endereco() {
		
	}

	public Endereco(@NotNull String cep, @NotNull String uf, @NotNull String localidade, @NotNull String bairro, @NotNull String complemento, @NotNull String logradouro, Pessoa pessoa) {
		this.cep = cep;
		this.uf = uf;
		this.localidade = localidade;
		this.bairro = bairro;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.pessoa = pessoa;
	}

}
