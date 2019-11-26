package jsProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserid;
	private JPasswordField tfPassword;
	private JButton btnNew;
	private JButton btnmanager;
	private JButton btnLogin;
	private Sign join;
	private ImagePanel loginPanel;
	private MemberDTO dto;
	private MemberDAO dao;
	private Vector<String> choice;
	private JComboBox cbmanager;
	private boolean manager;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Login() {
		contentPane = new JPanel();
		setBounds(310, 100, 1300, 866);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel loginPanel= new ImagePanel(new ImageIcon
				("D:\\work_java\\javaProject\\src\\JsProject\\fastfood.jpg").getImage());
		contentPane.setSize(new Dimension(461, 496));
		contentPane.setPreferredSize(loginPanel.getDim());
		contentPane.add(loginPanel);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tfUserid = new JTextField();
		tfUserid.setFont(new Font("굴림", Font.BOLD, 26));
		tfUserid.setBounds(1007, 484, 221, 50);
		loginPanel.add(tfUserid);
		tfUserid.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("굴림", Font.BOLD, 24));
		tfPassword.setBounds(1007, 566, 221, 44);
		loginPanel.add(tfPassword);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(915, 486, 80, 44);
		loginPanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 28));
		lblPassword.setBounds(841, 565, 154, 44);
		loginPanel.add(lblPassword);
		
		btnNew = new JButton("회원가입");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign join=new Sign(Login.this);
				join.setVisible(true); 
				join.setResizable(false);
				join.setLocation(600,300);			
			}
		});
		btnNew.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\new.jpg"));
		btnNew.setPressedIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\new1.jpg"));
		btnNew.setBounds(1010, 717, 218, 38);
		loginPanel.add(btnNew);
	
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid=tfUserid.getText();
				String password=String.valueOf(tfPassword.getPassword());
			    Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					conn=DB.dbConn();
					String sql="SELECT userid, password FROM jsmember "
							+" WHERE userid=? AND password=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, password);
					rs=pstmt.executeQuery();
				    if(rs.next()){
						JOptionPane.showMessageDialog
						(Login.this, userid+"님 로그인 되셨습니다.");
						JsFastFoodSell join= new JsFastFoodSell(Login.this);
						join.setVisible(true);
						join.setResizable(false);
						dispose();
   					}else {
						JOptionPane.showMessageDialog(
								Login.this,"회원 아이디와 비밀번호를 확인해주세요.");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();	
				}finally {
					try {
						if(rs!=null) rs.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					} try {
						if(pstmt!=null) pstmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					} try {
						if(conn!=null) conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}//end finally				
			}
		});
		btnLogin.setBounds(1007, 620, 218, 38);
		loginPanel.add(btnLogin);
		btnLogin.setBorder(null);
		btnLogin.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\login3.jpg"));
		btnLogin.setPressedIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\login2.jpg"));
		
		btnmanager = new JButton("");
		btnmanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String managerid=tfUserid.getText();
				String managerpwd=String.valueOf(tfPassword.getPassword());
			    Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					conn=DB.dbConn();
					String sql="SELECT managerid, managerpwd FROM manager "
							+" WHERE managerid=? AND managerpwd=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, managerid);
					pstmt.setString(2, managerpwd);

					rs=pstmt.executeQuery();
				    if(rs.next()){
						JOptionPane.showMessageDialog(
								Login.this,"관리자로 로그인 되었습니다");
						ManagerDms join= new ManagerDms(Login.this);
						join.setVisible(true);
						join.setResizable(false);
						dispose();
   					}else {
						JOptionPane.showMessageDialog(
								Login.this,"관리자아이디와 비밀번호를 확인해주세요.");
					}
				} catch (Exception e2) {
					e2.printStackTrace();	
				}finally {
					try {
						if(rs!=null) rs.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					} try {
						if(pstmt!=null) pstmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					} try {
						if(conn!=null) conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}//end finally								
			}
		});
		btnmanager.setBounds(1007, 668, 218, 38);
		loginPanel.add(btnmanager);
		btnmanager.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\manager.jpg"));
		btnmanager.setPressedIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\manager1.jpg"));
		
		
		
	}
}
