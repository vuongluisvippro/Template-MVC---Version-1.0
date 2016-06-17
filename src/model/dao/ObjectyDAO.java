package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.KhachHang;
import model.bean.Objecty;
import model.bean.Objectz;

@SuppressWarnings("all")
public class ObjectyDAO {

	private MyConnectDB mConnect;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	
	public ObjectyDAO() {
		mConnect = new MyConnectDB();
	}
	
	public ArrayList<Objecty> getList() {	
		conn = mConnect.getConnectMySQL();
		ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		/**
		 * Xử lý 1:
		 */
		String sql1 = "SELECT DISTINCT khachhang.HoTenKH,khachhang.MaKH FROM lichsutiemphong"
				      +" INNER JOIN khachhang"
				      +" ON lichsutiemphong.MaKH = khachhang.MaKH";
		try {
			pst = conn.prepareStatement(sql1);
			rs = pst.executeQuery();
			while(rs.next()){
				listKH.add(new KhachHang(rs.getString("HoTenKH"),rs.getString("MaKH")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		/**
		 * Xử lý 2:
		 */
		ArrayList<Objectz> listZ = new ArrayList<Objectz>();
		String sql2 = "SELECT lichsutiemphong.MaKH,lichsutiemphong.MaVacxin,lichsutiemphong.STTMui,vacxin.GiaVacxin FROM lichsutiemphong"
					  +" INNER JOIN vacxin"
					  +" ON lichsutiemphong.MaVacxin = vacxin.MaVacxin";
		try {
			pst = conn.prepareStatement(sql2);
			rs = pst.executeQuery();
			while(rs.next()){
				listZ.add(new Objectz(rs.getString("MaKH"),rs.getString("MaVacxin"),rs.getInt("STTMui"),rs.getInt("GiaVacxin")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		/**
		 * Xử lý 3:
		 */
		ArrayList<Objecty> list = new ArrayList<Objecty>();
		int temp = 0;
		for(KhachHang khachHang : listKH){
			for(Objectz x : listZ){
				if(khachHang.getMaKH().equals(x.getMaKH())){
					temp += x.getGiaVacxin()*x.getSttMui();
				}
			}
			list.add(new Objecty(khachHang.getMaKH(),temp));
			
		}
		return list;
	}
	public static void main(String[]args){
		for(Objecty y : new ObjectyDAO().getList()){
			System.out.println(y.getTenKhachHang()+"--"+y.getChiPhi());
		}
	}
}
