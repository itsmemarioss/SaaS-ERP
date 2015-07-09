package br.com.mario.tcc.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.NEW;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.DAO.impl.ProdutoDAOImpl;

public class ProdutoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6219936826816277703L;
	
	private ProdutoDAOImpl produtoDAOImpl;
	
	public ProdutoDAOImpl getProdutoDAOImpl() {
		return produtoDAOImpl;
	}

	public void setProdutoDAOImpl(ProdutoDAOImpl produtoDAOImpl) {
		this.produtoDAOImpl = produtoDAOImpl;
	}
	
	public ProdutoService(ProdutoDAOImpl produtoDAOImpl) {
		this.produtoDAOImpl = produtoDAOImpl;
	}
	
	public void save(Produto produto) {
		produtoDAOImpl.save(produto);
	}

	public List<Produto> list() {
		return produtoDAOImpl.list();
	}
	
}