package com.nana.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nana.entities.TrReports;
import com.nana.services.TrReportServicesImpl;

@Controller
public class SchedulerController {
	
	@Autowired
	TrReportServicesImpl trReportsServices;
	
	/* Get TrReport */
	@RequestMapping("/scheduler")
	public ModelAndView userListView() {
		ModelAndView model = new ModelAndView("schedulerpage");
		return model;
	}
	
	@RequestMapping(value = "/triggerscheduler", method = RequestMethod.GET)
	public String scheduler() {
		Timer timer = new Timer ();
		TimerTask t = new TimerTask () {
		    @Override
		    public void run () {
		    	System.out.println("Running scheduler");
				List<TrReports> invoice = new ArrayList<TrReports>();
				invoice = trReportsServices.getReportList();
				if (invoice != null && invoice.size() > 0) {
					for (TrReports i : invoice) {	
						DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
						DateFormat output = new SimpleDateFormat("MM-dd-yyyy");
						String jthTempo = outputFormat.format(i.getTanggalJthTempo());
						
						Date date = new Date();
					    System.out.println("Today " + output.format(date));
					    String today = output.format(date);
					    
					    if (jthTempo.equalsIgnoreCase(today)){
					    	System.out.println("Kondisi Terpenuhi");
					    }
					}
				}
		    }
		};

		timer.schedule(t, 0, 5000); /* Every seconds */
//		timer.schedule (t, 0l, 1000*60*60*24); /* Every 24 Hour */
		
		return "redirect:/scheduler";
	}
	
	/* 1. Ada Button untuk mengaktifkan scheduler. 
	 * 2. Setelah scheduler aktif dia akan trigger cek invoice date.
	 * 3. Jika date nya ada yang sesuai dengan list pada invoice maka akan mengirimkan email.
	 *    dan update status untuk data invoice tersebut tambahkan flag. */
	
}
