package jsProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Sign extends JFrame {

	private JPanel contentPane;
	private Login join;
	private JTextField tfName;
	private JTextField tfId;
	private JPasswordField tfPwd;
	private JPasswordField tfPwdck;
	private JTextField tfEmail;
	private JTextField tfHp2;
	private JTextField tfHp3;
	private JTextField tfAdrsnum;
	private JTextField tfAdrsnum2;
	private JTextField tfAdrs;
	private JTextField tfDadrs;
	private Vector<String> year,mon,day,hpnum,emailsite;
	private JComboBox comboMon;
	private JComboBox comboDay;
	private JComboBox comboYear;
	private Calendar oCalendar;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnCheck;
	private JRadioButton rdbtnMan;
	private JRadioButton rdbtnWoman;
	private JComboBox comboHp;
	private JButton btnJoin;
	private MemberDTO dto;
	private MemberDAO dao;
	private boolean brepetitechk=false;
	private boolean checkId;
	private String dayck,monck,yearck,number,sex,emailst;
	private JComboBox cbEmail;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Sign frame = new Sign();
//					frame.setVisible(true);
//					frame.setResizable(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Sign(Login join){
		this();
		this.join=join;
		
	}
	
	public Sign() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(31, 44, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(109, 41, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(31, 75, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfId = new JTextField();
		tfId.setBounds(109, 72, 116, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호");
		lblNewLabel_3.setBounds(31, 106, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfPwd = new JPasswordField();
		tfPwd.setBounds(109, 103, 116, 21);
		contentPane.add(tfPwd);
		
		JLabel lblNewLabel_4 = new JLabel("비밀번호확인");
		lblNewLabel_4.setBounds(12, 138, 85, 15);
		contentPane.add(lblNewLabel_4);
		
		tfPwdck = new JPasswordField();
		tfPwdck.setToolTipText("");
		tfPwdck.setBounds(109, 135, 116, 21);
		contentPane.add(tfPwdck);
		
		
		btnCheck = new JButton("중복 체크");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao =new MemberDAO();
				boolean b =dao.useridck(tfId.getText());
				if(b==true){
					JOptionPane.showMessageDialog(Sign.this, "이미 사용중인 아이디입니다.");
					checkId=false;
				} else {
					JOptionPane.showMessageDialog(Sign.this, "사용 가능한 아이디입니다.");
					checkId=true;
				}			
			}
		});

		btnCheck.setBounds(237, 71, 116, 23);
		contentPane.add(btnCheck);
		
		JLabel lblNewLabel_2 = new JLabel("생년월일");
		lblNewLabel_2.setBounds(31, 173, 57, 15);
		contentPane.add(lblNewLabel_2);
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
		comboYear.setBounds(109, 170, 61, 21);
		contentPane.add(comboYear);
		comboYear.setSelectedIndex(26);
		
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
		comboMon.setBounds(182, 170, 57, 21);
		contentPane.add(comboMon);
		
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
		comboDay.setBounds(251, 170, 57, 21);
		contentPane.add(comboDay);
		
		JLabel lblNewLabel_5 = new JLabel("성별");
		lblNewLabel_5.setBounds(31, 208, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		rdbtnMan = new JRadioButton("남");
		buttonGroup_1.add(rdbtnMan);
		rdbtnMan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sex="남";
				}
			}
		});
		rdbtnMan.setBounds(104, 204, 43, 23);
		contentPane.add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton("여");
		buttonGroup_1.add(rdbtnWoman);
		rdbtnWoman.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {					
					sex="여";
				}
			}
		});
		rdbtnWoman.setBounds(151, 204, 43, 23);
		contentPane.add(rdbtnWoman);
		
		JLabel lblNewLabel_6 = new JLabel("이메일");
		lblNewLabel_6.setBounds(31, 241, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(109, 238, 121, 21);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("휴대폰번호");
		lblNewLabel_7.setBounds(31, 278, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		
		hpnum=new Vector<String>();
		hpnum.add("선택");
		hpnum.add("010");
		hpnum.add("011");
		hpnum.add("016");
		hpnum.add("019");
			
		comboHp = new JComboBox();
		comboHp.setModel(new DefaultComboBoxModel
				(hpnum.toArray(new String[hpnum.size()])));
		comboHp.setBounds(109, 275, 61, 21);
		comboHp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object d = e.getItem();
				number=d+"-";
			    }		
		});

		contentPane.add(comboHp);
		
		JLabel lblNewLabel_8 = new JLabel("-");
		lblNewLabel_8.setBounds(173, 278, 12, 15);
		contentPane.add(lblNewLabel_8);
		
		tfHp2 = new JTextField();
		tfHp2.setBounds(182, 275, 57, 21);
		contentPane.add(tfHp2);
		tfHp2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("-");
		lblNewLabel_9.setBounds(242, 278, 12, 15);
		contentPane.add(lblNewLabel_9);
		
		tfHp3 = new JTextField();
		tfHp3.setBounds(251, 275, 57, 21);
		contentPane.add(tfHp3);
		tfHp3.setColumns(10);
		
		JLabel label = new JLabel("우편번호");
		label.setBounds(31, 312, 57, 15);
		contentPane.add(label);
		
		tfAdrsnum = new JTextField();
		tfAdrsnum.setBounds(109, 309, 85, 21);
		contentPane.add(tfAdrsnum);
		tfAdrsnum.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("-");
		lblNewLabel_10.setBounds(197, 312, 12, 15);
		contentPane.add(lblNewLabel_10);
		
		tfAdrsnum2 = new JTextField();
		tfAdrsnum2.setBounds(206, 309, 90, 21);
		contentPane.add(tfAdrsnum2);
		tfAdrsnum2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("주소");
		lblNewLabel_11.setBounds(31, 347, 57, 15);
		contentPane.add(lblNewLabel_11);
		
		tfAdrs = new JTextField();
		tfAdrs.setBounds(109, 344, 333, 21);
		contentPane.add(tfAdrs);
		tfAdrs.setColumns(10);
		
		JLabel label_1 = new JLabel("상세주소");
		label_1.setBounds(31, 375, 57, 15);
		contentPane.add(label_1);
		
		tfDadrs = new JTextField();
		tfDadrs.setBounds(109, 372, 333, 21);
		contentPane.add(tfDadrs);
		tfDadrs.setColumns(10);

		btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String name=tfName.getText();
					String userid=tfId.getText();
					String password=String.valueOf(tfPwd.getPassword());
					String passwordck=String.valueOf(tfPwdck.getPassword());
					String birthday=yearck+monck+dayck;
					String sx=sex;
					String email=tfEmail.getText()+emailst;
					String hp=number+tfHp2.getText()+"-"+tfHp3.getText();;
					String adrsnum=tfAdrsnum.getText()+"-"+tfAdrsnum2.getText();
					String adrs=tfAdrs.getText();
					String dadrs=tfDadrs.getText();
					MemberDTO dto=new MemberDTO
							(name, userid, password, 
									passwordck, birthday, sx, email, hp, adrsnum, adrs, dadrs);
					MemberDAO dao=new MemberDAO();
					int result=dao.insertMember(dto);
					System.out.println(result);
					if(checkId!=true) {
						JOptionPane.showMessageDialog(Sign.this, "아이디 중복체크를 확인해주세요.");
					} else if (password.length() < 8) {
						JOptionPane.showMessageDialog(Sign.this, "비밀번호 문자+숫자로 8자 이상 입력해주세요.");
			        } else if (!password.equals(String.valueOf(tfPwdck.getPassword())) ) {
				    JOptionPane.showMessageDialog(Sign.this, "비밀번호를 확인해주세요.");	
			        } else if(tfId.getText().equals("")) {
				    	  JOptionPane.showMessageDialog(Sign.this, "아이디를 입력하세요.");				      
			        } else if(sx==null) {
						JOptionPane.showMessageDialog(Sign.this, "성별을 입력하세요.");
					} 
			        else {
						if(result==1) {
							JOptionPane.showMessageDialog(Sign.this, "회원가입을 축하합니다.");
							dispose();									
					}			      
			   	}  				
			}
	   });
		btnJoin.setBounds(194, 400, 114, 23);
		contentPane.add(btnJoin);
		
		emailsite =new Vector<String>();
		emailsite.add("========선택========");
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
		cbEmail.setBounds(237, 238, 164, 21);
		contentPane.add(cbEmail);
	}
}
