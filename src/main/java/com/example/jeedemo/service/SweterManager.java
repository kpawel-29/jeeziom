package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Sweter;

@Stateless
public class SweterManager {

	@PersistenceContext
	EntityManager sm;

	public void addSweter(Sweter sweter) {
		sweter.setId(null);
		sm.persist(sweter);
	}

	public void deleteSweter(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		sm.remove(sweter);
	}

	@SuppressWarnings("unchecked")
	public List<Sweter> getAllSweter() {
		return sm.createNamedQuery("sweter.all").getResultList();
	}

}
