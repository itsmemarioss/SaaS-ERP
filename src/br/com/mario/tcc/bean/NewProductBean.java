package br.com.mario.tcc.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.DAO.impl.ProdutoDAOImpl;
import br.com.mario.tcc.model.Produto;
import br.com.mario.tcc.model.ProdutoService;
import br.com.mario.tcc.util.Messages;

@ManagedBean(eager=true)
@RequestScoped
public class NewProductBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 420393384065504225L;
	
	public static final String PAG = "/restrict/new-product.xhtml";
	public static final String REDIRECT = "?faces-redirect=true";
	
	private Produto produto = new Produto();
	private String codigo = ":D~";
	
	@ManagedProperty(value = "#{contextBean}")
	private ContextBean contextBean;
	
	private ProdutoService produtoService;
	
	public String getCodigo() {
		if (contextBean != null) {
			codigo = contextBean.getCodigo();
		}
		return codigo;
	}
	
	/**
	 * Método que responsável por chamar a página de cadastro e iniciar configurações necessárias 
	 * @return
	 */
	public String newPage(){
		produto = new Produto();
		return PAG+REDIRECT;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void save() {
		if (produtoService == null) {
			ProdutoDAOImpl produtoDAOImpl = DAOFactory.createProdutoDAO(contextBean.getEntityManagerForTenanty());
			produtoService = new ProdutoService(produtoDAOImpl);
		}
		
		produtoService.save(produto);
		Messages.addInfo("INFO:", "Produto cadastrado com sucesso!", "growl");
		newPage();
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public ContextBean getContextBean() {
		return contextBean;
	}

	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
}
