package beans;
import java.io.File;

public class Criminal {
	private int crid ;
	private String crname;
	private String crime;
	private String description;
	private String identification;
	private File photo;
	
	public Criminal(){
		}
	
	public Criminal(int crid, String crname, String crime, String description, String identification, File photo) {
		super();
		this.crid = crid;
		this.crname = crname;
		this.crime = crime;
		this.description = description;
		this.identification = identification;
		this.photo = photo;
	}
	
		public Criminal(int crid, String crname, String crime, String description, String identification) {
		super();
		this.crid = crid;
		this.crname = crname;
		this.crime = crime;
		this.description = description;
		this.identification = identification;
	}

		
	public int getCrid() {
			return crid;
		}

		public void setCrid(int crid) {
			this.crid = crid;
		}

	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	

}
