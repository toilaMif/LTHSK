import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class QLySach {
	ArrayList<Sach> dsSach;

	public QLySach() {
		super();
		this.dsSach = new ArrayList<Sach>();
	}
	public boolean addSach(Sach s1) {
		if(dsSach.contains(s1))
			return false;
		dsSach.add(s1);
		return true;
	}
	public boolean removeSach(String Mas1) {
		Sach s1 = new Sach(Mas1);
		if(dsSach.contains(s1)) {
			dsSach.remove(s1);
			return true;
			
		}
		else {
			return false;
		}
		
	}
	public boolean findSach(String Mas1) {
		Sach s1 = new Sach(Mas1);
		if(dsSach.contains(s1))
//			return dsSach.get(dsSach.indexOf(s1));
			return true;
//		return null;
		return false;
	}
	public boolean suaSach(String Mas1, String tuaSach, String tacGia, int nXB, String nhaXB, int soTrang, double donGia,
			String iSBN) {
		
		
		for (Sach s : dsSach){
			if(findSach(Mas1)) {
				s.setDonGia(donGia);
				s.setISBN(iSBN);
				s.setNhaXB(nhaXB);
				s.setMaSach(Mas1);
				s.setNXB(nXB);
				s.setTacGia(tacGia);
				s.setTuaSach(tuaSach);
				s.setSoTrang(soTrang);
				
			}
		}
		return false;
			
	}
	
	@Override
	public String toString() {
		return "QLySach [dsSach=" + dsSach + "]";
	}
	
	
	
	
}
