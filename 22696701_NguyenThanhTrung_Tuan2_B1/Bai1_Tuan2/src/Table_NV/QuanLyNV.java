package Table_NV;

import java.util.ArrayList;

public class QuanLyNV {
	ArrayList<ThongTinNV> dsNv;

	public QuanLyNV(ArrayList<ThongTinNV> dsNv) {
		super();
		this.dsNv = new ArrayList<ThongTinNV>();
	}

	public boolean addNv(ThongTinNV nv) {
		if (dsNv.contains(nv)) {
			return false;
		}
		dsNv.add(nv);
		return true;
	}

	public boolean removeNV(String maNVXoa) {
        ThongTinNV nv = new ThongTinNV(maNVXoa);
        if (dsNv.contains(nv)) {
            dsNv.remove(nv);
            System.out.println("Xóa thành công");
            return true;
        }
        return false;
    }

	public ThongTinNV timNV(String maNVTim) {
		ThongTinNV nv = new ThongTinNV(maNVTim);
		if (dsNv.contains(nv)) {
			return dsNv.get(dsNv.indexOf(nv));
		}
		return null;

	}

	public ArrayList<ThongTinNV> getDS() {
		return dsNv;
	}

}
