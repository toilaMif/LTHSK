package Bai1;

import java.util.ArrayList;

public class DsNV {
	private ArrayList<NhanVien> DsNV;
	
	
	public DsNV() {
		super();
		DsNV = new ArrayList<NhanVien>();
	}
	public boolean addNhanVien(NhanVien nvadd) {
		if(DsNV.contains(nvadd)) {
			return false;
		}else {
			DsNV.add(nvadd);
			return true;
		}
	}
	public boolean remoteNV(String maNVRemote) {
		NhanVien temp = findNhanVien(maNVRemote);
		if(temp != null) {
			return DsNV.remove(temp);
			
		}else {
			return false;
		}
	}
	public NhanVien findNhanVien (String maNVFind) {
		for(NhanVien e : DsNV) {
			if(maNVFind.equals(e.getMaNv())) {
				return e;
			}
		}
		return null;
	}
	public ArrayList<NhanVien> getDsNV() {
		return DsNV;
	}
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		DsNV = dsNV;
	}
	
}
