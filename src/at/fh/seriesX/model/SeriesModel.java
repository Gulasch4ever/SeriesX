package at.fh.seriesX.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

//import at.fh.swenga.jpa.model.NamedQueries;
//import at.fh.swenga.jpa.model.NamedQuery;

@Entity
@Table(name = "Series")

@NamedQueries({
	@NamedQuery(name = "SeriesModel.doANameSearchWithLike", query = "select s from SeriesModel s where s.title like :search or s.genre like :search")
})

public class SeriesModel implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String title;
	 
	@Column(nullable = false, length=512)
	private String actors;
	
	@Column(nullable = false, length=30)
	private String genre;
	
	@Column(nullable = false, length = 30)
	private String author;
	
	@Column(nullable = false, length=1024)
	private String description;
	
	//type defines what kind of series it is (e.g. Vikings is 'brutal')
	@Column(nullable = false, length = 30)
	private String type;
	// true when 18 or older 
	@Column(name = "nsfw")
	private int nsfw;
	
	@Column(name = "seasonNr")
	private int seasonNr;
	
	@Column(name = "rating")
	private int rating;
	 

	@Column(name = "yearOfRelease")
	private int yearOfRelease;
	
	
	@OneToMany (mappedBy="series", fetch=FetchType.LAZY)
	@OrderBy("seasonNumber")
	private Set<SeasonModel> seasonP;
	
	@ManyToMany(cascade=CascadeType.PERSIST)  
	private List<UsersModel> users;
	
	@ManyToMany(cascade=CascadeType.PERSIST)  
	private List<ActorModel> actorP;
	
	@Version
	long version;
	
	
	
	
	public SeriesModel() {
	}
	
	public SeriesModel(String title, String actors, String genre, String author, String description, String type,
			int nsfw, int seasonNr, int rating, int yearOfRelease) {
		super();
		this.title = title;
		this.actors = actors;
		this.genre = genre;
		this.author = author;
		this.description = description;
		this.type = type;
		this.nsfw = nsfw;
		this.seasonNr = seasonNr;
		this.rating = rating;
		this.yearOfRelease = yearOfRelease;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int getNsfw() {
		return nsfw;
	}

	public void setNsfw(int nsfw) {
		this.nsfw = nsfw;
	}

	public int getSeasonNr() {
		return seasonNr;
	}

	public void setSeasonNr(int seasonNr) {
		this.seasonNr = seasonNr;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public Set<SeasonModel> getseasonP() {
		return seasonP;
	}

	public void setseasonP(Set<SeasonModel> seasonP) {
		this.seasonP = seasonP;
	}

	public void addSeason(SeasonModel season) {
		if (seasonP==null) {
			seasonP= new HashSet<SeasonModel>();
		}
		seasonP.add(season);
	}
	
	public List<UsersModel> getusers() {
		return users;
	}

	public void setusers(List<UsersModel> users) {
		this.users = users;
	}

	public void addUser(UsersModel user) {
		if (users== null) {
			users= new ArrayList<UsersModel>();
		}
		users.add(user);
	}

	public List<ActorModel> getActorP() {
		return actorP;
	}

	public void setActorP(List<ActorModel> actorP) {
		this.actorP = actorP;
	}


	public void addActor(ActorModel actor) {
		if (actorP== null) {
			actorP= new ArrayList<ActorModel>();
		}
		actorP.add(actor);
	}

	
	
}
