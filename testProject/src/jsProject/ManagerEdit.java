package jsProject;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ManagerEdit extends JFrame {

	private JPanel contentPane;
	
	private MemberDAO dao;
	private MemberDTO dto;
	private int cstnum;
	private JTextField tfCstnum;
	private JTextField tfName;
	private JTextField tfUserid;
	private JTextField tfEmail;
	private JTextField tfAdrsnum;
	private JTextField tfPwd;
	private JTextField tfPwdck;
	private JTextField tfBirthday;
	private JTextField tfHp;
	private JTextField tfAdrs;
	private JTextField tfDadrs;
	private JTextField tfSex;
	private ManagerDms parent;
	private JRadioButton rdbtnMan;
	private JRadioButton rdbtnWoman;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerEdit frame = new ManagerEdit();
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
	public ManagerEdit(ManagerDms parent, int cstnum) {
		
		this.parent= parent;
		this.cstnum=cstnum;
		
		contentPane = new JPanel();
		setBounds(500, 200, 900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImagePanel managerPanel= new ImagePanel(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\manageredit.jpg").getImage());
		contentPane.setSize(new Dimension(461, 496));
		contentPane.setPreferredSize(managerPanel.getDim());
		contentPane.add(managerPanel);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("고객번호");
		lblNewLabel.setBounds(33, 27, 57, 15);
		managerPanel.add(lblNewLabel);
		
		tfCstnum = new JTextField();
		tfCstnum.setEditable(false);
		tfCstnum.setBounds(102, 24, 38, 21);
		managerPanel.add(tfCstnum);
		tfCstnum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(33, 65, 57, 15);
		managerPanel.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(102, 62, 116, 21);
		managerPanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setBounds(33, 107, 57, 15);
		managerPanel.add(lblNewLabel_2);
		
		tfUserid = new JTextField();
		tfUserid.setBounds(102, 104, 116, 21);
		managerPanel.add(tfUserid);
		tfUserid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("우편번호");
		lblNewLabel_3.setBounds(427, 65, 57, 15);
		managerPanel.add(lblNewLabel_3);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(496, 24, 230, 21);
		managerPanel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("주소");
		lblNewLabel_4.setBounds(427, 107, 57, 15);
		managerPanel.add(lblNewLabel_4);
		
		tfAdrsnum = new JTextField();
		tfAdrsnum.setBounds(496, 62, 230, 21);
		managerPanel.add(tfAdrsnum);
		tfAdrsnum.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("비밀번호");
		lblNewLabel_5.setBounds(230, 27, 57, 15);
		managerPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("비번확인");
		lblNewLabel_6.setBounds(230, 65, 57, 15);
		managerPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("생년월일");
		lblNewLabel_7.setBounds(230, 107, 57, 15);
		managerPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("이메일");
		lblNewLabel_8.setBounds(427, 27, 57, 15);
		managerPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("핸드폰");
		lblNewLabel_9.setBounds(230, 143, 57, 15);
		managerPanel.add(lblNewLabel_9);
		
		tfPwd = new JTextField();
		tfPwd.setBounds(299, 24, 116, 21);
		managerPanel.add(tfPwd);
		tfPwd.setColumns(10);
		
		tfPwdck = new JTextField();
		tfPwdck.setBounds(299, 62, 116, 21);
		managerPanel.add(tfPwdck);
		tfPwdck.setColumns(10);
		
		tfBirthday = new JTextField();
		tfBirthday.setBounds(299, 104, 116, 21);
		managerPanel.add(tfBirthday);
		tfBirthday.setColumns(10);
		
		tfHp = new JTextField();
		tfHp.setBounds(299, 140, 116, 21);
		managerPanel.add(tfHp);
		tfHp.setColumns(10);
		
		tfAdrs = new JTextField();
		tfAdrs.setBounds(496, 104, 230, 21);
		managerPanel.add(tfAdrs);
		tfAdrs.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("상세주소");
		lblNewLabel_10.setBounds(427, 143, 57, 15);
		managerPanel.add(lblNewLabel_10);
		
		tfDadrs = new JTextField();
		tfDadrs.setBounds(496, 140, 230, 21);
		managerPanel.add(tfDadrs);
		tfDadrs.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("성별");
		lblNewLabel_11.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_11.setBounds(150, 27, 32, 15);
		managerPanel.add(lblNewLabel_11);
		
		tfSex = new JTextField();
		tfSex.setBounds(180, 24, 38, 21);
		managerPanel.add(tfSex);
		tfSex.setColumns(10);
		
		dao=new MemberDAO();
		dto=dao.viewMember(cstnum);
		tfCstnum.setText(dto.getCstnum()+"");
		tfName.setText(dto.getName());
		tfUserid.setText(dto.getUserid());
		tfPwd.setText(dto.getPassword());
		tfPwdck.setText(dto.getPasswordck());
		tfBirthday.setText(dto.getBirthday());
		tfSex.setText(dto.getSx());
		tfEmail.setText(dto.getEmail());
		tfHp.setText(dto.getHp());
		tfAdrsnum.setText(dto.getAdrsnum());
		tfAdrs.setText(dto.getAdrs());
		tfDadrs.setText(dto.getDadrs());


		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cstnum=Integer.valueOf(tfCstnum.getText()+"");
				String name=tfName.getText();
				String userid=tfUserid.getText();
				String password=tfPwd.getText();
				String passwordck=tfPwdck.getText();
				String birthday=tfBirthday.getText();
				String sx=tfSex.getText();
				String email=tfEmail.getText();
				String hp=tfHp.getText();
				String adrsnum=tfAdrsnum.getText();
				String adrs=tfAdrs.getText();
				String dadrs=tfDadrs.getText();
				MemberDTO dto=new MemberDTO(cstnum, 
						name, userid, password, passwordck, 
						birthday, sx, email, hp, adrsnum, adrs, dadrs);
				int result=dao.updateMember(dto);
				if(result==1) {
					JOptionPane.showMessageDialog
					(ManagerEdit.this, "수정되었습니다.");
					parent.refreshTable();
					dispose();
					
				} 
			}
		});
		btnUpdate.setBounds(748, 23, 125, 57);
		managerPanel.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cstnum = Integer.parseInt(tfCstnum.getText());
				int result=0;
				int response=JOptionPane.showConfirmDialog(ManagerEdit.this, "삭제하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					result=dao.deleteMember(cstnum);
				}
				if(result==1) {
					JOptionPane.showMessageDialog(ManagerEdit.this, "삭제되었습니다.");
					parent.refreshTable();
					dispose();
				}
			}
		});
		btnDelete.setBounds(748, 103, 125, 57);
		managerPanel.add(btnDelete);
		
		
		
		rdbtnMan = new JRadioButton("남");
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(29, 143, 121, 23);
		managerPanel.add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton("여");
		buttonGroup.add(rdbtnWoman);
		rdbtnWoman.setBounds(29, 182, 121, 23);
		managerPanel.add(rdbtnWoman);
	
	}
}
