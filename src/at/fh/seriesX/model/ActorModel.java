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



@Entity
@Table(name = "Actor")

public class ActorModel implements java.io.Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String firstName;

	@Column(nullable = false, length = 30)
	private String lastName;

	@Version
	long version;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)  
	private List<SeriesModel> seriesP;


	public ActorModel() {
		
	}
	
	public ActorModel(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<SeriesModel> getSeriesP() {
		return seriesP;
	}


	public void setSeriesP(List<SeriesModel> seriesP) {
		this.seriesP = seriesP;
	}

	public void addSeries(SeriesModel series) {
		if (seriesP== null) {
			seriesP= new ArrayList<SeriesModel>();
		}
		seriesP.add(series);
	}
	
}
