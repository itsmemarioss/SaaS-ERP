package br.com.mario.tcc.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mario.tcc.DAO.DAOFactory;
import br.com.mario.tcc.DAO.impl.EmpresaDAOImpl;
import br.com.mario.tcc.DAO.impl.UsuarioDAOImpl;
import br.com.mario.tcc.model.DAOUtilService;
import br.com.mario.tcc.model.Empresa;
import br.com.mario.tcc.model.EmpresaService;
import br.com.mario.tcc.model.PermissaoEnum;
import br.com.mario.tcc.model.Usuario;
import br.com.mario.tcc.util.Messages;

@ManagedBean
@ViewScoped
public class NewEnterpriseBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1338267656520485534L;

	public static final String PAG = "/public/new-enterprise.xhtml?faces-redirect=true";
	public static final String PAG_MAIN = "/restrict/main.xhtml?faces-redirect=true";
	
	private Empresa empresa = new Empresa();
	Usuario usuario = new Usuario();
	private EmpresaService empresaService;
	private DAOUtilService daoUtilService;
	
	private boolean validaEmail;
	
	@Autowired
	private ContextBean contextBean;
	
	public String novo(){
		criaEmpresaService();
		return PAG;
	}
	
	public String saveEnterprise() {
		if (empresaService == null) criaEmpresaService();
		usuario.getPermissao().add(PermissaoEnum.ROLE_ADMIN.name());
		usuario.setAtivo(true);
		empresaService.save(empresa,usuario);
		Messages.addInfo("INFO: ", "Empresa Cadastrada com sucesso!", "growl");
		return PAG_MAIN;
	}

	private void criaEmpresaService() {
		EmpresaDAOImpl empresaDAOImpl = DAOFactory.createEmpresaDAO();		
		empresaService = new EmpresaService(empresaDAOImpl);
	}

	public ContextBean getContextBean() {
		return contextBean;
	}

	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getValidaEmail() {
		return validaEmail;
	}

	public void setValidaEmail(boolean validaEmail) {
		this.validaEmail = validaEmail;
	}
	
	public void blur(){
		setValidaEmail(emailNaoCadastrado());
	}

	private boolean emailNaoCadastrado() {
		if (daoUtilService == null) {
			daoUtilService = new DAOUtilService( DAOFactory.createDAOUtil());
		}
		setValidaEmail(!daoUtilService.existeEmail(this.usuario.getEmail()));
		return getValidaEmail();
	}
}
