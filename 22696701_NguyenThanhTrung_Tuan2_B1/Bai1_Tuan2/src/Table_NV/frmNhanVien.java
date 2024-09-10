package Table_NV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class frmNhanVien extends JFrame implements ActionListener, MouseListener {

	private JPanel jpNo;
	private JLabel jlTitle;
	private JPanel jpCen;
	private JLabel jlMaNv;
	private JTextField jtfMaNv;
	private JLabel jlluong;
	private JTextField jtfluong;
	private JLabel jlHo;
	private JTextField jtfHo;
	private JLabel jlTen;
	private JTextField jtfTen;
	private JLabel jlTuoi;
	private JTextField jtfTuoi;
	private JLabel jlPhai;
	private JRadioButton jrbNu;
	private DefaultTableModel model;
	private JPanel jpSo1;
	private JPanel jpSo2;
	private JLabel jlNhapMa;
	private JTextField jtfMaTim;
	private JButton jbTim;
	private JButton jbThem;
	private JButton jbXoaTrang;
	private JButton jbXoa;
	private JButton jbLuu;
	private JTable table;
	private QuanLyNV ds = new QuanLyNV(null);

	public frmNhanVien() {
		super("^_^");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);

		jpNo = new JPanel();
		jlTitle = new JLabel("THONG TIN NHAN VIEN");
		Font fn1 = new Font("Arial", Font.BOLD, 30);
		jlTitle.setFont(fn1);
		jlTitle.setForeground(Color.BLUE);

		jpNo.add(jlTitle);

		jpCen = new JPanel();
		jpCen.setLayout(null);

		jlMaNv = new JLabel("Ma Nhan Vien: ");
		Font fn2 = new Font("Arial", Font.BOLD, 13);
		jlMaNv.setFont(fn2);
		jlMaNv.setBounds(0, 20, 100, 20);

		jtfMaNv = new JTextField();
		jtfMaNv.setBounds(100, 20, 580, 20);

		jpCen.add(jtfMaNv);
		jpCen.add(jlMaNv);

		jlHo = new JLabel("Ho: ");
		jlHo.setFont(fn2);
		jlHo.setBounds(0, 60, 100, 20);

		jtfHo = new JTextField();
		jtfHo.setBounds(100, 60, 240, 20);

		jpCen.add(jtfHo);
		jpCen.add(jlHo);

		jlTen = new JLabel("Ten Nhan Vien: ");
		Font fn3 = new Font("Arial", Font.BOLD, 12);
		jlTen.setFont(fn3);
		jlTen.setBounds(340, 60, 100, 20);

		jtfTen = new JTextField();
		jtfTen.setBounds(440, 60, 240, 20);

		jpCen.add(jtfTen);
		jpCen.add(jlTen);

		jlTuoi = new JLabel("Tuoi: ");
		jlTuoi.setFont(fn2);
		jlTuoi.setBounds(0, 100, 100, 20);

		jtfTuoi = new JTextField();
		jtfTuoi.setBounds(100, 100, 380, 20);

		jpCen.add(jtfTuoi);
		jpCen.add(jlTuoi);

		jlPhai = new JLabel("Phai: ");
//		Font fn3 = new Font("Arial", Font.BOLD, 12);
		jlPhai.setFont(fn3);
		jlPhai.setBounds(480, 100, 100, 20);

		jrbNu = new JRadioButton("Nu");
		jrbNu.setBounds(580, 100, 240, 20);

		jpCen.add(jlPhai);
		jpCen.add(jrbNu);

		jlluong = new JLabel("Tien Luong: ");
		jlluong.setFont(fn2);
		jlluong.setBounds(0, 140, 100, 20);

		jtfluong = new JTextField();
		jtfluong.setBounds(100, 140, 580, 20);

		jpCen.add(jtfluong);
		jpCen.add(jlluong);

		String[] colNames = { "MaNv", "Ho", "Ten", "Phai", "Tuoi", "Tien Luong" };
		model = new DefaultTableModel(colNames, 0);
		JScrollPane jscroll = new JScrollPane();
		jscroll.setViewportView(table = new JTable(model));
		jscroll.setBounds(0, 180, 680, 100);
		jpCen.add(jscroll);
		add(jpCen, BorderLayout.CENTER);

		add(jpNo, BorderLayout.NORTH);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		jpSo1 = new JPanel();
		jpSo2 = new JPanel();
		jlNhapMa = new JLabel("Nhap ma can tim: ");
		jlNhapMa.setFont(fn2);
		jpSo1.add(jlNhapMa);

		jtfMaTim = new JTextField(15);
		jpSo1.add(jtfMaTim);

		jbTim = new JButton("Tim");
		jpSo1.add(jbTim);

		jbThem = new JButton("Thêm");
		jpSo2.add(jbThem);

		jbXoaTrang = new JButton("Xóa Trắng");
		jpSo2.add(jbXoaTrang);
		jbXoa = new JButton("Xóa");
		jpSo2.add(jbXoa);
		jbLuu = new JButton("Lưu");
		jpSo2.add(jbLuu);

		split.add(jpSo1);
		split.add(jpSo2);

		jbTim.addActionListener(this);
		jbThem.addActionListener(this);
		jbXoa.addActionListener(this);
		jbXoaTrang.addActionListener(this);
		jbLuu.addActionListener(this);
		table.addMouseListener(this);
		add(split, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(jbThem)) {
			them();
		}
		if (o.equals(jbXoa)) {
			xoa();
		}
		if (o.equals(jbXoaTrang)) {
			xoaTrang();
		}
		if (o.equals(jbTim)) {
			
			String maTim = jtfMaTim.getText();
			JOptionPane.showMessageDialog(null, ds.timNV(maTim));
		}

	}

	private void them() {
		try {
			String maNV = jtfMaNv.getText();
			String ho = jtfHo.getText();
			String ten = jtfTen.getText();
			boolean phai = (jrbNu.isSelected()) ? true : false;
			String gt = phai ? "Nữ" : "Nam";
			int tuoi = Integer.parseInt(jtfTuoi.getText());
			double tienLuong = Double.parseDouble(jtfluong.getText());
			ThongTinNV nv = new ThongTinNV(maNV, ho, ten, tuoi, phai, tienLuong);
			if (ds.addNv(nv)) {
				String[] row = { maNV, ho, ten, gt, Integer.toString(tuoi), tienLuong + "" };
				model.addRow(row);
			} else {
				xoaTrang();
				JOptionPane.showMessageDialog(null, "Trùng mã nhân viên.");
				jtfMaNv.selectAll();
				jtfMaNv.requestFocus();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
			return;
		}
	}

	private void xoaTrang() {
		jtfHo.setText("");
		jtfluong.setText("");
		jtfMaNv.setText("");
		jtfMaTim.setText("");
		jtfTen.setText("");
		jtfTuoi.setText("");
		jrbNu.setSelected(false);

	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String maNV = (String) table.getModel().getValueAt(row, 0);
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);

			if (hoiNhac == JOptionPane.YES_OPTION) {
				if (ds.removeNV(maNV)) {
					model.removeRow(row);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chưa chọn hàng để xóa");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow(); // Lấy dòng đang chọn trên table
	    jtfMaNv.setText(table.getValueAt(row, 0).toString());
	    jtfHo.setText(table.getValueAt(row, 1).toString());
	    jtfTen.setText(table.getValueAt(row, 2).toString());
	    jrbNu.setSelected(true);
	    if (table.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
	        jrbNu.setSelected(false);
	    }
	    jtfTuoi.setText(table.getValueAt(row, 4).toString());
	    jtfluong.setText(table.getValueAt(row, 5).toString());

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

}
