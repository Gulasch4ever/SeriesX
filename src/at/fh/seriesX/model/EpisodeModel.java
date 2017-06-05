package at.fh.seriesX.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Episodes")

public class EpisodeModel implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private int seasonNumber;
	
	@Column(nullable = false, length = 30)
	private int episodeNumber;
	
	@Column(nullable = false, length = 30)
	private String episodeTitle;
	
	//duration = how long a episode lasts in minutes
	@Column(nullable = false, length = 30)
	private int duration;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private SeriesModel series;
	
	@Version
	long version;
	
	public EpisodeModel() {
	}

	public EpisodeModel(int seasonNumber, int episodeNumber, String episodeTitle, int duration) {
		super();
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.episodeTitle = episodeTitle;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public String getEpisodeTitle() {
		return episodeTitle;
	}

	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public SeriesModel getSeries() {
		return series;
	}

	public void setSeries(SeriesModel series) {
		this.series = series;
	}
	
	
}
