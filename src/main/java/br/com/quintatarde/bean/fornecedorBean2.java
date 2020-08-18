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




@SuppressWarnings("serial")
@ManagedBean // diz para o tomcat que essa classe é responsavel pelo controle e do modelo
@ViewScoped // tempo de vida do objeto

public class fornecedorBean2 implements Serializable {
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

			FornecedorDao fornecedoresDao = new FornecedorDao();
			fornecedores = fornecedoresDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			erro.printStackTrace();
		}
	}

	public void CarregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("foracao");
			
			String valor = JsfUtil.getParam("forcad");// parametro criado xhtml
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FornecedorDao fornecedoresDao = new FornecedorDao();
				fornecedor = fornecedoresDao.buscar(codigo);
			}else {
				
				fornecedor = new Fornecedor();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao carregar");
			erro.printStackTrace();
		}
	}
	public void novo() {
		
		fornecedor = new Fornecedor();
	}

	public void salvar() {
		try {

			FornecedorDao fornecedoresDao = new FornecedorDao();
			fornecedoresDao.salvar(fornecedor);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Salvar os estados");
			erro.printStackTrace();
		}
	}
	public void excluir() {
		try {

			FornecedorDao fornecedoresDao = new FornecedorDao();
			fornecedoresDao.excluir(fornecedor);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover fornecedor");
			erro.printStackTrace();
		}
	}
	public void editar() {
		try {

			FornecedorDao fornecedoresDao = new FornecedorDao();
			fornecedoresDao.editar(fornecedor);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor editado com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editado fornecedor");
			erro.printStackTrace();
		}
	}
}
