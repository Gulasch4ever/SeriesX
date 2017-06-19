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

public class SeasonModel implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "seasonNumber")
	private int seasonNumber;
	
	@Column(name = "episodeSum")
	private int episodeSum;
	

	//duration = how long a season lasts in minutes
	@Column(name = "duration")
	private int duration;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	private SeriesModel series;
	
	@Version
	long version;
	
	
	public SeasonModel() {
		
	}
	

	public SeasonModel(int seasonNumber, int episodeSum, int duration) {
		super();
		this.seasonNumber = seasonNumber;
		this.episodeSum = episodeSum;
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

	public int getEpisodeSum() {
		return episodeSum;
	}

	public void setEpisodeSum(int episodeSum) {
		this.episodeSum = episodeSum;
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