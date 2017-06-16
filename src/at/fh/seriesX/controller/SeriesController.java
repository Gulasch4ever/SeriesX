package at.fh.seriesX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	

	
	@RequestMapping(value = { "/listSeries" })
	public String showAllSeries(Model model) {
			
		
		List<SeriesModel> seriesP = seriesRepository.findAll();
		model.addAttribute("seriesP", seriesP);
		
	
		return "listSeries";
	}
	
	
	@RequestMapping("/fillSeriesList")
	@Transactional
	public String fillData(Model model) {


		List<SeriesModel> seriesP = new ArrayList<SeriesModel>();
		
		
		String descriptionHIMYM = "How I Met Your Mother (often abbreviated to HIMYM) is an American sitcom that originally aired on CBS from September 19, 2005 to March 31, 2014. The series follows the main character, Ted Mosby, and his group of friends in Manhattan. As a framing device, Ted, in the year 2030, recounts to his son and daughter the events that led him to meeting their mother.";
		seriesP.add(new SeriesModel("How I Met Your Mother","Josh Radnor;Jason Segel;Cobie Smulders;Neil Patrick Harris;Alyson Hannigan;Cristin Milioti","Sitcom","Carter Bays",descriptionHIMYM,"fun",0,9,0,2008));
		
		String descriptionVik = "Vikings is a historical drama television series written and created by Michael Hirst for the channel History. Filmed in Ireland, it premiered on March 3, 2013 in Canada.";
		seriesP.add(new SeriesModel("Vikings","Travis Fimmel;Katheryn Winnick;Clive Standen","Action-adventure","Trevor Morris",descriptionVik,"brutal",1,4,0,2013));

		
		seriesP.forEach((series)->seriesRepository.save(series));

		//Error bevor man den Button drückt EL1007E: Property or field 'parameterName' cannot be found on null
		//Error nach drücken ->org.springframework.dao.InvalidDataAccessResourceUsageException:
		
		
		
		
		
		
		
		return "forward:listSeries";
	}
	
	
	
	
	
	@RequestMapping(value = { "addSeries" })
	public String showAddSeriesForm(Model model) {
		
		return "editSeries";
	}
	
	@RequestMapping(value = { "editSeries" })
	public String showEditSeriesForm(Model model) {
		
		return "editSeries";
	}
	
	
	@RequestMapping(value = { "login" })
	public String login(Model model) {
		
		return "login";
	}
	
	
	@RequestMapping(value = { "register" })
	public String register(Model model) {
		
		return "register";
	}
	
}
