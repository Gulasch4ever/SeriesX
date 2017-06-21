package at.fh.seriesX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.seriesX.dao.SeriesRepository;
import at.fh.seriesX.model.ActorModel;
import at.fh.seriesX.model.SeasonModel;
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
		
		
		
		/* *************************Actors************************* */
		
		ActorModel act1 = new ActorModel("Josh","Radnor"); 
		ActorModel act2 = new ActorModel("Jason","Segel");
		ActorModel act3 = new ActorModel("Cobie","Smulders");
		ActorModel act4 = new ActorModel("Neil Patrick","Harris");
		ActorModel act5 = new ActorModel("Alyson","Hannigan");
		ActorModel act6 = new ActorModel("Cristin","Milioti");
		
		ActorModel act7 = new ActorModel("Travis","Fimmel");
		ActorModel act8 = new ActorModel("Katheryn","Radnor");
		ActorModel act9 = new ActorModel("Josh","Winnick");
		ActorModel act10 = new ActorModel("Clive","Standen");
		
		ActorModel act11 = new ActorModel("Peter","Dinklage");
		ActorModel act12 = new ActorModel("Nikolaj","Coster-Waldau");
		ActorModel act13 = new ActorModel("Lena","Headey");
		ActorModel act14 = new ActorModel("Emilia","Clarke");
		ActorModel act15 = new ActorModel("Kit","Harington");
		
		ActorModel act16 = new ActorModel("Jennifer","Aniston");
		ActorModel act17 = new ActorModel("Courteney","Cox");
		ActorModel act18 = new ActorModel("Lisa","Kudrow");
		ActorModel act19 = new ActorModel("Matt","LeBlanc");
		ActorModel act20 = new ActorModel("Matthew","Perry");
		
		ActorModel act21 = new ActorModel("Grant","Gustin");
		ActorModel act22 = new ActorModel("Candice","Patton");
		ActorModel act23 = new ActorModel("Danielle","Panabaker");
		ActorModel act24 = new ActorModel("Rick","Cosnett");
		
		/* *************************Actors************************* */
				
		/* *************************Season************************* */
		SeasonModel hIMYMSeason1 = new SeasonModel(1,22,484);
		SeasonModel hIMYMSeason2 = new SeasonModel(2,22,484); 
		SeasonModel hIMYMSeason3 = new SeasonModel(3,20,440); 
		SeasonModel hIMYMSeason4 = new SeasonModel(4,24,528); 
		SeasonModel hIMYMSeason5 = new SeasonModel(5,24,528); 
		SeasonModel hIMYMSeason6 = new SeasonModel(6,24,528); 
		SeasonModel hIMYMSeason7 = new SeasonModel(7,24,528); 
		SeasonModel hIMYMSeason8 = new SeasonModel(8,24,528); 
		SeasonModel hIMYMSeason9 = new SeasonModel(9,24,528); 
		
		SeasonModel vikingsSeason1 = new SeasonModel(1,9,405); 
		SeasonModel vikingsSeason2 = new SeasonModel(2,10,450);
		SeasonModel vikingsSeason3 = new SeasonModel(3,10,450);
		SeasonModel vikingsSeason4 = new SeasonModel(4,20,900);
			
		SeasonModel goTSeason1 = new SeasonModel(1,10,500);
		SeasonModel goTSeason2 = new SeasonModel(2,10,500);
		SeasonModel goTSeason3 = new SeasonModel(3,10,500);
		SeasonModel goTSeason4 = new SeasonModel(4,10,500);
		SeasonModel goTSeason5 = new SeasonModel(5,10,500);
		SeasonModel goTSeason6 = new SeasonModel(6,10,500);
		SeasonModel goTSeason7 = new SeasonModel(7,7,350);
		
		SeasonModel friendsSeason1 = new SeasonModel(1,24,528);
		SeasonModel friendsSeason2 = new SeasonModel(2,24,528);
		SeasonModel friendsSeason3 = new SeasonModel(3,25,550);
		SeasonModel friendsSeason4 = new SeasonModel(4,24,528);
		SeasonModel friendsSeason5 = new SeasonModel(5,24,528);
		SeasonModel friendsSeason6 = new SeasonModel(6,25,550);
		SeasonModel friendsSeason7 = new SeasonModel(7,24,528);
		SeasonModel friendsSeason8 = new SeasonModel(8,24,528);
		SeasonModel friendsSeason9 = new SeasonModel(9,24,528);
		SeasonModel friendsSeason10 = new SeasonModel(10,18,396);
		
		SeasonModel flashSeason1 = new SeasonModel(1,23,966);
		SeasonModel flashSeason2 = new SeasonModel(2,23,966);
		SeasonModel flashSeason3 = new SeasonModel(3,23,966);
		
		/* *************************Season************************* */
		
		
		/* *************************Series************************* */
		
		String descriptionHIMYM = "How I Met Your Mother (often abbreviated to HIMYM) is an American sitcom that originally aired on CBS from September 19, 2005 to March 31, 2014. The series follows the main character, Ted Mosby, and his group of friends in Manhattan. As a framing device, Ted, in the year 2030, recounts to his son and daughter the events that led him to meeting their mother.";
		SeriesModel hIMYM = new SeriesModel("How I Met Your Mother","Sitcom","Carter Bays",descriptionHIMYM,"fun",0,9,0,2008);
		hIMYM.addSeason(hIMYMSeason1);
		hIMYM.addSeason(hIMYMSeason2);
		hIMYM.addSeason(hIMYMSeason3);
		hIMYM.addSeason(hIMYMSeason4);
		hIMYM.addSeason(hIMYMSeason5);
		hIMYM.addSeason(hIMYMSeason6);
		hIMYM.addSeason(hIMYMSeason7);
		hIMYM.addSeason(hIMYMSeason8);
		hIMYM.addSeason(hIMYMSeason9);
		hIMYM.addActor(act1);
		hIMYM.addActor(act2);
		hIMYM.addActor(act3);
		hIMYM.addActor(act4);
		hIMYM.addActor(act5);
		hIMYM.addActor(act6);
		seriesP.add(hIMYM);
		
		String descriptionVik = "Vikings is a historical drama television series written and created by Michael Hirst for the channel History. Filmed in Ireland, it premiered on March 3, 2013 in Canada.";
		SeriesModel vikings = new SeriesModel("Vikings","Action-adventure","Trevor Morris",descriptionVik,"brutal",1,4,0,2013);
		vikings.addSeason(vikingsSeason1);
		vikings.addSeason(vikingsSeason2);
		vikings.addSeason(vikingsSeason3);
		vikings.addSeason(vikingsSeason4);
		vikings.addActor(act7);
		vikings.addActor(act8);
		vikings.addActor(act9);
		vikings.addActor(act10);
		seriesP.add(vikings);
		
		String descriptionGoT = "Game of Thrones is an American fantasy drama television series created by David Benioff and D. B. Weiss. It is an adaptation of A Song of Ice and Fire, George R. R. Martin's series of fantasy novels, the first of which is A Game of Thrones.";
		SeriesModel goT = new SeriesModel("Game of Thrones","Fantasy","Ramin Djawadi",descriptionGoT,"brutal",0,6,0,2011);
		goT.addSeason(goTSeason1);
		goT.addSeason(goTSeason2);
		goT.addSeason(goTSeason3);
		goT.addSeason(goTSeason4);
		goT.addSeason(goTSeason5);
		goT.addSeason(goTSeason6);
		goT.addSeason(goTSeason7);
		goT.addActor(act11);
		goT.addActor(act12);
		goT.addActor(act13);
		goT.addActor(act14);
		goT.addActor(act15);
		seriesP.add(goT);
		
		String descriptionFriends = "Friends (stylized as F•R•I•E•N•D•S) is an American television sitcom, created by David Crane and Marta Kauffman, which aired on NBC from September 22, 1994, to May 6, 2004, lasting ten seasons.";
		SeriesModel friends = new SeriesModel("Friends","Sitcom","David Crane",descriptionFriends,"fun",0,10,0,1994);
		friends.addSeason(friendsSeason10);
		friends.addSeason(friendsSeason9);
		friends.addSeason(friendsSeason8);
		friends.addSeason(friendsSeason7);
		friends.addSeason(friendsSeason6);
		friends.addSeason(friendsSeason5);
		friends.addSeason(friendsSeason4);
		friends.addSeason(friendsSeason3);
		friends.addSeason(friendsSeason2);
		friends.addSeason(friendsSeason1);
		friends.addActor(act16);
		friends.addActor(act17);
		friends.addActor(act18);
		friends.addActor(act19);
		friends.addActor(act20);
		seriesP.add(friends);
		
		String descriptionFlash = "The Flash is an American television series developed by Greg Berlanti, Andrew Kreisberg and Geoff Johns, airing on The CW. It is based on the DC Comics character Barry Allen / Flash, a costumed superhero crime-fighter with the power to move at superhuman speeds.";
		SeriesModel flash = new SeriesModel("The Flash","Action","Blake Neely",descriptionFlash,"fast",0,3,0,2014);
		flash.addSeason(flashSeason1);
		flash.addSeason(flashSeason2);
		flash.addSeason(flashSeason3);
		flash.addActor(act21);
		flash.addActor(act22);
		flash.addActor(act23);
		flash.addActor(act24);
		seriesP.add(flash); 
		
		/* *************************Series************************* */
		

		// add all  series to repo 
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
	
	@RequestMapping("/deleteSeries")
	public String deleteData(Model model, @RequestParam int id) {
		seriesRepository.delete(id);

		return "forward:listSeries";
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
