package jsProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberSave extends JFrame {

	private JPanel contentPane;
	private ManagerDms frm;
	private JTextField tfCstnum;
	private JTextField tfName;
	private JTextField tfId;
	private JTextField tfPwd;
	private JTextField tfPwdck;
	private JTextField tfDadrs;
	private JTextField tfAdrsnum;
	private JTextField tfEmail;
	private JTextField tfAdrs;
	private JTextField tfHp2;
	private JTextField tfHp3;
	private JTextField tfAdrsnum2;
	private JButton btnSave;
	private JComboBox comboYear;
	private JComboBox comboMon;
	private JComboBox comboDay;
	private Calendar oCalendar;
	private JRadioButton rdbtnWoman;
	private JRadioButton rdbtnMan;
	private JComboBox comboHp;
	private JComboBox cbEmail;
	private Vector<String> year,mon,day,hpnum,emailsite;
	private MemberDTO dto;
	private MemberDAO dao;
	private boolean brepetitechk=false;
	private boolean checkId;
	private String dayck,monck,yearck,number,sex,emailst;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberSave frame = new MemberSave();
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
	public MemberSave(ManagerDms frm){
		this();
		this.frm=frm;
	}
	
	public MemberSave() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 453);
		contentPane = new JPanel();
		ImagePanel memberSavePanel= new ImagePanel(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\membersave.jpg").getImage());
		contentPane.setSize(new Dimension(461, 496));
		contentPane.setPreferredSize(memberSavePanel.getDim());
		contentPane.add(memberSavePanel);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("no");
		lblNewLabel.setBounds(12, 45, 23, 15);
		memberSavePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(12, 73, 57, 15);
		memberSavePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setBounds(12, 101, 39, 15);
		memberSavePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호");
		lblNewLabel_3.setBounds(12, 131, 57, 15);
		memberSavePanel.add(lblNewLabel_3);
		
		tfCstnum = new JTextField();
		tfCstnum.setEditable(false);
		tfCstnum.setBounds(35, 42, 34, 21);
		memberSavePanel.add(tfCstnum);
		tfCstnum.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(53, 70, 67, 21);
		memberSavePanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("성별");
		lblNewLabel_4.setBounds(79, 45, 34, 15);
		memberSavePanel.add(lblNewLabel_4);
		
		tfId = new JTextField();
		tfId.setBounds(53, 98, 67, 21);
		memberSavePanel.add(tfId);
		tfId.setColumns(10);
		
		tfPwd = new JTextField();
		tfPwd.setBounds(88, 128, 121, 21);
		memberSavePanel.add(tfPwd);
		tfPwd.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("비번확인");
		lblNewLabel_5.setBounds(12, 162, 57, 15);
		memberSavePanel.add(lblNewLabel_5);
		
		tfPwdck = new JTextField();
		tfPwdck.setBounds(88, 159, 121, 21);
		memberSavePanel.add(tfPwdck);
		tfPwdck.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("생년월일");
		lblNewLabel_6.setBounds(223, 73, 57, 15);
		memberSavePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("핸드폰");
		lblNewLabel_7.setBounds(223, 101, 57, 15);
		memberSavePanel.add(lblNewLabel_7);
		
		tfDadrs = new JTextField();
		tfDadrs.setBounds(582, 159, 86, 21);
		memberSavePanel.add(tfDadrs);
		tfDadrs.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("이메일");
		lblNewLabel_8.setBounds(223, 45, 45, 15);
		memberSavePanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("우편번호");
		lblNewLabel_9.setBounds(223, 131, 57, 15);
		memberSavePanel.add(lblNewLabel_9);
		
		tfAdrsnum = new JTextField();
		tfAdrsnum.setBounds(281, 128, 97, 21);
		memberSavePanel.add(tfAdrsnum);
		tfAdrsnum.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("주소");
		lblNewLabel_10.setBounds(225, 162, 34, 15);
		memberSavePanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("상세주소");
		lblNewLabel_11.setBounds(528, 162, 57, 15);
		memberSavePanel.add(lblNewLabel_11);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(281, 42, 112, 21);
		memberSavePanel.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfAdrs = new JTextField();
		tfAdrs.setBounds(279, 159, 247, 21);
		memberSavePanel.add(tfAdrs);
		tfAdrs.setColumns(10);
		
		
		rdbtnMan = new JRadioButton("남");
		buttonGroup_1.add(rdbtnMan);
		rdbtnMan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sex="남";					
				}
			}
		});	
		rdbtnMan.setBounds(108, 41, 39, 23);
		memberSavePanel.add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton("여");
		buttonGroup_1.add(rdbtnWoman);
		rdbtnWoman.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {					
					sex="여";
				}
			}
		});
		rdbtnWoman.setBounds(170, 41, 39, 23);
		memberSavePanel.add(rdbtnWoman);
		
		oCalendar = Calendar.getInstance( );
		int toyear = oCalendar.get(Calendar.YEAR);
		year =new Vector<String>();
		for(int i = toyear; i>= toyear -100; i--){
			   year.add(String.valueOf(i));
			  }
		
		comboYear = new JComboBox();
		comboYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object a = e.getItem();
				yearck=a+"년";
			}
		});
		comboYear.setModel(new DefaultComboBoxModel
				(year.toArray(new String[year.size()])));
		comboYear.setSelectedItem(String.valueOf(toyear));		
		comboYear.setBounds(282, 70, 57, 21);
		memberSavePanel.add(comboYear);
		comboYear.setSelectedIndex(25);
		
		mon=new Vector<String>();
		mon.add("선택");
		for(int i=1; i<=12; i++) {
			mon.add(String.valueOf(i));
		}
		comboMon = new JComboBox();
		comboMon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object b = e.getItem();
				monck=b+"월";
			}
		});
		comboMon.setModel(new DefaultComboBoxModel
				(mon.toArray(new String[mon.size()])));
		comboYear.setSelectedItem(String.valueOf(mon));		
		comboMon.setBounds(363, 70, 60, 21);
		memberSavePanel.add(comboMon);
		
		day=new Vector<String>();
		day.add("선택");
		
		for(int i=1; i<=31; i++) {
			day.add(String.valueOf(i));
		}
		comboDay = new JComboBox();
		comboDay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object c = e.getItem();
				dayck= c+"일";
			}
		});			 
		comboDay.setModel(new DefaultComboBoxModel
				(day.toArray(new String[day.size()])));
		comboYear.setSelectedItem(String.valueOf(day));
		comboDay.setBounds(445, 70, 57, 21);
		memberSavePanel.add(comboDay);
		
		emailsite =new Vector<String>();
		emailsite.add("=====선택=====");
		emailsite.add("@naver.com");
		emailsite.add("@gmail.com");
		emailsite.add("@hanmail.net");
		emailsite.add("@nate.com");
		emailsite.add("@yahoo.com");
		emailsite.add("@lycos.com");
		cbEmail = new JComboBox();
		cbEmail.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object w = e.getItem();
				emailst=w+"";
			}
		});
		cbEmail.setModel(new DefaultComboBoxModel
				(emailsite.toArray(new String[emailsite.size()])));
		cbEmail.setBounds(405, 42, 121, 21);
		memberSavePanel.add(cbEmail);
		
		hpnum=new Vector<String>();
		hpnum.add("선택");
		hpnum.add("010");
		hpnum.add("011");
		hpnum.add("016");
		hpnum.add("019");
		comboHp = new JComboBox();
		comboHp.setModel(new DefaultComboBoxModel
				(hpnum.toArray(new String[hpnum.size()])));
		comboHp.setBounds(282, 98, 58, 21);
		comboHp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object d = e.getItem();
				number=d+"-";
			    }		
		});
		memberSavePanel.add(comboHp);
		
		tfHp2 = new JTextField();
		tfHp2.setBounds(363, 98, 60, 21);
		memberSavePanel.add(tfHp2);
		
		tfHp2.setColumns(10);
		
		tfHp3 = new JTextField();
		tfHp3.setBounds(445, 98, 57, 21);
		memberSavePanel.add(tfHp3);
		tfHp3.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(347, 101, 13, 15);
		memberSavePanel.add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("굴림", Font.BOLD, 12));
		label_1.setBounds(431, 101, 13, 15);
		memberSavePanel.add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setFont(new Font("굴림", Font.BOLD, 12));
		label_2.setBounds(385, 131, 13, 15);
		memberSavePanel.add(label_2);
		
		tfAdrsnum2 = new JTextField();
		tfAdrsnum2.setBounds(399, 128, 103, 21);
		memberSavePanel.add(tfAdrsnum2);
		tfAdrsnum2.setColumns(10);
		
		btnNewButton = new JButton("중복체크");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao =new MemberDAO();
				boolean b =dao.useridck(tfId.getText());
				if(b==true){
					JOptionPane.showMessageDialog(MemberSave.this, "이미 사용중인 아이디입니다.");
					checkId=false;
				} else {
					JOptionPane.showMessageDialog(MemberSave.this, "사용 가능한 아이디입니다.");
					checkId=true;
				}			
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(122, 98, 87, 22);
		memberSavePanel.add(btnNewButton);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfName.getText();
				String userid=tfId.getText();
				String password=tfPwd.getText();
				String passwordck=tfPwdck.getText();
				String birthday=yearck+monck+dayck;
				String sx=sex;
				String email=tfEmail.getText()+emailst;
				String hp=number+tfHp2.getText()+"-"+tfHp3.getText();;
				String adrsnum=tfAdrsnum.getText()+"-"+tfAdrsnum2.getText();
				String adrs=tfAdrs.getText();
				String dadrs=tfDadrs.getText();
				MemberDTO dto=new MemberDTO
						(name, userid, password, passwordck, birthday, sx, email, hp, adrsnum, adrs, dadrs);
				MemberDAO dao=new MemberDAO();
				int result=dao.insertMember(dto);
				System.out.println(result);
				if(checkId!=true) {
					JOptionPane.showMessageDialog(MemberSave.this, "아이디 중복체크를 확인해주세요.");
				} else if (password.length() < 8) {
					JOptionPane.showMessageDialog(MemberSave.this, "비밀번호 문자+숫자로 8자 이상 입력해주세요.");
				} else if (!password.equals(String.valueOf(tfPwdck.getText())) ) {
					JOptionPane.showMessageDialog(MemberSave.this, "비밀번호를 확인해주세요.");	
				} else if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(MemberSave.this, "아이디를 입력하세요.");				      
				} else if(sx==null) {
					JOptionPane.showMessageDialog(MemberSave.this, "성별을 입력하세요.");
				}
				else {
					if(result==1) {
						JOptionPane.showMessageDialog(MemberSave.this, "회원이 추가되었습니다.");
						frm.refreshTable();
						dispose();									
					}			      
				}  								
			}
		});
		btnSave.setFont(new Font("굴림", Font.BOLD, 20));
		btnSave.setBounds(547, 45, 121, 82);
		memberSavePanel.add(btnSave);
	}
}
