package beans;

public class Complaint {
	private int coid ;
	private String descr;
	private String codate;
	private String status;
	private Citizen citizen;
		
	
	public Complaint(int coid,String descr, String codate, String status, Citizen citizen) {
		super();
		this.descr = descr;
		this.codate = codate;
		this.status = status;
		this.citizen = citizen;
	}
	public Complaint(String descr, String codate, String status) {
		super();
		this.descr = descr;
		this.codate = codate;
		this.status = status;
		}

	public Complaint(String status) {
		super();
		this.status=status;
	}
	
	
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCodate() {
		return codate;
	}

	public void setCodate(String codate) {
		this.codate = codate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	
	
}
