package br.com.sistema.web.repository;

import java.util.List;

public interface Repository<T> {
	List<T> lists();

	void save(T classe);

	void update(T classe);

	void del(T classe);

}
