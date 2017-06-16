package at.fh.seriesX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@RequestMapping(value = {"/find"})
	public String find(Model model, @RequestParam String searchString, @RequestParam String searchType){
		List<SeriesModel> seriesP = null;
		int count=0;
		
		switch (searchType) {
		case "query1":
			seriesP = seriesRepository.findAll();
			break;
		case "query2":
			seriesP = seriesRepository.findByTitle(searchString);
			break;
		case "query3":
			seriesP = seriesRepository.findByGenre(searchString);
			break;
		case "query4":
			seriesP = seriesRepository.doANameSearchWithLike("%"+searchString+"%");
			break;
		case "query5":
			seriesP = seriesRepository.deleteByGenre(searchString);
			break;
		case "query6":
			seriesP=seriesRepository.findByTitleContainingAllIgnoreCase(searchString);		
			break;
		case "query7":
			seriesP=seriesRepository.findAllOrderByTitle(searchString);		
			break;
		case "query8":
			seriesP=seriesRepository.findTop10ByOrderByGenreAsc(searchString);		
			break;
			
		default:
			seriesP = seriesRepository.findAll();
		
		}
		return "index";
	}
	
	
	@RequestMapping("/fillSeriesList")
	@Transactional
	public String fillData(Model model) {


		List<SeriesModel> seriesP = new ArrayList<SeriesModel>();
		
		/* *************************SERIES DATA************************* */
		
		String descriptionHIMYM = "How I Met Your Mother (often abbreviated to HIMYM) is an American sitcom that originally aired on CBS from September 19, 2005 to March 31, 2014. The series follows the main character, Ted Mosby, and his group of friends in Manhattan. As a framing device, Ted, in the year 2030, recounts to his son and daughter the events that led him to meeting their mother.";
		seriesP.add(new SeriesModel("How I Met Your Mother","Josh Radnor;Jason Segel;Cobie Smulders;Neil Patrick Harris;Alyson Hannigan;Cristin Milioti","Sitcom","Carter Bays",descriptionHIMYM,"fun",0,9,0,2008));
		
		String descriptionVik = "Vikings is a historical drama television series written and created by Michael Hirst for the channel History. Filmed in Ireland, it premiered on March 3, 2013 in Canada.";
		seriesP.add(new SeriesModel("Vikings","Travis Fimmel;Katheryn Winnick;Clive Standen","Action-adventure","Trevor Morris",descriptionVik,"brutal",1,4,0,2013));

		String descriptionGoT = "Game of Thrones is an American fantasy drama television series created by David Benioff and D. B. Weiss. It is an adaptation of A Song of Ice and Fire, George R. R. Martin's series of fantasy novels, the first of which is A Game of Thrones.";
		seriesP.add(new SeriesModel("Game of Thrones","Peter Dinklage;Nikolaj Coster-Waldau;Lena Headey;Emilia Clarke;Kit Harington","Fantasy","Ramin Djawadi",descriptionGoT,"brutal",0,6,0,2011));

		String descriptionFriends = "Friends (stylized as F•R•I•E•N•D•S) is an American television sitcom, created by David Crane and Marta Kauffman, which aired on NBC from September 22, 1994, to May 6, 2004, lasting ten seasons.";
		seriesP.add(new SeriesModel("Friends","Jennifer Aniston;Courteney Cox;Lisa Kudrow;Matt LeBlanc;Matthew Perry","Sitcom","David Crane",descriptionFriends,"fun",0,10,0,1994));

		String descriptionFlash = "The Flash is an American television series developed by Greg Berlanti, Andrew Kreisberg and Geoff Johns, airing on The CW. It is based on the DC Comics character Barry Allen / Flash, a costumed superhero crime-fighter with the power to move at superhuman speeds.";
		seriesP.add(new SeriesModel("The Flash","Grant Gustin;Candice Patton;Danielle Panabaker;Rick Cosnett","Action","Blake Neely",descriptionFlash,"fast",0,3,0,2014));

		
		
		
		seriesP.forEach((series)->seriesRepository.save(series));
		
		/* *************************SERIES DATA************************* */
		
		
		
		
		
		
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
