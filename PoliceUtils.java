package utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Citizen;
import beans.Complaint;
import beans.Criminal;
import beans.LoginData;
import beans.Police;

public class PoliceUtils {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public LoginData AdminLogin(String email,String password){
		LoginData c = null;
		conn = DBUtils.getConnection("onlinecrimemanagement");
		String sql = "select * from adminlogin WHERE email=? AND password=?";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs != null){
				while(rs.next()){
					c = new LoginData(rs.getString(1),rs.getString(2));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return c;
	}
	
	public Complaint PendingComplaint(){
		Complaint ct=null;
		
		conn = DBUtils.getConnection("onlinecrimemanagement");
		
		String sql = "select c.coid, c.descr, c.codate, c.status,c.cid, ct.name, ct.email,ct.dob,ct.adharno, ct.address, ct.mobileno from complaint c , citizen ct WHERE c.cid=ct.cid AND status='Pending' ";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
				ct = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
				Citizen c = new Citizen();
				c.setCid(rs.getInt(5));
				c.setCname(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setDob(rs.getString(8));
				c.setAdharno(rs.getLong(9));
				c.setMobileno(rs.getLong(10));
				ct.setCitizen(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return ct;
	}
	
	public Complaint NewComplaint(){
		Complaint ct=null;
		
		conn = DBUtils.getConnection("onlinecrimemanagement");
		
		String sql = "select c.coid, c.descr, c.codate, c.status,c.cid, ct.name, ct.email,ct.dob,ct.adharno, ct.address, ct.mobileno from complaint c , citizen ct WHERE c.cid=ct.cid AND status='null' ";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
				ct = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
				Citizen c = new Citizen();
				c.setCid(rs.getInt(5));
				c.setCname(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setDob(rs.getString(8));
				c.setAdharno(rs.getLong(9));
				c.setMobileno(rs.getLong(10));
				ct.setCitizen(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return ct;
	}
	
	public Complaint RunningComplaint(){
		Complaint ct=null;
		
		conn = DBUtils.getConnection("onlinecrimemanagement");
		
		String sql = "select c.coid, c.descr, c.codate, c.status,c.cid, ct.name, ct.email,ct.dob,ct.adharno, ct.address, ct.mobileno from complaint c , citizen ct WHERE c.cid=ct.cid AND status='Running' ";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
				ct = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
				Citizen c = new Citizen();
				c.setCid(rs.getInt(5));
				c.setCname(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setDob(rs.getString(8));
				c.setAdharno(rs.getLong(9));
				c.setMobileno(rs.getLong(10));
				ct.setCitizen(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return ct;
	}
	
	public List<Complaint> getAllComplains(){
		List<Complaint> clist = new ArrayList<Complaint>();
		conn = DBUtils.getConnection("onlinecrimemanagement");
		String sql = "select * from Complaint";
		stmt = DBUtils.getSimpleStatement();
		Complaint ct = null;
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					ct = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
					Citizen c = new Citizen();
					c.setCid(rs.getInt(5));
					clist.add(ct);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		
		return clist;
	}
	public Complaint ViewComplaint(){
		Complaint ct=null;
		
		conn = DBUtils.getConnection("onlinecrimemanagement");
		
		String sql = "select c.coid, c.descr, c.codate, c.status,c.cid, ct.name, ct.email,ct.dob,ct.adharno, ct.address, ct.mobileno from complaint c , citizen ct WHERE c.cid=ct.cid ";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
				ct = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), null);
				Citizen c = new Citizen();
				c.setCid(rs.getInt(5));
				c.setCname(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setDob(rs.getString(8));
				c.setAdharno(rs.getLong(9));
				c.setMobileno(rs.getLong(10));
				ct.setCitizen(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return ct;
	}
	
	public boolean updateStatus(Complaint complaint){
		boolean inserted = false;
		try{
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "update complaint SET status=? where coid=?";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(1, complaint.getStatus());
			pst.setInt(2, complaint.getCoid());
									
			int r = pst.executeUpdate();
			
			if(r > 0){
				inserted = true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
			return inserted;
	}
	
	
	public boolean addCriminal(Criminal criminal){
		boolean inserted = false;
		try{
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "insert into Criminal(crname,crime,description,identification) values (?,?,?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(1, criminal.getCrname());
			pst.setString(2, criminal.getCrime());
			pst.setString(3, criminal.getDescription());
			pst.setString(4, criminal.getIdentification());
			//pst.setFile(5, criminal.getPhoto());
						
			int r = pst.executeUpdate();
			
			if(r > 0){
				inserted = true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
			return inserted;
	}
	
	public boolean   UpdateCriminal(Criminal criminal){
		boolean inserted = false;
		try{
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "update Criminal SET crime=? ,description=? WHERE crid=? ";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(2, criminal.getCrime());
			pst.setString(3, criminal.getDescription());
								
			int r = pst.executeUpdate();
			
			if(r > 0){
				inserted = true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
			return inserted;
	}

}
