import java.util.Objects;

public class Sach {
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int NXB;
	private String nhaXB;
	private int soTrang;
	private double donGia;
	private String ISBN;
	public Sach(String maSach, String tuaSach, String tacGia, int nXB, String nhaXB, int soTrang, double donGia,
			String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		NXB = nXB;
		this.nhaXB = nhaXB;
		this.soTrang = soTrang;
		this.donGia = donGia;
		ISBN = iSBN;
	}
	public Sach() {
		super();
	}
	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTuaSach() {
		return tuaSach;
	}
	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getNXB() {
		return NXB;
	}
	public void setNXB(int nXB) {
		NXB = nXB;
	}
	public String getNhaXB() {
		return nhaXB;
	}
	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, NXB, donGia, maSach, nhaXB, soTrang, tacGia, tuaSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(ISBN, other.ISBN) && NXB == other.NXB
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(maSach, other.maSach) && Objects.equals(nhaXB, other.nhaXB)
				&& soTrang == other.soTrang && Objects.equals(tacGia, other.tacGia)
				&& Objects.equals(tuaSach, other.tuaSach);
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", NXB=" + NXB + ", nhaXB="
				+ nhaXB + ", soTrang=" + soTrang + ", donGia=" + donGia + ", ISBN=" + ISBN + "]";
	}
	
	
	
}
