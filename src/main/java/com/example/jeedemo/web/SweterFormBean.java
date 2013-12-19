package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.SweterManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("sweterBean")
public class SweterFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sweter sweter = new Sweter();
	private ListDataModel<Sweter> sweters = new ListDataModel<Sweter>();

	@Inject
	private SweterManager sm;

	
	public Sweter getSweter() {
		return sweter;
	}

	public void setSweter(Sweter sweter) {
		this.sweter = sweter;
	}

	public ListDataModel<Sweter> getAllSweter() {
		sweters.setWrappedData(sm.getAllSweter());
		return sweters;
	}

	// Actions
	public String addSweter() {
		sm.addSweter(sweter);
		return "showSweter";
		// return null;
	}

	public String deleteSweter() {
		Sweter sweterToDelete = sweters.getRowData();
		sm.deleteSweter(sweterToDelete);
		return null;
	}
}
