package at.fh.seriesX.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Favorite")
public class FavoriteModel implements java.io.Serializable {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="seriesId")
	private int seriesId;
	
	
	@Version
	long version;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UsersModel userModel;


	public FavoriteModel() {}
	
	public FavoriteModel(int id, int seriesId) {
		super();
		this.id = id;
		this.seriesId = seriesId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public UsersModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UsersModel userModel) {
		this.userModel = userModel;
	}
	
	
	
	
	
}
