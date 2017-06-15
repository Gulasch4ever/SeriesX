package at.fh.seriesX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.seriesX.model.SeriesModel;

@Controller 
public class SeriesController {

	
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
		
		return "index";
	}
	// more to come!
	
	@RequestMapping("/fillSeriesList")
	public String fillSeriesList() {
		
		String dec1 = "dfsiuhsadhufoasdhfdsahofidshafdsih";
 
		//SeriesModel seriesModel = new SeriesModel("How I Met Your Mother","dec1")
		
		
		return "forward:/listSeries";
	}
	
	@RequestMapping(value = { "listSeries" })
	public String showAllSeries(Model model) {
		
		return "listSeries";
	}
	
}
