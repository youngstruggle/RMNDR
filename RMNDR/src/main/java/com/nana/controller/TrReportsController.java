package com.nana.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nana.entities.Email;
import com.nana.entities.TrReports;
import com.nana.services.TrReportServicesImpl;

import util.MailUtil;

import java.text.ParseException;

/**
 * @author Nana Febriana
 */

@Controller
public class TrReportsController {

	@Autowired
	TrReportServicesImpl trReportsServices;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	/* Get TrReport */
	@RequestMapping("/reportlist")
	public ModelAndView userListView() {
		ModelAndView model = new ModelAndView("reportlistpage");
		try {
			List<TrReports> reportList = trReportsServices.getReportList();
			if (reportList != null && reportList.size() > 0) {
				model.addObject("reportlist", reportList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/* Create TrReport */
	@RequestMapping(value = "/createreportform", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("reportformpage", "reports", new TrReports());
	}

	/* Create TrReport */
	@RequestMapping(value = "/submitreportform.html", method = RequestMethod.POST)
	public ModelAndView createUserForm(
			@ModelAttribute("reports") TrReports trReports,
			BindingResult result, RedirectAttributes redirectAttr) {
		ModelAndView model = null;
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("reportformpage");
				model.addObject("msg", "Input wrong. ");
			} else {
				trReportsServices.insertTrReport(trReports);
				model = new ModelAndView("redirect:/reportlist");
				redirectAttr.addFlashAttribute("msgcreate",
						"Succesfully create Invoice. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/* Edit TrReport */
	@RequestMapping(value = "/reportsedit/{id}")
	public ModelAndView edit(@PathVariable int id) throws ParseException {
		TrReports reports = trReportsServices.getReportsById(id);
		return new ModelAndView("reporteditpage", "reports", reports);
	}

	/* Edit TrReport */
	@RequestMapping(value = "/submitreportsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("reports") TrReports trReports) {
		trReportsServices.updateReportsObj(trReports);
		return new ModelAndView("redirect:/reportlist");
	}

	/* Delete TrReport */
	@RequestMapping(value = "/reportsdelete/{id}", method = RequestMethod.GET)
	public String deleteReports(@PathVariable("id") int id,
			RedirectAttributes attributes) {
		trReportsServices.deleteReports(id);
		attributes.addFlashAttribute("msgdelete",
				"Invoice has been removed successfully.");
		return "redirect:/reportlist";
	}

	/* Reminder Invoice By List */
	@RequestMapping(value = "/reminderreports/{id}", method = RequestMethod.GET)
	public String reminderReports(@PathVariable("id") int id,
			RedirectAttributes attributes) {
		TrReports trReports = trReportsServices.getReportsById(id);
		if (trReports != null) {
			System.out.println(trReports.getReportId());
			System.out.println("Tanggal Jatuh Tempo "
					+ trReports.getTanggalJthTempo());

			MailUtil mail = new MailUtil();
			/*
			 * To Do: Ubah emailfrom and receipent dari settingan
			 */
			String emailFrom = "xxxx@inspirotechs.com";
			String emailRecipent = "xxxx@gmail.com";
			String subject = "Reminder Invoice";
			String content = "Dear PT. Inspiro,"
					+ "\n\n invoice sudah jatuh tempo, harap melunasi pembayaran !"
					+ "\n\n " + "\n\n " + "\n\n " + "\n\n " + "\n\n "
					+ "\n\n Regards, " + "\n\n " + "\n\n " + "\n\n Hrd.";

			String feedback = mail.sendMailForReminderAuth(emailFrom,
					emailRecipent, subject, content);
			attributes.addFlashAttribute("msgcreate",
					"Sent email successfully.");
			System.out.println("feedback " + feedback);
		}
		return "redirect:/reportlist";
	}

	/* Sending Email */
	@RequestMapping(value = "/sendingemail", method = RequestMethod.GET)
	public ModelAndView sendingEmail() {
		return new ModelAndView("reminderformpage", "email", new Email());
	}

	/* Sending Email Form Submit */
	@RequestMapping(value = "/submitemailform.html", method = RequestMethod.POST)
	public ModelAndView sendingEmailForm(@ModelAttribute("email") Email email,
			BindingResult result) {
		ModelAndView model = new ModelAndView("reminderformpage");
		try {
			if (result.hasErrors()) {
				model = new ModelAndView("reminderformpage");
				model.addObject("msg", "Input wrong. ");
			} else {
				emailOut(email);

				MailUtil mail = new MailUtil();
				String emailFrom = email.getSender();
				String emailRecipent = email.getRecipients();
				String subject = email.getSubject();
				String content = email.getHeading() + "," + "\n\n "
						+ email.getContent() + "\n\n " + "\n\n " + "\n\n "
						+ "\n\n " + "\n\n " + "\n\n Regards, " + "\n\n "
						+ "\n\n " + "\n\n" + email.getFooter();

				String msg = mail.sendMailForReminderAuth(emailFrom,
						emailRecipent, subject, content);
				System.out.println("feedback " + msg);
				model.addObject("msg", "Successfully Sending Email. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/reminderreports", method = RequestMethod.GET)
	public String scheduler() {
		List<TrReports> invoice = new ArrayList<TrReports>();
		invoice = trReportsServices.getReportList();

		System.out.println("invoice size " + invoice.size());
		if (invoice != null && invoice.size() > 0) {
			for (TrReports i : invoice) {
				System.out.println("Tanggal Jatuh Tempo: " + i.getTanggalJthTempo().toString());	
			}
		}
		return "redirect:/reportlist";
	}

	public void emailOut(Email email) {
		System.out.println("sender ==> " + email.getSender());
		System.out.println("recipients ==> " + email.getRecipients());
		System.out.println("subject ==> " + email.getSubject());
		System.out.println("heading ==> " + email.getHeading());
		System.out.println("content ==> " + email.getContent());
		System.out.println("content ==> " + email.getFooter());
		System.out.println();
	}

}
