package beans;

public class Police {
	private int pid ;
	private String pname;
	private int stationcode;
	private String password;
	private String email;
	
	public Police(String pname, int stationcode, String password, String email) {
		super();
		this.pname = pname;
		this.stationcode = stationcode;
		this.password = password;
		this.email = email;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getStationcode() {
		return stationcode;
	}
	public void setStationcode(int stationcode) {
		this.stationcode = stationcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
