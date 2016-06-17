package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.MyConnectDB;

public class CheckVX {
	/**
	 * Check tên vắc xin khi thêm mới
	 * @param name
	 * @return
	 */
	public boolean checkAddName(String name){
		boolean checkx = true;
		int check = 0;
		Connection conn = new MyConnectDB().getConnectMySQL();
		try {
			PreparedStatement pst = conn.prepareStatement(new String("SELECT COUNT(*) AS TEST FROM vacxin WHERE TenVacxin = ?"));
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				check = rs.getInt("TEST");
			}
		} catch (SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		if(check > 0){
			checkx = false;
		}
		return checkx;
	}
	/**
	 * Check tên vắc xin khi update
	 */
	public boolean checkUpdateName(String name,String maVacxin){
		boolean checkx = false;
		int check = 0;
		Connection conn = new MyConnectDB().getConnectMySQL();
		try {
			PreparedStatement pst = conn.prepareStatement(new String("SELECT COUNT(*) AS TEST FROM vacxin WHERE TenVacxin = ? AND MaVacxin NOT IN(?)"));
			pst.setString(1, name);
			pst.setString(2,maVacxin);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				check = rs.getInt("TEST");
			}
		} catch (SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		if(check > 0){
			checkx = true;
		}
		return checkx;
	}
}
