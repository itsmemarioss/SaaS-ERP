package br.com.mario.tcc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	private ContextBean contextBean;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		System.out.println("INFO: Evento de logging bem sucedido capturado...");
		
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        System.out.println("INFO: Usu�rio "+userDetails.getUsername()+" logando com a senha '"+userDetails.getPassword()+"'");
        
        System.out.println("INFO: Iniciando configura��o do SessionBean...");

        String mensagem = contextBean.configureBean(userDetails.getUsername()) ? "INFO: Iniciando configura��o do SessionBean..." : "ERRO: Erro cr�tico ao criar ContextBean...";
        System.out.println(mensagem);
        System.out.println(contextBean.getTenantId());
        System.out.println("INFO: C�digo definido com tenant id..."+contextBean.getCodigo());
	}

	public ContextBean getContextBean() {
		return contextBean;
	}

	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
	

}