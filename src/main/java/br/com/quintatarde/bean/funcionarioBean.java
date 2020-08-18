package br.com.quintatarde.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintarde.dao.FuncionarioDao;
import br.com.quintatarde.domain.Funcionario;
import br.com.quintatarde.util.JsfUtil;





@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class funcionarioBean implements Serializable {

	private List<Funcionario> funcionarios;
	private Funcionario funcionario;
	private String acao;
	
	

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

			FuncionarioDao funcionariosDao = new FuncionarioDao();
			funcionarios = funcionariosDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			erro.printStackTrace();
		}
	}

	public void CarregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("funacao");
			
			String valor = JsfUtil.getParam("funcad");// parametro criado xhtml
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FuncionarioDao funcionariosDao = new FuncionarioDao();
				funcionario = funcionariosDao.buscar(codigo);
			}else {
				
				funcionario = new Funcionario();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao carregar");
			erro.printStackTrace();
		}
	}
	public void novo() {
		
		funcionario = new Funcionario();
	}

	public void salvar() {
		try {

			FuncionarioDao funcionariosDao = new FuncionarioDao();
			funcionariosDao.salvar(funcionario);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Salvar os estados");
			erro.printStackTrace();
		}
	}
	public void excluir() {
		try {

			FuncionarioDao funcionariosDao = new FuncionarioDao();
			funcionariosDao.excluir(funcionario);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor Removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover fornecedor");
			erro.printStackTrace();
		}
	}
	public void editar() {
		try {

			FuncionarioDao funcionariosDao = new FuncionarioDao();
			funcionariosDao.editar(funcionario);
			
			novo();
			
			Messages.addGlobalInfo("Forncedor editado com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editado fornecedor");
			erro.printStackTrace();
		}
	}
}
