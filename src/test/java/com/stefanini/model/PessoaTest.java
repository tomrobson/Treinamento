package com.stefanini.model;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class PessoaTest {
	
	private Validator validator;
	 
	  @Before
	  public void setUp() {
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    this.validator = factory.getValidator();
	  }
	  
	  @Test
	  public void naoDeveAceitarSobrenomeCurto() {
	    Pessoa pessoa = new Pessoa();
	    pessoa.setNome("Ana");
//	    cliente.setSobrenome("S.");
	 
	    Set<ConstraintViolation<Pessoa>> restricoes = validator.validate(pessoa);
	    System.out.println(restricoes.size());
//	    assertThat(restricoes, hasSize(1));
//	    assertThat(getNomePrimeiraPropriedade(restricoes), is("sobrenome"));
	  }
	  
//	  @Test
//	  private Endereco findByEndereco(Session session, String uf) {
//		  CriteriaBuilder cb = session.getCriteriaBuilder();
//		  CriteriaQuery<Endereco> q = cb.createQuery(Endereco.class);
//		  
//		  Root<Endereco> entityRoot = q.from(Endereco.class);
//		  q.select(entityRoot);
//		  
//		  ParameterExpression<String> p = cb.parameter(String.class);
//		  q.where(cb.equal(entityRoot.get("uf"), uf));
//		  
//		  return session.createQuery(q).getSingleResult();
//	  }
	  
//	  @Test
//	  public void findPessoaUsandoNativeQuery() {
//		  try (Session session = factoryJpa.openSession()){
//			  Endereco endereco = findByEndereco(session, "DF");
//			  System.out.print("Endereco: " + endereco );
//		  }
//	  }

}
