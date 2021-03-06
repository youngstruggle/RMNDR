package com.nana.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nana.entities.Rcustomer;
import com.nana.services.RcustomerServicesImpl;

/**
 * @author Nana Febriana
 */

@Controller
public class RcustomerController {

	@Autowired
	RcustomerServicesImpl rCustomerServices;

	/* customerlist */
	@RequestMapping("/customerlist")
	public ModelAndView customerListView() {
		ModelAndView model = new ModelAndView("customerlistpage");
		try {
			List<Rcustomer> customerList = rCustomerServices.getCustomerList();
			System.out.println("customerlist " + customerList.size());
			model.addObject("customerlist", customerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* customerdelete */
	@RequestMapping(value = "/customerdelete/{id}", method = RequestMethod.GET)
	public String customerDeleteForm(@PathVariable("id") String id, RedirectAttributes attributes) {
		rCustomerServices.deleteCustomer(id);
		attributes.addFlashAttribute("msgdelete", "User has been removed successfully.");
		return "redirect:/customerlist";
	}
	
	/* customercreate */
	@RequestMapping(value = "/createcustomerform", method = RequestMethod.GET)
	public ModelAndView createCustomer() {
		return new ModelAndView("customerformpage", "rcustomer", new Rcustomer());
	}
	
	/* customercreate */
	@RequestMapping(value = "/submitcustomerform.html", method = RequestMethod.POST)
	public ModelAndView createCustomerForm(@ModelAttribute("rcustomer") @Valid Rcustomer rcustomer,
			BindingResult result, RedirectAttributes redirectAttr ) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("customerformpage");
			} else {
				rCustomerServices.createCustomer(rcustomer);
				model = new ModelAndView("redirect:/customerlist");
				redirectAttr.addFlashAttribute("msgcreate","Succesfully create user. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* customeredit */
	@RequestMapping(value = "/customeredit/{id}")
	public ModelAndView editCustomer(@PathVariable String id) {
		Rcustomer customer = rCustomerServices.getCustomerById(id);
		return new ModelAndView("customereditpage", "rcustomer", customer);
	}

	/* customeredit */
	@RequestMapping(value = "/submitcustomeredit", method = RequestMethod.POST)
	public ModelAndView editSaveCustomer(@ModelAttribute("rcustomer") Rcustomer rcustomer, BindingResult result) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("customereditpage");
			} else {
				rCustomerServices.updateCustomerObj(rcustomer);
				model = new ModelAndView("redirect:/customerlist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model; 
	}
}
