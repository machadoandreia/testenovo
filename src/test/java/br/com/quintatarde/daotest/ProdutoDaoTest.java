package br.com.quintatarde.daotest;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.quintarde.dao.FornecedorDao;
import br.com.quintarde.dao.ProdutoDao;
import br.com.quintatarde.domain.Fornecedor;
import br.com.quintatarde.domain.Produto;


public class ProdutoDaoTest {

	@Test
	@Ignore
	public void Salvar() {
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(4L);

		Produto produto = new Produto();// Instancia��o de objeto referente o fornecedor, para salvar no banco
												// de dados
		produto.setNome("Caneta");
		produto.setValor(6.0f);
		produto.setQtde(2);
		produto.setFornecedor(fornecedor);
		
									// Preenchimento do campo respectivo � tabela 'Produto'

		ProdutoDao produtoDao = new ProdutoDao();// Realiza��o da inser��o no banco de dados
		produtoDao.salvar(produto);

		System.out.println("Exito no cadastro do produto");// mensagem de sucesso, imprimir.
	}

	@Test
	//@Ignore
	public void listar() {

		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> resultado = produtoDao.listar();

		System.out.println("Total de registros: " + resultado.size());

		for (Produto produto : resultado) {
			System.out.println(produto.getNome());
			System.out.println(produto.getValor());
			System.out.println(produto.getQtde());
			System.out.println(produto.getFornecedor());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 5L;

		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(produto.getNome());
		}

	}

	@Test
	@Ignore

	public void excluir() {
		Long codigo = 7L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			produtoDao.excluir(produto);
			System.out.println("Registro encontrado");
			System.out.println(produto.getNome());
		}
	}
@Test
@Ignore
public void editar() {
	Long codigo = 6L;
	ProdutoDao produtoDao = new ProdutoDao();
	Produto produto = produtoDao.buscar(codigo);

	if (produto == null) {
		System.out.println("Nenhum registro encontrado");

	} else {
		produto.setNome("Lapis");
		produtoDao.editar(produto);
		System.out.println("Registro encontrado");
		System.out.println(produto.getNome());
	}
	
}
}