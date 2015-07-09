package br.com.mario.tcc.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.DAO.impl.ProdutoDAOImpl;
import br.com.mario.tcc.model.Produto;
import br.com.mario.tcc.model.ProdutoService;
import br.com.mario.tcc.util.Messages;
import br.com.mario.tcc.util.RelatorioUtil;
import br.com.mario.tcc.util.UtilException;

@ManagedBean
@ViewScoped
public class ListProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -713376751300629859L;

	private static final String PAG = "/restrict/products.xhtml?faces-redirect=true";
	private String REPORT = "productsReport";
	
	@ManagedProperty(value = "#{contextBean}")
	private ContextBean contextBean;
	
	private ProdutoService produtoService;
	
	private List<Produto> list;
	
	private StreamedContent report;
	
	public String newPage(){
		return PAG;
	}

	public ContextBean getContextBean() {
		return contextBean;
	}

	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}

	public List<Produto> getList() {
		if(produtoService == null){
			ProdutoDAOImpl produtoDAOImpl = DAOFactory.createProdutoDAO(contextBean.getEntityManagerForTenanty());
			produtoService = new ProdutoService(produtoDAOImpl);
		}
		if (list == null || list.size() == 0) {
			list =  produtoService.list();
		}
		return list;
	}

	public void setList(List<Produto> list) {
		this.list = list;
	}
	
	public StreamedContent getReport(){
		report = null;
		String relatorioSaida = contextBean.getCodigo()+REPORT;
		RelatorioUtil<Produto> relatorioUtil = new RelatorioUtil<Produto>();
		try {
			report = relatorioUtil.buildReport(REPORT, relatorioSaida, 1, list);
		} catch (UtilException e) {
			Messages.addFatal("Erro", e.getMessage(), "msg");
			e.printStackTrace();
		}
		return report;
	}
	
}
