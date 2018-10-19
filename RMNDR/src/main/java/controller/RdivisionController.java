package controller;

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

import services.RdivisionServicesImpl;
import entities.Rdivision;

/**
 * @author Nana Febriana
 */

@Controller
public class RdivisionController {

	@Autowired
	RdivisionServicesImpl rDivisionServices;

	/* divisionlist */
	@RequestMapping("/divisionlist")
	public ModelAndView userDivisionView() {
		ModelAndView model = new ModelAndView("divisionlistpage");
		try {
			List<Rdivision> divisionList = rDivisionServices.getDivisionList();
			System.out.println("division " + divisionList.size());
			model.addObject("divisionlist", divisionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* divisiondelete */
	@RequestMapping(value = "/divisiondelete/{id}", method = RequestMethod.GET)
	public String userDeleteForm(@PathVariable("id") String id, RedirectAttributes attributes) {
		rDivisionServices.deleteDivision(id);
		attributes.addFlashAttribute("msgdelete", "User has been removed successfully.");
		return "redirect:/divisionlist";
	}
	
	/* divisioncreate */
	@RequestMapping(value = "/createdivisionform", method = RequestMethod.GET)
	public ModelAndView createDivision() {
		return new ModelAndView("divisionformpage", "rdivision", new Rdivision());
	}
	
	/* divisioncreate */
	@RequestMapping(value = "/submitdivisionform.html", method = RequestMethod.POST)
	public ModelAndView createDivisionForm(@ModelAttribute("rdivision") @Valid Rdivision rdivision,
			BindingResult result, RedirectAttributes redirectAttr ) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("divisionformpage");
			} else {
				rDivisionServices.createDivision(rdivision);
				model = new ModelAndView("redirect:/divisionlist");
				redirectAttr.addFlashAttribute("msgcreate","Succesfully create division. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/* divisionedit */
	@RequestMapping(value = "/divisionedit/{id}")
	public ModelAndView divisionEdit(@PathVariable String id) {
		Rdivision division = rDivisionServices.getDivisionById(id);
		return new ModelAndView("divisioneditpage", "rdivision", division);
	}

	/* divisionedit */
	@RequestMapping(value = "/submitdivisionedit", method = RequestMethod.POST)
	public ModelAndView divisionEditsave(@ModelAttribute("rdivision") Rdivision rdivision, 
			BindingResult result) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("divisioneditpage");
			} else {
				rDivisionServices.updateDivisionObj(rdivision);
				model = new ModelAndView("redirect:/divisionlist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model; 
	}
}
