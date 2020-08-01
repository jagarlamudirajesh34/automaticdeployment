package com.test.dao;

public interface Dao {
	void saveOrUpdate(Object entity);

	void save(Object entity);

	void update(Object entity);

	void delete(Object entity);

}