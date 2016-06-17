package model.bean;

@SuppressWarnings("all")
public class Objecty {
	
	private String tenKhachHang;
	private int chiPhi;
	public Objecty() {
		super();
	}
	public Objecty(String tenKhachHang, int chiPhi) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.chiPhi = chiPhi;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public int getChiPhi() {
		return chiPhi;
	}
	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}
}
