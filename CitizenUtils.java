package utils;
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


public class CitizenUtils {
	

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	/**
	 * @param citizen
	 * @return
	 */
	
	public Citizen LoginCitizen(String email,String password){
		Citizen c = null;
		conn = DBUtils.getConnection("onlinecrimemanagement");
		String sql = "select * from citizen WHERE email=? AND password=?";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs != null){
				while(rs.next()){
					c = new Citizen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getLong(8));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return c;
	}
	public boolean addCitizen(Citizen citizen){
		boolean inserted = false;
			conn = DBUtils.getConnection("onlinecrimemanagement");
			//System.out.println(citizen.getCname(),citizen.getAddress(),citizen.getAdharno());
			String sql = "insert into citizen(cname,email,password,dob,adharno,address,mobileno) values(?,?,?,?,?,?,?)";
			pst = DBUtils.getPreparedStatement(sql);
			
			
			try{
			pst.setString(1, citizen.getCname());
			pst.setString(2, citizen.getEmail());
			pst.setString(3, citizen.getPassword());
			pst.setString(4, citizen.getDob());
			pst.setLong(5, citizen.getAdharno());
			pst.setString(6, citizen.getAddress());
			pst.setLong(7, citizen.getMobileno());
			
			int r = pst.executeUpdate();
			
			if(r > 0){
				inserted = true;
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
			
		return inserted;
	}
	
	public boolean Complaint(Complaint complaint){
		boolean inserted = false;
		
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "insert into complaint(descr,codate,cid,status) values (?,now(),?,'pending')";
			
			pst = DBUtils.getPreparedStatement(sql);
			try{
			pst.setString(1, complaint.getDescr());
			//pst.setString(2, complaint.getCodate());
			pst.setInt(2, complaint.getCitizen().getCid());
			
						int r = pst.executeUpdate();
			
			if(r > 0){
				inserted = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return inserted;
	}
	
	public Complaint viewStatus(int coid)
	{
		Complaint ct=null;
	
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "select status from Complaint where coid="+coid;
			
			stmt = DBUtils.getSimpleStatement();
			
			try{
				rs = stmt.executeQuery(sql);
				
				if(rs != null){
					while(rs.next()){
						ct = new Complaint(rs.getString(1));
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			DBUtils.closeResources();
			return ct;
}
		
	/*public List<Complaint> getAllComplaint(){
		List<Complaint> complaint = new ArrayList<Complaint>();
		
		conn = DBUtils.getConnection("onlinecrime");
		
		String sql = "select * from complaint WHERE cid=?";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			Complaint cr = null;
			
			if(rs != null){
				while(rs.next()){
					cr = new Complaint(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),null);
					Citizen c = new Citizen();
					c.setCid(rs.getInt(5));
					cr.setCitizen(c);
					complaint.add(cr);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return complaint;
	}*/
	public List<Criminal> getAllCriminals(){
			List<Criminal> criminalList = new ArrayList<Criminal>();
			
			conn = DBUtils.getConnection("onlinecrimemanagement");
			
			String sql = "select * from Criminal";
			
			stmt = DBUtils.getSimpleStatement();
			
			try{
				rs = stmt.executeQuery(sql);
				
				Criminal cr = null;
				
				if(rs != null){
					while(rs.next()){
						cr = new Criminal(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), null);
						criminalList.add(cr);
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			DBUtils.closeResources();
			
			return criminalList;
		}
		
	
	
		
}