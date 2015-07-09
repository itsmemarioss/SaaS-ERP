package br.com.mario.tcc.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@RequestScoped
public class MainBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2036114513398571818L;
	
	private String codigo = "Not Setted";
	
	@ManagedProperty(value = "#{contextBean}")
	private ContextBean contextBean;
	
	public String getCodigo() {
		if (contextBean != null) {
			codigo = contextBean.getCodigo();
		}
		return codigo;
	}

	public ContextBean getContextBean() {
		return contextBean;
	}

	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
}
