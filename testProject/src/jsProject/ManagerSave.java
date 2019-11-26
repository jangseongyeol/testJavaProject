package jsProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerSave extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfManagerId;
	private JTextField tfManagerPwd;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	private ManagerDTO dto;
	private ManagerDAO dao;
	private DefaultTableModel model;
	private Vector<String> col;
	private ManagerDms frm;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerSave frame = new ManagerSave();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ManagerSave(ManagerDms frm){
		this();
		this.frm=frm;
	}
	
	public ManagerSave() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 534);
		contentPane = new JPanel();
		ImagePanel ManagerSavePanel= new ImagePanel(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\managersave.jpg").getImage());
		contentPane.setSize(new Dimension(461, 496));
		contentPane.setPreferredSize(ManagerSavePanel.getDim());
		contentPane.add(ManagerSavePanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 309, 197);
		ManagerSavePanel.add(scrollPane);
		
		dao=new ManagerDAO();//dao 인스턴스 생성
		//제목 열을위한 벡터 생성
		col=new Vector<String>();
		col.add("관리자아이디");
		col.add("관리자 비밀번호");
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx=table.getSelectedRow();
				tfManagerId.setEditable(false);
				tfManagerId.setText(table.getValueAt(idx, 0)+"");
				tfManagerPwd.setText(table.getValueAt(idx, 1)+"");			
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("관리자 아이디");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(333, 11, 116, 25);
		ManagerSavePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("관리자 비밀번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(333, 65, 133, 25);
		ManagerSavePanel.add(lblNewLabel_1);
		
		tfManagerId = new JTextField();
		tfManagerId.setBounds(478, 13, 163, 24);
		ManagerSavePanel.add(tfManagerId);
		tfManagerId.setColumns(10);
		
		tfManagerPwd = new JTextField();
		tfManagerPwd.setBounds(478, 65, 163, 24);
		ManagerSavePanel.add(tfManagerPwd);
		tfManagerPwd.setColumns(10);
		
		btnSave = new JButton("추가");
		btnSave.setFont(new Font("굴림", Font.BOLD, 20));
		btnSave.setForeground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result=dao.insertManager(dto);
			    if (tfManagerId.getText().equals("")) {
					JOptionPane.showMessageDialog(ManagerSave.this, "아이디를 입력해주세요.");				
				} else if (tfManagerPwd.getText().equals("")) {
					JOptionPane.showMessageDialog(ManagerSave.this, "비밀번호를 입력해주세요.");	 
				}
				else { 
					if(result==1) {
						JOptionPane.showMessageDialog(ManagerSave.this, "관리자가 추가되었습니다.");
					    list();
						table.setModel(model);
						clear();					
					}
				}
			}
		});
		btnSave.setBounds(653, 10, 104, 80);
		ManagerSavePanel.add(btnSave);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 17));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result=dao.updateManager(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(ManagerSave.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(478, 110, 125, 47);
		ManagerSavePanel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String managerid=tfManagerId.getText();
				int result=0;
				int response=JOptionPane.showConfirmDialog(ManagerSave.this, "삭제하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					result=dao.deleteManager(managerid);				
				}
				if(result==1) {
					JOptionPane.showMessageDialog(ManagerSave.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();					
				}
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 17));
		btnDelete.setBounds(632, 110, 125, 47);
		ManagerSavePanel.add(btnDelete);
		setContentPane(contentPane);
		refreshTable();
	}
	
	public void input() {
		String managerid=tfManagerId.getText();
		String managerpwd=tfManagerPwd.getText();
		dto=new ManagerDTO(managerid, managerpwd);
	}//end input()	
	public void clear() {
		tfManagerId.setText("");
		tfManagerPwd.setText("");
		tfManagerId.requestFocus();
		tfManagerId.setEditable(true);
	}//end clear()	
	public void list() {
		model=new DefaultTableModel(dao.listManager(),col) {
			@Override
			public boolean isCellEditable(int row, int column) {	
				return false;
			}
		};
	}//end list()	
	public void refreshTable() {
		DefaultTableModel model=new DefaultTableModel(dao.listManager(),col);
	//테이블에 데이터 채워짐
		table.setModel(model);
	}
	
}
