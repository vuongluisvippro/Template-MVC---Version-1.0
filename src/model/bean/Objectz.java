package model.bean;

@SuppressWarnings("all")
public class Objectz {
	private String maKH;
	private String MaVacxin;
	private int sttMui;
	private int giaVacxin;
	public Objectz() {
		super();
	}
	
	public Objectz(String maKH, String maVacxin, int sttMui, int giaVacxin) {
		super();
		this.maKH = maKH;
		MaVacxin = maVacxin;
		this.sttMui = sttMui;
		this.giaVacxin = giaVacxin;
	}

	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaVacxin() {
		return MaVacxin;
	}
	public void setMaVacxin(String maVacxin) {
		MaVacxin = maVacxin;
	}
	public int getSttMui() {
		return sttMui;
	}
	public void setSttMui(int sttMui) {
		this.sttMui = sttMui;
	}
	public int getGiaVacxin() {
		return giaVacxin;
	}
	public void setGiaVacxin(int giaVacxin) {
		this.giaVacxin = giaVacxin;
	}
	
}
