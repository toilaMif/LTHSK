import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

public class frmSach extends JFrame implements ActionListener, MouseInputListener {

	private JLabel jlMasach;
	private JFormattedTextField jtfMasach;
	private JLabel jlTuasach;
	private JFormattedTextField jtfTuasach;
	private JLabel jlTacgia;
	private JFormattedTextField jtfTacgia;
	private JLabel jlNamXB;
	private JFormattedTextField jtfNamXB;
	private JLabel jlNxb;
	private JFormattedTextField jtfNXB;
	private JLabel jlSotrang;
	private JFormattedTextField jtfSotrang;
	private JLabel jlDongia;
	private JFormattedTextField jtfDongia;
	private JLabel jlIsbn;
	private JFormattedTextField jtfIsbn;
	private JButton jbThem;
	private JButton jbXoarong;
	private JButton jbXoa;
	private JButton jbSua;
	private JButton jbLuu;
	private JLabel jlTim;
	private JComboBox jcbTim;
	private final static String filename = "DuLieu.txt";
	private DefaultTableModel Model;
	private JTable table;
	private qLySach qlsach1 ;

	public frmSach() {
		setTitle("Quan Ly Sach");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Box b, b1, b2, b3;
		Box b11, b12, b13, b14, b15;

		b = Box.createVerticalBox();
		b1 = Box.createVerticalBox();
		b1.setBorder(BorderFactory.createTitledBorder("Records Editor"));

		b11 = Box.createHorizontalBox();
		b11.add(Box.createHorizontalStrut(20));
		b11.add(jlMasach = new JLabel("Ma Sach: "));
		b11.add(jtfMasach = new JFormattedTextField());
		b11.add(Box.createHorizontalStrut(400));

		b1.add(b11);
		b1.add(Box.createVerticalStrut(10));

		b12 = Box.createHorizontalBox();
		b12.add(Box.createHorizontalStrut(20));
		b12.add(jlTuasach = new JLabel("Tua Sach: "));
		b12.add(jtfTuasach = new JFormattedTextField());
		b12.add(Box.createHorizontalStrut(20));
		b12.add(jlTacgia = new JLabel("TacGia: "));
		b12.add(jtfTacgia = new JFormattedTextField());
		b12.add(Box.createVerticalStrut(15));

		b1.add(b12);
		b1.add(Box.createVerticalStrut(10));

		b13 = Box.createHorizontalBox();
		b13.add(Box.createHorizontalStrut(20));
		b13.add(jlNamXB = new JLabel("Nam Xuat ban: "));
		b13.add(jtfNamXB = new JFormattedTextField());
		b13.add(Box.createHorizontalStrut(20));
		b13.add(jlNxb = new JLabel("Nha Xuat Ban: "));
		b13.add(jtfNXB = new JFormattedTextField());
		b13.add(Box.createVerticalStrut(15));

		b1.add(b13);
		b1.add(Box.createVerticalStrut(10));

		b14 = Box.createHorizontalBox();

		b14.add(Box.createHorizontalStrut(20));
		b14.add(jlSotrang = new JLabel("So trang: "));
		b14.add(jtfSotrang = new JFormattedTextField());
		b14.add(Box.createHorizontalStrut(20));
		b14.add(jlDongia = new JLabel("Don gia: "));
		b14.add(jtfDongia = new JFormattedTextField());
		b14.add(Box.createVerticalStrut(15));

		b1.add(b14);
		b1.add(Box.createVerticalStrut(10));
		b15 = Box.createHorizontalBox();
		b15.add(Box.createHorizontalStrut(20));
		b15.add(jlIsbn = new JLabel("International Standard Book Number: "));
		b15.add(jtfIsbn = new JFormattedTextField());
		b15.add(Box.createHorizontalStrut(330));
		b15.add(Box.createVerticalStrut(15));
		b1.add(b15);
		b1.add(Box.createVerticalStrut(10));

		b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(50));
		b2.add(jbThem = new JButton("Them"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(jbXoarong = new JButton("Xoa rong"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(jbXoa = new JButton("Xoa"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(jbSua = new JButton("Sua"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(jbLuu = new JButton("Luu"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(jlTim = new JLabel("Tim theo ma sach: "));
		b2.add(Box.createHorizontalStrut(10));
		String[] maTim = { "A001", "J002", "H003" };
		b2.add(jcbTim = new JComboBox<String>(maTim));
		b2.add(Box.createHorizontalStrut(50));
		b2.add(Box.createVerticalStrut(15));

		b3 = Box.createHorizontalBox();
		b3.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));
		String[] row = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
		JScrollPane sr;
		Model = new DefaultTableModel(row, 0);
		table = new JTable(Model);
		b3.add(sr = new JScrollPane(table));

		b.add(b1);
		b.add(b2);
		b.add(b3);
		add(b);

		loadDatabase();
		jbThem.addActionListener(this);
		jbLuu.addActionListener(this);
		jbSua.addActionListener(this);
		jbXoa.addActionListener(this);
		jbXoarong.addActionListener(this);
		table.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(jbThem)) {
			if(ktCQ()) {
				them();
			}
		} else if (o.equals(jbSua)) {
			sua();
		} else if (o.equals(jbXoa)) {
			int loinhac = JOptionPane.showConfirmDialog(null, "Ban co chac chan xoa?", "Chu y", JOptionPane.YES_NO_OPTION);
			if(loinhac==JOptionPane.YES_OPTION) {
				xoa();
			}
		} else if (o.equals(jbXoarong)) {
			xoarong();
		} else if (o.equals(jbLuu)) {
			luu(qlsach1.getDS());
		}

	}

	void loadDatabase() {
		BufferedReader br = null;
		qlsach1 = new qLySach();
		try {
			if (new File(filename).exists()) {
				br = new BufferedReader(new FileReader(filename));
				br.readLine();
				while (br.ready()) {
					String line = br.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						sach s = new sach(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]),
								Double.parseDouble(a[6]), a[7]);

						qlsach1.addSach(s);
						Model.addRow(a);
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void them() {
		String maSach = jtfMasach.getText().trim();
		String tuaSach = jtfTuasach.getText().trim();
		String tacGia = jtfTacgia.getText().trim();
		int namXb = Integer.parseInt(jtfNamXB.getText());
		String NXB = jtfNXB.getText().trim();
		int soTrang = Integer.parseInt(jtfSotrang.getText());
		double donGia = Double.parseDouble(jtfDongia.getText());
		String isbn = jtfIsbn.getText().trim();

		sach s1 = new sach(maSach, tuaSach, tacGia, namXb, NXB, soTrang, donGia, isbn);
		if (qlsach1.addSach(s1)) {
			String[] row = { maSach, tuaSach, tacGia, namXb + "", NXB, soTrang + "", donGia + "", isbn };

			Model.addRow(row);
			JOptionPane.showMessageDialog(null, "Them Thanh cong");
		}

	}

	void xoarong() {
		jtfMasach.setText("");
		jtfTuasach.setText("");
		jtfTacgia.setText("");
		jtfNamXB.setText("");
		jtfNXB.setText("");
		jtfSotrang.setText("");
		jtfDongia.setText("");
		jtfIsbn.setText("");
	}

	void xoa() {
		int row = table.getSelectedRow();
		Object maSachXoa = table.getValueAt(row, 0);
		if (qlsach1.removeSach(maSachXoa + "")) {
			Model.removeRow(row);
			JOptionPane.showMessageDialog(null, "Xoa thanh cong");
		}

	}

	void sua() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String maSach = jtfMasach.getText().trim();
			String tuaSach = jtfTuasach.getText().trim();
			String tacGia = jtfTacgia.getText().trim();
			int namXb = Integer.parseInt(jtfNamXB.getText());
			String NXB = jtfNXB.getText().trim();
			int soTrang = Integer.parseInt(jtfSotrang.getText());
			double donGia = Double.parseDouble(jtfDongia.getText());
			String isbn = jtfIsbn.getText().trim();
			sach sachnew = new sach(maSach, tuaSach, tacGia, namXb, NXB, soTrang, donGia, isbn);

			if (qlsach1.cnSach(maSach, sachnew)) {
				Model.setValueAt(maSach, row, 0);
				Model.setValueAt(tuaSach, row, 1);
				Model.setValueAt(tacGia, row, 2);
				Model.setValueAt(namXb, row, 3);
				Model.setValueAt(NXB, row, 4);
				Model.setValueAt(soTrang, row, 5);
				Model.setValueAt(donGia, row, 6);
				Model.setValueAt(isbn, row, 7);
				JOptionPane.showMessageDialog(this, "Sua thanh cong");
			}
		}
	}

	void luu(ArrayList<sach> dsSach) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for (sach s : dsSach) {
				bw.write(s.toString() + "\n");
			}

			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			jtfMasach.setText(table.getValueAt(row, 0) + "");
			jtfTuasach.setText(table.getValueAt(row, 1) + "");
			jtfTacgia.setText(table.getValueAt(row, 2) + "");
			jtfNamXB.setText(table.getValueAt(row, 3) + "");
			jtfNXB.setText(table.getValueAt(row, 4) + "");
			jtfSotrang.setText(table.getValueAt(row, 5) + "");
			jtfDongia.setText(table.getValueAt(row, 6) + "");
			jtfIsbn.setText(table.getValueAt(row, 7) + "");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	boolean ktCQ() {
		String maSach = jtfMasach.getText().trim();
		String tuaSach = jtfTuasach.getText().trim();
		String tacGia = jtfTacgia.getText().trim();
		int namXb = Integer.parseInt(jtfNamXB.getText());
		String NXB = jtfNXB.getText().trim();
		int soTrang = Integer.parseInt(jtfSotrang.getText());
		double donGia = Double.parseDouble(jtfDongia.getText());
		String isbn = jtfIsbn.getText().trim();
		
		
		if(!(maSach.length()>0&&maSach.matches("[A-Z]\\d{3}"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh [A-Z]\\d{3}");
			jtfMasach.requestFocus();
			return false;
		}else if(!(tuaSach.length()>0&&tuaSach.matches("^[a-zA-Z0-9\\s\\-\\(\\)]+$"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh [A-Z][a-z]+|\\d|-|(|)");
			jtfTuasach.requestFocus();
			return false;
		}
		
		return true;
	}

}
