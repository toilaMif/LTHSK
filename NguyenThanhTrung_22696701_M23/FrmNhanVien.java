package NguyenThanhTrung_22696701_M23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrmNhanVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtTuoi;
	private JTextField txtEmail;

	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;

	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	private QuanLy thuvien;
	private DefaultTableModel tableModel;

	private JButton btnLoc;

	public FrmNhanVien() {
		setTitle("Quản lý sách");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Phần North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("Mã Nhân Viên: "));
		pnlNorth.add(lblTuaSach = new JLabel("Họ Tên: "));
		pnlNorth.add(lblTacGia = new JLabel("địa chỉ: "));
		pnlNorth.add(lblNamXB = new JLabel("Tuổi: "));
		pnlNorth.add(lblNhaXB = new JLabel("website: "));

		pnlNorth.add(txtMa = new JTextField());
		pnlNorth.add(txtTen = new JTextField());
		pnlNorth.add(txtDiaChi = new JTextField());
		pnlNorth.add(txtTuoi = new JTextField());
		pnlNorth.add(txtEmail = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtMa.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtDiaChi.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtTuoi.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtEmail.setBounds(570, 70, w2, h);

		txtMess.setBounds(20, 145, 550, 20);

		// Phần Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm - kiểm tra dữ liệu ..."));
		pnlCenter.add(btnXoaRong = new JButton("Xóa rỗng"));

		// Phần South
		JScrollPane scroll;
		String[] headers = "MaNhanVien;HoTenNV;Tuoi;DiaChi; Email".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		// Xử lý

		thuvien = new QuanLy();

		updateTableData(); // Cập nhật dữ liệu cho table

		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);

	}

	private void fillForm(int row) {
		if (row != -1) {
			String ma = (String) table.getValueAt(row, 0);
			NhanVien s = new NhanVien(ma);
			ArrayList<NhanVien> dsSach = thuvien.getDs();
			if (thuvien.getDs().contains(s)) {
				s = dsSach.get(dsSach.indexOf(s));
				txtMa.setText(s.getMaNV());
				txtTen.setText(s.getHoTen());
				txtDiaChi.setText(s.getDiaChi());
				txtEmail.setText(s.getEmail());
				txtTuoi.setText(s.getTuoi() + "");
				txtMa.setEditable(false);
			}
		}
	}

	private void updateTableData() {
		XoaHetDuLieuTrenTableModel();
		for (NhanVien s : thuvien.getDs()) {
			tableModel.addRow(new Object[] { s.getMaNV(), s.getHoTen(), s.getTuoi(), s.getDiaChi(), s.getEmail(), });
		}

		table.setModel(tableModel);

	}

	private void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				them();
			}
		}
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}

	private boolean validData() {

		String manv = txtMa.getText().trim();
		String tenNv = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText());
		String tuoistr = txtTuoi.getText().trim();
		String pb = txtEmail.getText().trim();
		
		
		if (!(manv.length() > 0 && manv.matches("MNV\\d{2}"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh MNV\\\\d{2}");
			txtMa.selectAll();
			txtMa.requestFocus();
			return false;
		} else if (!(tenNv.length() > 0 && tenNv.matches("(([a-z]+)|([A-Z][a-z]+)|\\s|\\d)+"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh Ten");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		} else if (!(diachi.length() > 0 && diachi.matches("(([a-z]+)|([A-Z][a-z]+)|\\s|\\d)+"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh dia chi ");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		} else if (!(pb.length() > 0 && pb.matches("PB\\d{2}(TP|KT)"))) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh phong ban PB\\d{2}(TP|KT)");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		} else if (!(tuoistr.length() > 0 && tuoi >= 18 && tuoi <= 60)) {
			JOptionPane.showMessageDialog(null, "Nhap sai dinh danh tu 18 - 60 tuoi");
			txtTuoi.selectAll();
			txtTuoi.requestFocus();
			return false;
		}
		
		return true;

	}

	void them() {
		String manv = txtMa.getText().trim();
		String tenNv = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText());
		String mail = txtEmail.getText();

		NhanVien s1 = new NhanVien(manv, tenNv, diachi, tuoi, mail);

		if (thuvien.them(s1)) {
			String[] row = { manv, tenNv, tuoi + "", diachi, mail };
			tableModel.addRow(row);
		}
	}

	private void clearTextfields() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtTuoi.setText("");
		txtEmail.setText("");

		txtMa.setEditable(true);
		txtMa.requestFocus();

	}

}
