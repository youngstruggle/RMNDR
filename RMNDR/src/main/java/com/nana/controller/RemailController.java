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

import com.nana.entities.Remail;
import com.nana.services.RemailServicesImpl;

/**
 * @author Nana Febriana
 */

@Controller
public class RemailController {

	@Autowired
	RemailServicesImpl rEmail;

	/* emaillist */
	@RequestMapping("/emailslist")
	public ModelAndView customerListView() {
		ModelAndView model = new ModelAndView("emaillistpage");
		try {
			List<Remail> emaillist = rEmail.getEmailList();
			System.out.println("emaillist " + emaillist.size());
			model.addObject("emailslist", emaillist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* emaildelete */
	@RequestMapping(value = "/emaildelete/{id}", method = RequestMethod.GET)
	public String customerDeleteForm(@PathVariable("id") String id, RedirectAttributes attributes) {
		rEmail.deleteEmail(id);
		attributes.addFlashAttribute("msgdelete", "User has been removed successfully.");
		return "redirect:/emailslist";
	}
	
	/* emailcreate */
	@RequestMapping(value = "/createemailsform", method = RequestMethod.GET)
	public ModelAndView createEmail() {
		return new ModelAndView("emailformpage", "remail", new Remail());
	}
	
	/* emailcreate */
	@RequestMapping(value = "/submitemailsform.html", method = RequestMethod.POST)
	public ModelAndView createCustomerForm(@ModelAttribute("remail") @Valid Remail remail,
			BindingResult result, RedirectAttributes redirectAttr ) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("emailsformpage");
			} else {
				rEmail.createEmail(remail);
				model = new ModelAndView("redirect:/emailslist");
				redirectAttr.addFlashAttribute("msgcreate","Succesfully create user. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* emailedit */
	@RequestMapping(value = "/emailedit/{id}")
	public ModelAndView editCustomer(@PathVariable String id) {
		Remail email = rEmail.getEmailById(id);
		return new ModelAndView("emaileditpage", "remail", email);
	}

	/* emailedit */
	@RequestMapping(value = "/submiteditform", method = RequestMethod.POST)
	public ModelAndView editSaveCustomer(@ModelAttribute("remail") Remail remail, BindingResult result) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("emaileditpage");
			} else {
				rEmail.updateEmailObj(remail);
				model = new ModelAndView("redirect:/emailslist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model; 
	}
}
