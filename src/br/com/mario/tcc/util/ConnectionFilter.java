package br.com.mario.tcc.util;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.mario.tcc.bean.ContextBean;

@Service
@Scope("request")
public class ConnectionFilter implements Filter {

	@Autowired
	private ContextBean contextBean;
	private EntityManager entityManager;

	@Override
	public void init(FilterConfig config) throws ServletException {
		entityManager = contextBean.getEntityManagerForTenanty();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException {
		try {
			if (entityManager != null) {
				entityManager.getTransaction().begin();
			}
			
			//encaminha a requisição
			chain.doFilter(servletRequest, servletResponse);
			
			if (entityManager != null) {
				entityManager.getTransaction().commit();
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
			if (entityManager != null) {
				try {
					if (entityManager.getTransaction().isActive()) {
						entityManager.getTransaction().rollback();
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			throw new ServletException(ex);
		}
	}
}