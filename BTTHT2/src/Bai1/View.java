package Bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class View extends JFrame implements ActionListener {
	private JPanel jpNo;
	private JLabel jLTitle;
	private JPanel jpSO;
	private JPanel jpcen;
	private JPanel jpSo1;
	private JLabel jlMaTim;
	private JTextField jtfMaTim;
	private JButton jbTim;
	private JPanel jpSo2;
	private JButton jbThem;
	private JButton jbXoaTrang;
	private JButton jbXoa;
	private JButton jbLuu;
	private JPanel jpcen1;
	private JLabel jlMaNV;
	private JTextField jtfMaNv;
	private JLabel jlHo;
	private JTextField jtfHo;
	private JLabel jlTen;
	private JTextField jtfTen;
	private JLabel jlTuoi;
	private JTextField jtfTuoi;
	private JLabel jlPhai;
	private JRadioButton jrbNu;
	private JLabel jlLuong;
	private JTextField jtfLuong;
	private JTable table;
	
	DsNV ds1 = new DsNV();
	private DefaultTableModel tbl;
	

	public View() {
		Font fn1 = new Font("Arial", Font.BOLD, 13);
		setTitle("^_^");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);

		jpNo = new JPanel();
		jLTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font fn = new Font("Arial", Font.BOLD, 20);
		jLTitle.setFont(fn);
		jLTitle.setForeground(Color.BLUE);
		jpNo.add(jLTitle);
		add(jpNo, BorderLayout.NORTH);

		jpcen = new JPanel();
		jpcen.setLayout(new BoxLayout(jpcen, BoxLayout.Y_AXIS));

		jpcen1 = new JPanel();
		jpcen1.setLayout(null);
//		jpcen1.setLayout(new GridLayout(1, 2));
//		jpcen1.setLayout(new BoxLayout(jpcen1, BoxLayout.X_AXIS));

		jlMaNV = new JLabel("Mã Nhân Viên: ");
		jlMaNV.setBounds(0,10,100,20);
		jlMaNV.setFont(fn1);
		jpcen1.add(jlMaNV);

		jtfMaNv = new JTextField(50);
		jtfMaNv.setBounds(100,10,580,20);
		jpcen1.add(jtfMaNv);

		jpcen.add(jpcen1);

		jlHo = new JLabel("Họ: ");
		jlHo.setBounds(0, 50,100, 20);
		jlHo.setFont(fn1);
		jpcen1.add(jlHo);
		
		jtfHo = new JTextField(30);
		jtfHo.setBounds(100, 50,240, 20);
		jpcen1.add(jtfHo);
		
		jlTen = new JLabel("Tên Nhân Viên: ");
		jlTen.setBounds(350, 50,100, 20);
		jlTen.setFont(fn1);
		jpcen1.add(jlTen);
		
		jtfTen = new JTextField(20);
		jtfTen.setBounds(450, 50,230, 20);
		jpcen1.add(jtfTen);
		
		jlTuoi = new JLabel("Tuổi: ");
		jlTuoi.setBounds(0,90,100,20);
		jpcen1.add(jlTuoi);		
		
		jtfTuoi = new JTextField();
		jtfTuoi.setBounds(100,90,400,20);
		jpcen1.add(jtfTuoi);	

		jlPhai = new JLabel("Phái: ");
		jlPhai.setBounds(500,90,50,20);
		jpcen1.add(jlPhai);
		
		jrbNu = new JRadioButton("Nữ");
		jrbNu.setBounds(550,90,50,20);
		jpcen1.add(jrbNu);
		
		
		
		jlLuong = new JLabel("Tiền Lương");
		jlLuong.setBounds(0,130,100,20);
		jpcen1.add(jlLuong);
		
		jtfLuong = new JTextField();
		jtfLuong.setBounds(100,130,580,20);
		jpcen1.add(jtfLuong);
		
		
		
		
		String[] colNames= {"Mã NV","Họ","Tên","Phái","Tuổi","Tiền lương"};
		Object[][] data = {
		};
		
		DefaultTableModel model=new DefaultTableModel(data, colNames);
		table=new JTable(model);

		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setBounds(0,170,680,200);
		jpcen1.add(jscpane);
		
		tbl=(DefaultTableModel)table.getModel();
		

       
		

		

		

		add(jpcen, BorderLayout.CENTER);

		jpSO = new JPanel();
		jpSO.setLayout(new BoxLayout(jpSO, BoxLayout.X_AXIS));

		jpSo1 = new JPanel();
		jpSo1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
//		jpSo1.setLayout(new GridLayout(1,3));
		jlMaTim = new JLabel("Nhập mã số cần tìm: ");
		jlMaTim.setFont(fn1);
		jtfMaTim = new JTextField(10);
		jbTim = new JButton("Tìm");
		jbTim.addActionListener(this);

		jpSo1.add(jlMaTim);
		jpSo1.add(jtfMaTim);
		jpSo1.add(jbTim);

		jpSO.add(jpSo1);
		jpSO.add(Box.createHorizontalStrut(10));

		jpSo2 = new JPanel();
//		jpSo2.setLayout(new GridLayout(1,4));
		jpSo2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		jbThem = new JButton("Thêm");
		jbThem.addActionListener(this);
		
		jbXoaTrang = new JButton("Xóa Trắng");
		jbXoaTrang.addActionListener(this);
		
		jbXoa = new JButton("Xóa");
		jbXoa.addActionListener(this);
		
		jbLuu = new JButton("Lưu");
		jbLuu.addActionListener(this);
		

		jpSo2.add(jbThem);
		jpSo2.add(jbXoaTrang);
		jpSo2.add(jbXoa);
		jpSo2.add(jbLuu);

		jpSO.add(jpSo2);
		add(jpSO, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(jbThem)) {
			ds1.addNhanVien(getDs());
			
		}else if(o.equals(jbLuu)) {
			System.out.println(ds1.getDsNV());
		}else if(o.equals(jbXoaTrang)) {
			jtfMaNv.setText("");
			jtfHo.setText("");
			jtfTen.setText("");
			jtfTuoi.setText("");
			jtfLuong.setText("");
			jrbNu.setSelected(false);
		}else if(o.equals(jbTim)) {
			timNhanVien();
		}else if(o.equals(jbXoa)) {
			removeNV();
		}

	}
	public NhanVien getDs() {
		NhanVien nv1 = new NhanVien();
		
		nv1.setMaNv(jtfMaNv.getText());
		nv1.setHo(jtfHo.getText());
		nv1.setTen(jtfTen.getText());
		nv1.setTuoi(Integer.parseInt(jtfTuoi.getText()));
		nv1.setPhai(jrbNu.isSelected());
		nv1.setTienLuong(Double.parseDouble(jtfLuong.getText()));
		
		Object[] row1 = new Object[] {
			nv1.getMaNv(),nv1.getHo(),nv1.getTen(),
			Phai(nv1.isPhai())
			,nv1.getTuoi(),nv1.getTienLuong()	
		};
		tbl.addRow(row1);
		return nv1;
	
	}
	private void timNhanVien (){
		System.out.println(ds1.findNhanVien(jtfMaTim.getText()));
		
	}
	private String Phai(boolean nu) {
		if(nu) {
			return "Nữ";
		}
		return "Nam";
	}
	private void removeNV() {
		int response = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn xóa dòng này không?",
			    "Cảnh báo",
			    JOptionPane.YES_NO_OPTION
			);

			if (response == JOptionPane.YES_OPTION) {
			    int selectedRow = table.getSelectedRow();
			    if (selectedRow != -1) {
			        tbl.removeRow(selectedRow);
			    } else {
			        JOptionPane.showMessageDialog(this, "Không có dòng nào được chọn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
			    }
			}

	}

}
