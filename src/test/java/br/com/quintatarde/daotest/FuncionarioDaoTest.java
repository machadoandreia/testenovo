package br.com.quintatarde.daotest;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.quintarde.dao.FuncionarioDao;
import br.com.quintatarde.domain.Funcionario;

public class FuncionarioDaoTest {

	@Test
	@Ignore
	public void Salvar() {

		Funcionario funcionario = new Funcionario();// Instancia��o de objeto referente o fornecedor, para salvar no banco
													// de dados

		funcionario.setNome("Mario");
		funcionario.setCpf("309246180");
		funcionario.setFuncao("Pedreiro");
		funcionario.setSenha("654321");
		
		
										// Preenchimento do campo respectivo � tabela 'Funcionarios'

		FuncionarioDao funcionarioDao = new FuncionarioDao();// Realiza��o da inser��o no banco de dados
		funcionarioDao.salvar(funcionario);

		System.out.println("�xito no cadastro do funcionario");// mensagem de sucesso, imprimir.
	}

	@Test
	@Ignore
	public void listar() {

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> resultado = funcionarioDao.listar();

		System.out.println("Total de registros: " + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getCpf());
			System.out.println(funcionario.getSenha());
			System.out.println(funcionario.getFuncao());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 5L;

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(funcionario.getNome());
		}

	}

	@Test
	@Ignore

	public void excluir() {
		Long codigo = 7L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			funcionarioDao.excluir(funcionario);
			System.out.println("Registro encontrado");
			System.out.println(funcionario.getNome());
		}
	}
@Test
@Ignore
public void editar() {
	Long codigo = 6L;
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	Funcionario funcionario = funcionarioDao.buscar(codigo);

	if (funcionario == null) {
		System.out.println("Nenhum registro encontrado");

	} else {
		funcionario.setNome("Maria");
		funcionarioDao.editar(funcionario);
		System.out.println("Registro encontrado");
		System.out.println(funcionario.getNome());
	}
	
}
}
