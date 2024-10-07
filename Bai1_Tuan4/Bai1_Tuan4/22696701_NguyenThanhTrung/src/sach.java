import java.util.Objects;

public class sach {

	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int namXb;
	private String NXB;
	private int soTrang;
	private double donGia;
	private String isbn;

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

	public int getNamXb() {
		return namXb;
	}

	public void setNamXb(int namXb) {
		this.namXb = namXb;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public sach(String maSach, String tuaSach, String tacGia, int namXb, String nXB, int soTrang, double donGia,
			String isbn) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXb = namXb;
		NXB = nXB;
		this.soTrang = soTrang;
		this.donGia = donGia;
		this.isbn = isbn;
	}

	public sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public sach() {
		super();

	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		sach other = (sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		return maSach + ";" + tuaSach + ";" + tacGia + ";" + namXb + ";" + NXB + ";" + soTrang + ";" + donGia + ";"
				+ isbn + ";";
	}

}
