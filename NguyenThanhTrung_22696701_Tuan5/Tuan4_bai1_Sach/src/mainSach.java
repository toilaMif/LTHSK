
public class mainSach {
	public static void main(String[] args) {
//		frmSach s1 = new frmSach();
		
		QLySach ds1 = new QLySach();
		
		Sach s1 = new Sach("trung");
		ds1.addSach(s1);
		
		Sach s2 = new Sach("trung1");
		ds1.addSach(s2);
		
		System.out.println(ds1.findSach("trung"));
		
		ds1.suaSach("trung1", null, "Thanh Trung", 0, null, 0, 0, null);
		
		
		
		System.out.println(ds1.toString());
	}
	
}
