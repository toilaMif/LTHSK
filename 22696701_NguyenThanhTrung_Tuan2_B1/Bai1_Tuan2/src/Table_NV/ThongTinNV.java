package Table_NV;

import java.util.Objects;

public class ThongTinNV {
	private String maNV;
	private String ho;
	private String ten;
	private int tuoi;
	private boolean phai;
	private double luong;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
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
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public ThongTinNV() {
		super();
	}
	public ThongTinNV(String maNv) {
		this(maNv, "","", 0, true, 0.0);
	}
	public ThongTinNV(String maNV, String ho, String ten, int tuoi, boolean phai, double luong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.luong = luong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ho, luong, maNV, phai, ten, tuoi);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThongTinNV other = (ThongTinNV) obj;
		return Objects.equals(ho, other.ho) && Double.doubleToLongBits(luong) == Double.doubleToLongBits(other.luong)
				&& Objects.equals(maNV, other.maNV) && phai == other.phai && Objects.equals(ten, other.ten)
				&& tuoi == other.tuoi;
	}
	@Override
	public String toString() {
		return "ThongTinNV [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", luong=" + luong + "]";
	}
	
	
	
}
