package br.com.mario.tcc.model;

public enum PermissaoEnum {
	
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_ROOT("ROLE_ROOT"),
	ROLE_USER("ROLE_USER");
	
	public String name;

	private PermissaoEnum(String name) {
		this.name = name;
	}
		
}
