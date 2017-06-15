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
	 
	@Column(columnDefinition = "TEXT")
	private String actors;
	
	@Column(nullable = false, length = 30)
	private String genre;
	
	@Column(nullable = false, length = 30)
	private String author;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	//type defines what kind of series it is (e.g. Vikings is 'brutal')
	@Column(nullable = false, length = 30)
	private String type;
	// true when 18 or older 
	@Column(nullable = false, length = 30)
	private boolean nsfw;
	
	@Column(nullable = false, length = 30)
	private int seasonNr;
	
	@Column(nullable = false, length = 30)
	private int rating;
	 

	@Column(nullable = false, length = 30)
	private int yearOfRelease;
	
	
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
			boolean nsfw, int seasonNr, int rating, int yearOfRelease) {
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

	public boolean isNsfw() {
		return nsfw;
	}

	public void setNsfw(boolean nsfw) {
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

	public Set<EpisodeModel> getEpisodesSets() {
		return episodesSets;
	}

	public void setEpisodesSets(Set<EpisodeModel> episodesSets) {
		this.episodesSets = episodesSets;
	}

	public Set<UsersModel> getUsersSet() {
		return usersSet;
	}

	public void setUsersSet(Set<UsersModel> usersSet) {
		this.usersSet = usersSet;
	}

	
	
	
	
}
