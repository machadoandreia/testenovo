package br.com.quintatarde.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintarde.dao.FornecedorDao;
import br.com.quintarde.dao.ProdutoDao;
import br.com.quintatarde.domain.Fornecedor;
import br.com.quintatarde.domain.Produto;
import br.com.quintatarde.util.JsfUtil;





@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{

	private List<Produto> produtos;
	private Produto produto;
	private String acao;
	private List<Fornecedor> fornecedores;
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}	
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@PostConstruct
	public void listar() {
		try {

			ProdutoDao produtosDao = new ProdutoDao();
			produtos = produtosDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			erro.printStackTrace();
		}
	}

	public void CarregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("proacao");
			
			String valor = JsfUtil.getParam("procod");// parametro criado xhtml
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				ProdutoDao produtosDao = new ProdutoDao();
				produto = produtosDao.buscar(codigo);
			}else {
				
				produto = new Produto();
			}
			
			FornecedorDao fornecedoresDao = new FornecedorDao();
			fornecedores = fornecedoresDao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao carregar");
			erro.printStackTrace();
		}
	}
	public void novo() {
		
		produto = new Produto();
	}

	public void salvar() {
		try {

			ProdutoDao produtosDao = new ProdutoDao();
			produtosDao.salvar(produto);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Salvar os estados");
			erro.printStackTrace();
		}
	}
	public void excluir() {
		try {

			ProdutoDao produtosDao = new ProdutoDao();
			produtosDao.excluir(produto);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover fornecedor");
			erro.printStackTrace();
		}
	}
	public void editar() {
		try {

			ProdutoDao produtosDao = new ProdutoDao();
			produtosDao.editar(produto);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor editado com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editado fornecedor");
			erro.printStackTrace();
		}
	}
}
