package at.fh.seriesX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.seriesX.dao.SeriesRepository;
import at.fh.seriesX.model.SeriesModel;

@Controller 
public class SeriesController {

	@Autowired
	SeriesRepository seriesRepository;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		
		return "index";
	}
	
	
	
	@RequestMapping(value = { "listSeries" })
	public String showAllSeries(Model model) {
		
		
		List<SeriesModel> seriesP = new ArrayList<SeriesModel>();
		
		
		String descriptionHIMYM = "How I Met Your Mother (Englisch für „Wie ich eure Mutter kennenlernte“; kurz: HIMYM) ist eine US-amerikanische Sitcom, die für den Fernsehsender CBS produziert wurde. Die neun Staffeln umfassen 208 Folgen, die von 2005 bis 2014 erstausgestrahlt wurden. In Deutschland ist die Serie auf ProSieben, in Österreich auf ORF eins und in der Schweiz auf 3+ zu sehen. Die Erzählung erfolgt aus der Sicht der Hauptfigur Ted Mosby, der seinen Kindern die Erlebnisse schildert, die dazu geführt haben, dass er ihre Mutter kennengelernt hat. Die Serie erhielt zahlreiche Auszeichnungen, unter anderem neun Emmys.";
		seriesP.add(new SeriesModel("How I Met Your Mother","Josh Radnor;Jason Segel;Cobie Smulders;Neil Patrick Harris;Alyson Hannigan;Cristin Milioti","Sitcom","Carter Bays",descriptionHIMYM,"lustig",false,9,0,2008));
		
		
		seriesP.forEach((series)->seriesRepository.save(series));
			
		
		return "listSeries";
	}
	
	
	
	
	
	@RequestMapping(value = { "addSeries" })
	public String showAddSeriesForm(Model model) {
		
		return "editSeries";
	}
	
	@RequestMapping(value = { "editSeries" })
	public String showEditSeriesForm(Model model) {
		
		return "editSeries";
	}

	
}
