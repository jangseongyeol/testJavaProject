package jsProject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ManagerDms extends JFrame {

	private JPanel contentPane;
	private Login join;
	private MemberDAO dao;
	private Vector cols;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerDms frame = new ManagerDms();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
	/**
	 * Create the frame.
	 */
	public ManagerDms(Login join){
		this();
		this.join=join;
		
	}
	
	
	public ManagerDms() {

			dao=new MemberDAO();
			cols=new Vector();
			cols.add("no");
			cols.add("이름");
			cols.add("아이디");
			cols.add("비밀번호");
			cols.add("비밀번호확인");
			cols.add("생일");
			cols.add("성별");
			cols.add("이메일");
			cols.add("핸드폰");
			cols.add("우편번호");
			cols.add("주소");
			cols.add("상세주소");
			
		
		contentPane = new JPanel();
		setBounds(0, 200, 1900, 658);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel managerPanel= new ImagePanel(new ImageIcon("D:\\work_java\\Jsproject\\src\\JsProject\\ram1.jpg").getImage());
		contentPane.setSize(new Dimension(461, 496));
		contentPane.setPreferredSize(managerPanel.getDim());
		contentPane.add(managerPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(780, 119, 1103, 500);
		managerPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnEdit = new JButton("편집");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx=table.getSelectedRow();
				if(idx==-1) {
					JOptionPane.showMessageDialog
					(ManagerDms.this, "수정할 회원을 선택하세요.");
				    return;
				} else {
					int cstnum=
						     Integer.valueOf(table.getValueAt(idx, 0)+"");
					

				ManagerEdit frm=
						new ManagerEdit (ManagerDms.this, cstnum);
						frm.setVisible(true);
				        frm.setLocation(550,100);
				        frm.setResizable(false);
				}
			}
		});
		btnEdit.setFont(new Font("굴림", Font.BOLD, 18));
		btnEdit.setBounds(1746, 72, 125, 35);
		managerPanel.add(btnEdit);
		
		JButton btnNewButton = new JButton("회원추가");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberSave frm=new MemberSave(ManagerDms.this);
				frm.setVisible(true);
				frm.setResizable(false);
				frm.setLocation(600, 200);
			}
		});
		btnNewButton.setBounds(1601, 72, 131, 35);
		managerPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("관리자 편집");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerSave frm=new ManagerSave(ManagerDms.this);
				frm.setVisible(true);
				frm.setResizable(false);
				frm.setLocation(600,200);		
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(1407, 72, 182, 37);
		managerPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("메뉴관리");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JsFastFoodMenu join =new JsFastFoodMenu(ManagerDms.this);
				join.setVisible(true);
				join.setResizable(false);
				join.setLocation(600,200);
				
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 16));
		btnNewButton_2.setBounds(1258, 72, 137, 37);
		managerPanel.add(btnNewButton_2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		refreshTable();
	}
	
	public void refreshTable() {
		DefaultTableModel model= new 
				DefaultTableModel(dao.listMember(),cols);
		table.setModel(model);
		sort();
	}
	
	  public void sort() {
	      //테이블 컬럼 폭 설정
	      final TableColumnModel columnModel = table.getColumnModel();
	      for(int column = 0; column < table.getColumnCount(); column++) {
	         int width = 10;
	         for(int row = 0; row<table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1,width);
	         }
	         columnModel.getColumn(column).setPreferredWidth(width);
	      }      
	  }
}
