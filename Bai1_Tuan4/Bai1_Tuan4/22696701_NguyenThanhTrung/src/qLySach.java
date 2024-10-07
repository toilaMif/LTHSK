import java.util.ArrayList;

public class qLySach {
	private ArrayList<sach> dsSach;

	public qLySach() {
		dsSach = new ArrayList<sach>(10);
	}

	public boolean addSach(sach s) {
		sach s1 = new sach(s.getMaSach());
		if (dsSach.contains(s1)) {
			return false;
		}

		return dsSach.add(s);
	}

	public ArrayList<sach> getDS() {
		return dsSach;

	}

	public sach getSach(String maSach) {
		sach s1 = new sach(maSach);
		if (dsSach.contains(s1)) {
			return dsSach.get(dsSach.indexOf(s1));
		}
		return null;
	}

	public boolean removeSach(String maSachxoa) {
		sach s1 = new sach(maSachxoa);
		if (dsSach.contains(s1)) {
			dsSach.remove(dsSach.indexOf(s1));
			return true;
		}
		return false;

	}

	public sach timkiem(String maSachTim) {
		sach s1 = new sach(maSachTim);
		if (dsSach.contains(s1))
			return dsSach.get(dsSach.indexOf(s1));
		return null;

	}

	public boolean cnSach(String maSachcu, sach sachNew) {
		sach s1 = new sach(maSachcu);
		if (dsSach.contains(s1)) {
			s1 = dsSach.get(dsSach.indexOf(s1));
			s1.setDonGia(sachNew.getDonGia());
			s1.setIsbn(sachNew.getIsbn());
			s1.setMaSach(sachNew.getMaSach());
			s1.setNamXb(sachNew.getNamXb());
			s1.setNXB(sachNew.getNXB());
			s1.setSoTrang(sachNew.getSoTrang());
			s1.setTacGia(sachNew.getTacGia());
			s1.setTuaSach(sachNew.getTuaSach());

			return true;
		}
		return false;

	}
}
