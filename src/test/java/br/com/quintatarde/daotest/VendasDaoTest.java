package br.com.quintatarde.daotest;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.quintarde.dao.FuncionarioDao;
import br.com.quintarde.dao.VendaDao;
import br.com.quintatarde.domain.Funcionario;
import br.com.quintatarde.domain.Venda;

public class VendasDaoTest {

	@Test
	@Ignore
	public void Salvar() {
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		Funcionario funcionario = funcionarioDao.buscar(3L);

		Venda venda = new Venda();// Instancia��o de objeto referente a vendas, para salvar no banco
													// de dados

		venda.setHora(new Date());
		venda.setTotal(2);
		venda.setFuncionario(funcionario);// Preenchimento do campo respectivo � tabela 'Vendas'

		VendaDao vendasDao = new VendaDao();// Realiza��o da inser��o no banco de dados
		vendasDao.salvar(venda);

		System.out.println("�xito no cadastro da venda");// mensagem de sucesso, imprimir.
	}

	@Test
	//@Ignore
	public void listar() {

		VendaDao vendaDao = new VendaDao();
		List<Venda> resultado = vendaDao.listar();

		System.out.println("Total de registros: " + resultado.size());

		for (Venda venda : resultado) {
			System.out.println(venda.getHora());
			System.out.println(venda.getTotal());
			System.out.println(venda.getFuncionario());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 5L;

		VendaDao vendasDao = new VendaDao();
		Venda vendas = vendasDao.buscar(codigo);

		if (vendas == null) {
			System.out.println("Nenhum registro encontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(vendas.getHora());
		}

	}

	@Test
	@Ignore

	public void excluir() {
		Long codigo = 7L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			vendaDao.excluir(venda);
			System.out.println("Registro encontrado");
			System.out.println(venda.getHora());
		}
	}
@Test
@Ignore
public void editar() {
	Long codigo = 6L;
	VendaDao vendaDao = new VendaDao();
	Venda venda = vendaDao.buscar(codigo);

	if (venda == null) {
		System.out.println("Nenhum registro encontrado");

	} else {
		venda.setHora(new Date());
		vendaDao.editar(venda);
		System.out.println("Registro encontrado");
		System.out.println(venda.getHora());
	}
	
}
}
