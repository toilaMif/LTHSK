package Bai1;

import java.util.Objects;

public class NhanVien {
	private String maNv;
	private String ho;
	private String ten;
	private int tuoi;
	private boolean phai;
	private double tienLuong;
	
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNv, String ho, String ten, int tuoi, boolean phai, double tienLuong) {
		super();
		this.maNv = maNv;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
	}
	public String getMaNv() {
		return maNv;
	}
	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	@Override
	public String toString() {
		return "{"+ maNv + "," + ho + "," + ten + "," + tuoi + "," + phai
				+ "," + tienLuong + "}";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ho, maNv, phai, ten, tienLuong, tuoi);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(ho, other.ho) && Objects.equals(maNv, other.maNv) && phai == other.phai
				&& Objects.equals(ten, other.ten)
				&& Double.doubleToLongBits(tienLuong) == Double.doubleToLongBits(other.tienLuong) && tuoi == other.tuoi;
	}
	
	
}
