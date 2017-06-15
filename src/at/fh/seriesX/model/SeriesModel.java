package at.fh.seriesX.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Series")

public class SeriesModel implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String title;
	 
	@Column(nullable = false, length = 30)
	private String actors;
	
	@Column(nullable = false, length = 30)
	private String genre;
	
	@Column(nullable = false, length = 30)
	private String author;
	
	@Column(nullable = false, length = 30)
	private String description;
	
	//type defines what kind of series it is (e.g. Vikings is 'brutal')
	@Column(nullable = false, length = 30)
	private String type;
	// true when 18 or older 
	@Column(nullable = false, length = 30)
	private boolean nsfw;
	
	@Column(nullable = false, length = 30)
	private int season;
	
	@Column(nullable = false, length = 30)
	private int rating;
	 
	// Date Only, no time part:
	@Temporal(TemporalType.DATE)
	private Calendar yearOfRelease;
	
	
	@OneToMany (mappedBy="series", fetch=FetchType.EAGER)
	@OrderBy("seasonNumber,episodeNumer")
	private Set<EpisodeModel> episodesSets;
	
	@ManyToMany(cascade=CascadeType.PERSIST)  
	@OrderBy("firstName,lastName")
	private Set<UsersModel> usersSet;
	
	
	
	@Version
	long version;
	
	public SeriesModel() {
	}


	public SeriesModel(String title, String actors, String genre, String author, String description, String type,
			boolean nsfw, int rating, Calendar yearOfRelease) {
		super();
		this.title = title;
		this.actors = actors;
		this.genre = genre;
		this.author = author;
		this.description = description;
		this.type = type;
		this.nsfw = nsfw;
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


	public boolean isNsfw() {
		return nsfw;
	}


	public void setNsfw(boolean nsfw) {
		this.nsfw = nsfw;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Calendar getYearOfRelease() {
		return yearOfRelease;
	}


	public void setYearOfRelease(Calendar yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	
	
	public Set<EpisodeModel> getEpisode() {
		return episodesSets;
	}

	public void setEmployees(Set<EpisodeModel> employees) {
		this.episodesSets = employees;
	}
	
	public void addEmployee(EpisodeModel employee) {
		if (episodesSets==null) {
			episodesSets= new HashSet<EpisodeModel>();
		}
		episodesSets.add(employee);
	}
	
	public Set<UsersModel> getGulyas() {
		return usersSet;
	}
 
	public void setGulyas(Set<UsersModel> gulyasP) {
		this.usersSet = gulyasP;
	}
	
	
	
}
