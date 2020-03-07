package com.stefanini.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaPerfilServico;
import com.stefanini.servico.PessoaServico;

public class App {

	@Inject
	private PessoaServico servicoPessoa;
	
	@Inject
	private EnderecoServico servicoEndereco;
	
	@Inject
	private PerfilServico servicoPerfil;
	
	@Inject
	private PessoaPerfilServico servicoPessoaPerfil;
	

	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
//		salvar();
//		buscarTodos();
		encontrar();
//		remover();
	}
	
	
	private void remover() {
		servicoPessoa.remover(5L);
	}

	private void encontrar() {
		List<Pessoa> pessoa = new ArrayList();
		pessoa = servicoPessoa.getPessoaByNome("JOAO");
		
		for(Pessoa p: pessoa) {
            System.out.println(p);
        }
	}

	private void buscarTodos() {
		servicoPessoa.getList().ifPresent(i -> {
			i.forEach(b -> {
				System.out.println(b.getEnderecos());
				System.out.println(b);
//				System.out.println("aqui");
			});
		});
//		System.out.println("aqui");
	}

	public void salvar() {

		Pessoa pessoa = new Pessoa("JOAO", null, LocalDate.of(1995, 8, 24), true);
		pessoa.setEmail("joaom1.dev@hotmail.com");
		servicoPessoa.salvar(pessoa);
		
		Endereco endereco = new Endereco("123456", "DF", "Brasilia", "Riacho Fundo II", "Rua qualquer", "Rua", pessoa);
		servicoEndereco.salvar(endereco);
		
		LocalDateTime localDate = LocalDateTime.now();
		
		Perfil perfil = new Perfil("pessoa alta", "altura 1.80cm", localDate, localDate);
		servicoPerfil.salvar(perfil);
		
		PessoaPerfil pessoaPerfil = new PessoaPerfil(pessoa, perfil);
		servicoPessoaPerfil.salvar(pessoaPerfil);
	}

}
