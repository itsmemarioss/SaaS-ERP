package br.com.mario.tcc.DAO;

import java.util.List;

public interface GenericDAO <T> {

	public void save(T object);
	public void update(T object);
	public void delete(T object);
	public T getById(long id);
	public List<T> list();
	public List<T> getByClause(String clause);
}
