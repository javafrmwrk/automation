package com.hellokoding.springboot.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.springboot.dao.StoreDAO;
import com.hellokoding.springboot.dao.JPAStoreDAO;
import com.hellokoding.springboot.model.store;

@Service
public class StoreService {

	@Autowired
	private StoreDAO storeDAO;

	@Autowired
	private JPAStoreDAO jpastoreDAO;

	public void addStore(){
           store addStore=new store();
           addStore.setStoreId(1);
           addStore.setStoreName("walmart Chiago2");
		  storeDAO.save(addStore);
		System.out.println("Store Item is added");

		store s=storeDAO.findOne(1);
		System.out.println("find the details name:"+ s.getStoreName());
	}

	public void findAllStore(){
		Iterable<store> storeList=storeDAO.findAll();
		for(store s:storeList){
			System.out.println("Store Id:"+s.getStoreId());
			System.out.println("Store Name:"+s.getStoreName());
		}

	}

	public void JPAFindStore(){

		List<store> s=jpastoreDAO.findAll();
		System.out.println("find the details name:"+ s.size());
	}
}
