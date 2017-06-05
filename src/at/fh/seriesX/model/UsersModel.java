package at.fh.seriesX.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Users")
public class UsersModel implements java.io.Serializable {

	@ManyToMany(cascade=CascadeType.PERSIST)  
    @OrderBy("title, genre")
    private Set<SeriesModel> seriesSet;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false, length = 30)
	private String firstName;
	
	

	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Calendar dayOfBirth;
	
	@Column(nullable = false, length = 30)
	private String accType;
	
	@Column(nullable = false, length = 30)
	private String iGenre;
	
	@Column(nullable = false, length = 30)
	private String iActor;
	
	@Column(nullable = false, length = 30)
	private String iYear;
	
	//Spannend, Düster, Aufregend 
	@Column(nullable = false, length = 30)
	private String iType;
	
	@Version
	long version;
	
	public UsersModel(String firstName, String lastName, Calendar dayOfBirth, String accType, String iGenre,
			String iActor, String iYear, String iType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.accType = accType;
		this.iGenre = iGenre;
		this.iActor = iActor;
		this.iYear = iYear;
		this.iType = iType;
	}

	public Set<SeriesModel> getSeriesSet() {
		return seriesSet;
	}

	public void setSeriesSet(Set<SeriesModel> seriesSet) {
		this.seriesSet = seriesSet;
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

	public Calendar getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Calendar dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getiGenre() {
		return iGenre;
	}

	public void setiGenre(String iGenre) {
		this.iGenre = iGenre;
	}

	public String getiActor() {
		return iActor;
	}

	public void setiActor(String iActor) {
		this.iActor = iActor;
	}

	public String getiYear() {
		return iYear;
	}

	public void setiYear(String iYear) {
		this.iYear = iYear;
	}

	public String getiType() {
		return iType;
	}

	public void setiType(String iType) {
		this.iType = iType;
	}
	
	
	
	
	
}
