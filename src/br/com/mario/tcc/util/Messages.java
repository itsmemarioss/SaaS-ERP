package br.com.mario.tcc.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {

	public static void addInfo(String titulo, String mensagem, String target ) {
		FacesContext.getCurrentInstance().addMessage(target, new FacesMessage(FacesMessage.SEVERITY_INFO,titulo, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public static void addWarn(String titulo, String mensagem, String target ) {
		FacesContext.getCurrentInstance().addMessage(target, new FacesMessage(FacesMessage.SEVERITY_WARN,titulo, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public static void addError(String titulo, String mensagem, String target ) {
		FacesContext.getCurrentInstance().addMessage(target, new FacesMessage(FacesMessage.SEVERITY_ERROR,titulo, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public static void addFatal(String titulo, String mensagem, String target ) {
		FacesContext.getCurrentInstance().addMessage(target, new FacesMessage(FacesMessage.SEVERITY_FATAL,titulo, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
}
			
