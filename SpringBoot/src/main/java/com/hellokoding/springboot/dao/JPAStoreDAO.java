package com.hellokoding.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hellokoding.springboot.model.store;
@Repository
public interface JPAStoreDAO extends JpaRepository<store, Integer>{

}
