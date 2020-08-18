package br.com.quintatarde.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JsfUtil {

	public static String getParam(String nome) {
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		ExternalContext contextoExterno =contexto.getExternalContext();
		Map<String, String>parametros = contextoExterno.getRequestParameterMap();
		String valor= parametros.get(nome);
		return valor;
		

	}

}
