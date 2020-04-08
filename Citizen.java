package beans;

public class Citizen {
	private int cid ;
	private String cname;
	private String email;
	private String password;
	private String dob;
	private Long adharno;
	private String address;
	private Long mobileno;
	
	public Citizen(){}
	
	public Citizen(int cid, String cname, String email, String password, String dob, Long adharno, String address,Long mobileno) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.adharno = adharno;
		this.address = address;
		this.mobileno = mobileno;
	}
	

		public Citizen(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	

		public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Long getAdharno() {
		return adharno;
	}

	public void setAdharno(Long adharno) {
		this.adharno = adharno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	
	

}
