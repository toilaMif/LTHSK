package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import connectDB.ConnectDB;
import dao.NhanVien_Dao;
import dao.PhongBan_DAO;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_GUI extends JFrame implements ActionListener, MouseListener {

	private JTable table;
	private JTextField txtMaNV;
	private JTextField txthoTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private DefaultTableModel tableModel;
	private JLabel lblPhong;
	private JTextField txtPhong;
	private JComboBox cboPhong;
	private JButton btnSua;

	private NhanVien_Dao nv_dao;
	private PhongBan_DAO pb_dao;

	public NhanVien_GUI() {

		// khởi tạo kết nối đến CSDL
		ConnectDB.getInstance().connect();

		nv_dao = new NhanVien_Dao();
		pb_dao = new PhongBan_DAO();

		setTitle("^-^");
		setSize(700, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();

		Box b1, b2, b3, b4, b5;
		JLabel lblMaNV, lblhoTen, lblTuoi, lblTienLuong;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên: "));
		b1.add(txtMaNV = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblhoTen = new JLabel("Họ tên: "));
		b2.add(txthoTen = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi: "));
		b3.add(txtTuoi = new JTextField());
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));

		b4.add(lblPhong = new JLabel("Mã phòng: "));

		// Tạo và đổ dữ liệu vào comboBox
		b4.add(cboPhong = new JComboBox<String>());
		cboPhong.setEditable(true);

		ArrayList<PhongBan> listPB = pb_dao.getalltbPhongBan();
		for (PhongBan p : listPB) {
			cboPhong.addItem(p.getMaPhong());
		}

		b4.add(lblTienLuong = new JLabel("Tiền lương: "));
		b4.add(txtTienLuong = new JTextField());

		lblhoTen.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());

		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String[] headers = "MaNV;Họ tên;Tuổi;Phòng;Tiền lương".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		b5.add(scroll);
		add(b, BorderLayout.CENTER);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		pnlLeft.add(new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(btnTim = new JButton("Tìm"));

		pnlRight.add(btnThem = new JButton("Thêm"));
		pnlRight.add(btnSua = new JButton("Sửa"));
		pnlRight.add(btnXoa = new JButton("Xóa"));
		pnlRight.add(btnLuu = new JButton("Lưu"));
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);

		// doc du lieu tu database SQL vao Jtable
		DocDuLieuDatabaseVaoTable();
	}

	public static void main(String[] args) {
		new NhanVien_GUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem))
			themNV();
		if (o.equals(btnLuu))
			DocDuLieuDatabaseVaoTable();
		if (o.equals(btnSua))
			suaNV();
		if (o.equals(btnXoa))
			xoaNV();
	}

	public void themNV() {
		// pHai kiem tra Rang buoc truoc khi them
		String ma = txtMaNV.getText();
		String hoten = txthoTen.getText();
		int tuoi = Integer.parseInt(txtTuoi.getText());
		double luong = Double.parseDouble(txtTienLuong.getText());
		String phongban = cboPhong.getSelectedItem().toString();
		PhongBan phban = new PhongBan(phongban);
		NhanVien nv = new NhanVien(ma, hoten, tuoi, phban, luong);
//		try {
//			nv_dao.create(nv);
//			tableModel.addRow(new Object[] { nv.getMaNV(),
//					nv.getHoten(), nv.getTuoi(), nv.getPhong().getMaPhong(), nv.getTienluong() });
//		} catch (Exception e1) {
//			JOptionPane.showMessageDialog(this, "Trùng");
//		}
		if (nv_dao.create(nv)) {
			tableModel.addRow(new Object[] { nv.getMaNV(), nv.getHoten(), nv.getTuoi(), nv.getPhong().getMaPhong(),
					nv.getTienluong() });
			xoaTrang();
		}

	}

	public void suaNV() {
		int row = table.getSelectedRow();
		String ma = txtMaNV.getText();
		String hoten = txthoTen.getText();
		int tuoi = Integer.parseInt(txtTuoi.getText());
		double luong = Double.parseDouble(txtTienLuong.getText());
		String phongban = cboPhong.getSelectedItem().toString();
		PhongBan phban = new PhongBan(phongban);
		NhanVien nv = new NhanVien(ma, hoten, tuoi, phban, luong);
		if (row >= 0) {
			if (nv_dao.update(nv)) {
				table.setValueAt(txthoTen.getText(), row, 1);
				table.setValueAt(txtTuoi.getText(), row, 2);
				table.setValueAt(cboPhong.getSelectedItem().toString(), row, 3);
				table.setValueAt(txtTienLuong.getText(), row, 4);
			}
		}
	}

	public void xoaNV() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			String manv = (String) table.getValueAt(row, 0);
			if (nv_dao.delete(manv)) {
				tableModel.removeRow(row);
				xoaTrang();
			}
		}

	}

	public void xoaTrang() {
		txtMaNV.setText("");
		txthoTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		txtMaNV.requestFocus();

	}

//đưa dữ liệu vào table
	private void DocDuLieuDatabaseVaoTable() {
		NhanVien_Dao ds = new NhanVien_Dao();
		List<NhanVien> list = ds.getalltbNhanVien();
		for (NhanVien s : list) {
			String[] rowData = { s.getMaNV(), s.getHoten(), s.getTuoi() + "", s.getPhong().getMaPhong(),
					s.getTienluong() + "" };
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaNV.setText(tableModel.getValueAt(row, 0).toString());
		txthoTen.setText(tableModel.getValueAt(row, 1).toString());
		txtTuoi.setText(tableModel.getValueAt(row, 2).toString());
		cboPhong.setSelectedItem(tableModel.getValueAt(row, 3).toString());
		txtTienLuong.setText(tableModel.getValueAt(row, 4).toString());

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
