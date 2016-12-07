package com.hellokoding.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hellokoding.springboot.model.store;
@Repository
public interface StoreDAO extends CrudRepository<store, Integer>{

}
