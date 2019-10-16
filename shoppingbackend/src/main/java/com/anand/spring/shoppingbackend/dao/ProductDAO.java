package com.anand.spring.shoppingbackend.dao;

import java.util.List;

public interface ProductDAO extends DAO {

	public List<?> findXAlls(Integer count);

	public List<?> findTopRated(Integer count);
}
