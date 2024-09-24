import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class frmSach extends JFrame implements ActionListener, MouseListener {

	private JLabel jlMaSach;
	private JTextField jtfMaSach;
	private JLabel jlTuaSach;
	private JTextField jtfTuuSach;
	private JLabel jlTacGia;
	private JTextField jtfTacGia;
	private JLabel jlNamXB;
	private JTextField jtfNamXB;
	private JLabel jlNXB;
	private JTextField jtfNXB;
	private JLabel jlSoTrang;
	private JTextField jtfSoTrang;
	private JLabel jlDongia;
	private JTextField jtfDongia;
	private JLabel jlISNB;
	private JTextField jtfISNB;
	private JButton jbThem;
	private JButton jbXoarong;
	private JButton jbXoa;
	private JButton jbSua;
	private JButton jbLuu;
	private JLabel jlMatim;
	private JComboBox jcbMatim;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private JTable table;
	private Box bt1;
	private Box bt2;

	public frmSach() throws HeadlessException {
		setTitle("Quan Ly Sach");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Box B_1, B_2, B_3;
		Box b1, b2, b3, b4, b5;

		B_1 = Box.createVerticalBox();
		B_1.setBorder(BorderFactory.createTitledBorder("Records Editor"));

		b1 = Box.createHorizontalBox();
		b1.add(jlMaSach = new JLabel("Ma Sach: "));
		b1.add(jtfMaSach = new JTextField());

		B_1.add(b1);

		b2 = Box.createHorizontalBox();
		b2.add(jlTuaSach = new JLabel("Tua Sach: "));
		b2.add(jtfTuuSach = new JTextField());
		b2.add(jlTacGia = new JLabel("Tac Gia: "));
		b2.add(jtfTacGia = new JTextField());

		B_1.add(Box.createVerticalStrut(10));
		B_1.add(b2);

		b3 = Box.createHorizontalBox();
		b3.add(jlNamXB = new JLabel("Nam xuat Ban: "));
		b3.add(jtfNamXB = new JTextField());
		b3.add(jlNXB = new JLabel("Nha xuat Ban: "));
		b3.add(jtfNXB = new JTextField());

		B_1.add(Box.createVerticalStrut(10));
		B_1.add(b3);

		b4 = Box.createHorizontalBox();
		b4.add(jlSoTrang = new JLabel("SoTrang: "));
		b4.add(jtfSoTrang = new JTextField());
		b4.add(jlDongia = new JLabel("Don Gia: "));
		b4.add(jtfDongia = new JTextField());

		B_1.add(Box.createVerticalStrut(10));
		B_1.add(b4);

		b5 = Box.createHorizontalBox();
		b5.add(jlISNB = new JLabel("SISBN: "));
		b5.add(jtfISNB = new JTextField());

		B_1.add(Box.createVerticalStrut(10));
		B_1.add(b5);

		B_2 = Box.createHorizontalBox();

		jbXoarong = new JButton("Xoa Rong");
		jbXoa = new JButton("Xoa");
		jbSua = new JButton("Sua");
		jbLuu = new JButton("Luu");
		jlMatim = new JLabel("Tim Theo ma sach: ");
		String[] ma = { "A001", "J002", "H003" };
		jcbMatim = new JComboBox(ma);

		bt2 = Box.createHorizontalBox();
		
		bt2.setPreferredSize(new Dimension(700, 10));
		bt2.add(jbThem = new JButton("Them"));
		bt2.add(jbXoarong);
		bt2.add(jbXoa);
		bt2.add(jbSua);
		bt2.add(jbLuu);
		bt2.add(jlMatim);
		bt2.add(jcbMatim);
		B_2.add(bt2);
		
		B_3 = Box.createVerticalBox();
		B_3.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach: "));
		
		String[] rowTitle = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");
		
		tableModel = new DefaultTableModel(rowTitle, 0);
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		
		bt1 = Box.createHorizontalBox();
		bt1.add(scroll);
		bt1.setPreferredSize(new Dimension(700, 330));
		
		B_3.add(bt1);
		
		
		

		add(B_1, BorderLayout.NORTH);
		add(B_2, BorderLayout.CENTER);
		add(B_3, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
