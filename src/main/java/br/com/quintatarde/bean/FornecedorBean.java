package br.com.quintatarde.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintarde.dao.FornecedorDao;
import br.com.quintatarde.domain.Fornecedor;
import br.com.quintatarde.util.JsfUtil;

@ManagedBean
@ViewScoped
public class FornecedorBean implements Serializable {

	private List<Fornecedor> fornecedores;

	private Fornecedor fornecedor;
	
	private String acao;
	
	

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Fornecedor getFornecedor() {

		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@PostConstruct
	public void listar() {
		try {

			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedores = fornecedorDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os fornecedor");
			erro.printStackTrace();
		}
	}

	public void carregarCadastro() {
		try {
			
			acao=JsfUtil.getParam("foracao");

			String valor = JsfUtil.getParam("forcad");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FornecedorDao fornecedorDao = new FornecedorDao();
				fornecedor = fornecedorDao.buscar(codigo);
			
			} else {

				fornecedor = new Fornecedor();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao carregar o fornecedor");
			erro.printStackTrace();
		}

	}

	public void novo() {

		fornecedor = new Fornecedor();

	}

	public void salvar() {

		try {

			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.salvar(fornecedor);
			
			fornecedor=new Fornecedor();

			Messages.addGlobalInfo("Forncedor Salvo com Sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar forncedor");
			erro.printStackTrace();
		}

	}

	public void excluir() {
		try {

			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.excluir(fornecedor);
			novo();
			Messages.addGlobalInfo("Fornecedor Removido com Sucesso!!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover forncedor");
			erro.printStackTrace();
		}
	}

	public void editar() {
		try {

			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.editar(fornecedor);
			novo();
			Messages.addGlobalInfo("Fornecedor atualizado com Sucesso!!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao atualizar forncedor");
			erro.printStackTrace();
		}

	}
}
