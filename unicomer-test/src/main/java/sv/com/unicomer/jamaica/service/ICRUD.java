package sv.com.unicomer.jamaica.service;

import java.util.List;

public interface ICRUD<T,k> {
	T add(T obj);
	T update(T obj);
	List<T> list();
	T readById(k id);
	void remove(k id);
}
