package Bai3_Tuan1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class View extends JFrame implements ActionListener {
	private JPanel jp1, jp2, jp3, jp4, jpNhapa, jpNhapb, jpPheptinh, jpKq, jpc, jbot1, jbot2, jbot3;
	private JLabel jlTitle, jla, jlb, jlkq;
	private JButton jbGiai, jbXoa, jbThoat;
	private JTextField jtfa, jtfb, jtfkq;
	private JRadioButton jrbCong, jrbTru, jrbNhan, jrbChia;
	
	

	public View() {
		setTitle("Cong - Tru - Nhan - Chia");
		setSize(450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		jp1 = new JPanel();
		
		jlTitle = new JLabel("Cong Tru Nhan Chia");
		Font fn = new Font("Arial", Font.BOLD, 30);
		jlTitle.setFont(fn);
		
		jp1.add(jlTitle);
		
		
		
		jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
		jp2.add(Box.createVerticalStrut(10));
		
//		jp2.add(Box.createVerticalBox());
		jbGiai = new JButton("Giai");
		jbGiai.addActionListener(this);
		
		jbXoa = new JButton("Xoa");
		jbXoa.addActionListener(this);
		
		jbThoat = new JButton("Thoat");
		jbThoat.addActionListener(this);
		
		
		jp2.add(jbGiai);
		jp2.add(Box.createVerticalStrut(10));
		jp2.add(jbXoa);
		jp2.add(Box.createVerticalStrut(10));
		jp2.add(jbThoat);
		
		jp3 = new JPanel();
		jp3.setBorder(BorderFactory.createTitledBorder("Tinh Toan"));
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
		
		jpNhapa = new JPanel();
		jla = new JLabel("Nhap a:");
		jpNhapa.add(jla);
		jtfa = new JTextField(15);
		jpNhapa.add(jtfa);
		
		jpNhapb = new JPanel();
		jlb = new JLabel("Nhap b:");
		jpNhapb.add(jlb);
		jtfb = new JTextField(15);
		jpNhapb.add(jtfb);
		
		jpc = new JPanel();
		jpPheptinh = new JPanel();
		jpPheptinh.setBorder(BorderFactory.createTitledBorder("Phet Tinh"));
		
		jrbCong = new JRadioButton("Cong");
		jrbCong.setSelected(true);
		jrbTru = new JRadioButton("Tru");
		jrbNhan = new JRadioButton("Nhan");
		jrbChia = new JRadioButton("Chia");
		
		ButtonGroup group = new ButtonGroup();
		group.add(jrbCong);
		group.add(jrbTru);
		group.add(jrbNhan);
		group.add(jrbChia);
		
		jpPheptinh.setLayout(new GridLayout(2, 2));
		jpPheptinh.add(jrbCong);
		jpPheptinh.add(jrbTru);
		jpPheptinh.add(jrbNhan);
		jpPheptinh.add(jrbChia);
		
		jpc.add(jpPheptinh);
		
		jpKq = new JPanel();
		jlkq = new JLabel("Ket qua:");
		jpKq.add(jlkq);
		jtfkq = new JTextField(15);
		jtfkq.setEditable(false);
		jpKq.add(jtfkq);
		
		jp3.add(jpNhapa);
		jp3.add(jpNhapb);
		jp3.add(jpc);
		jp3.add(jpKq);
		
		
		jp4 = new JPanel();
		jp4.setBackground(Color.PINK);
		
		jbot1 =new JPanel();
		jbot1.setBackground(Color.blue);
		jbot2 =new JPanel();
		jbot2.setBackground(Color.red);
		jbot3 =new JPanel();
		jbot3.setBackground(Color.yellow);
		
		jp4.add(jbot1);
		jp4.add(jbot2);
		jp4.add(jbot3);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.WEST);
		add(jp3, BorderLayout.CENTER);
		add(jp4, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int a = 0, b = 0, kq;
		String s1, s2;
		s1 = jtfa.getText();
		s2 = jtfb.getText();
		
		if(o.equals(jbGiai)) {
			if(s1.equals("") || s2.equals("")) {
				JOptionPane.showMessageDialog(this, "Giá Trị Không được để trống");
			}else {
				try {
					a = Integer.parseInt(s1);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(this, "Nhập Sai định dạng");
					jtfa.selectAll();
					jtfa.requestFocus();
				}
				
				try {
					b = Integer.parseInt(s2);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this, "Nhập Sai định dạng");
					jtfb.selectAll();
					jtfb.requestFocus();
				}
				
				if(jrbCong.isSelected()) {
					kq = a + b;
				}else if(jrbTru.isSelected()) {
					kq = a - b;
				}else if (jrbNhan.isSelected()) {
					kq = a * b;
				}else {
					kq = a / b;
				}
				jtfkq.setText("" + kq);
			}
			
			
		}else if(o.equals(jbXoa)) {
			jtfa.setText("");
			jtfb.setText("");
			jtfkq.setText("");
			jrbCong.setSelected(true);
		}else{
			System.exit(0);
		}

	}

}
