package jsProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JsFastFoodSell extends JFrame {

	private JPanel contentPane;
	private JTextField tfMenu;
	private JButton btnBuger;
	private JButton btnHotdog;
	private JButton btnTacos; 
	private JButton btnPizzaS;
	private JButton btnCola;
	private JButton btnCoffee;
	private JButton btnIceCream;
	private JButton btnPotato;
	private JButton btnSet1;
	private JButton btnSet2;
	private JButton btnSet3;
	private JButton btnPizzaL;
	private JButton btnbuy;
	private JComboBox comboBox;
	private JButton btnChoice;
	private JButton btnLogout;
	private JsFastFoodDTO dto;
	private JsFastFoodDAO dao;	
	private JTextField tfPrice;
	private JTextField tfHambuger;
	private JTextField tfHambugerP;
	private JTextField tfHotdog;
	private JTextField tfHotdogP;
	private JTextField tfTacos;
	private JTextField tfPizzaS;
	private JTextField tfTacosP;
	private JTextField tfPizzaSP;
	private JTextField tfCola;
	private JTextField tfColaP;
	private JTextField tfCoffee;
	private JTextField tfCoffeeP;
	private JTextField tfIcecream;
	private JTextField tfIcecreamP;
	private JTextField tfPotato;
	private JTextField tfPotatoP;
	private JTextField tfSet1;
	private JTextField tfSet1P;
	private JTextField tfSet2;
	private JTextField tfSet2P;
	private JTextField tfSet3;
	private JTextField tfSet3P;
	private JTextField tfPizzaLage;
	private JTextField tfPizzaLageP;
	private Vector<String> num;	 
	private String menuname, combonum,a;
	private Login join;
	private double price, tot;
	private int amount;
	private JScrollPane scrollPane;
	private JTable table;
	private Vector col, list, items, cols;
	private JLabel lblMent;
	private JLabel lblNewLabel;
	private DefaultTableModel model1;
	private JButton btnNewButton;
	

	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JsFastFoodSell frame = new JsFastFoodSell();
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
	
	public JsFastFoodSell(Login join){
		this();
		this.join=join;
	}
	public JsFastFoodSell() {
		col=new Vector();
		col.add("메뉴");
		col.add("수량");
		col.add("가격");
		
		Vector items=new Vector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 981, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
						
		tfMenu = new JTextField();
		tfMenu.setEditable(false);
		tfMenu.setBounds(509, 504, 137, 30);
		tfMenu.setFont(new Font("굴림", Font.BOLD, 16));
		contentPane.add(tfMenu);
		tfMenu.setColumns(10);
		
		btnBuger = new JButton("");	
		btnBuger.setBounds(22, 10, 100, 100);
		btnBuger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfHambuger.getText();
				String price=tfHambugerP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnBuger.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\bigbuger.png"));
		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		tfPrice.setBounds(658, 504, 75, 30);
		tfPrice.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfHambuger = new JTextField();
		tfHambuger.setBounds(22, 122, 70, 21);
		tfHambuger.setFont(new Font("굴림", Font.BOLD, 12));
		tfHambuger.setEditable(false);
		contentPane.add(tfHambuger);
		tfHambuger.setColumns(10);
		
		tfHambugerP = new JTextField();
		tfHambugerP.setBounds(96, 122, 26, 21);
		tfHambugerP.setFont(new Font("굴림", Font.BOLD, 12));
		tfHambugerP.setEditable(false);
		contentPane.add(tfHambugerP);
		tfHambugerP.setColumns(10);
		contentPane.add(btnBuger);
		
		btnHotdog = new JButton("");
		btnHotdog.setBounds(148, 10, 97, 100);
		btnHotdog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfHotdog.getText();
				String price=tfHotdogP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnHotdog.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\hotdog.png"));
		contentPane.add(btnHotdog);
		
		btnTacos = new JButton("");
		btnTacos.setBounds(272, 10, 100, 100);
		btnTacos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfTacos.getText();
				String price=tfTacosP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnTacos.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\tacos.png"));
		contentPane.add(btnTacos);
		
		btnPizzaS = new JButton("");
		btnPizzaS.setBounds(397, 10, 100, 100);
		btnPizzaS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfPizzaS.getText();
				String price=tfPizzaSP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnPizzaS.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\pizza.png"));
		contentPane.add(btnPizzaS);
		
		btnCola = new JButton("");
		btnCola.setBounds(22, 153, 100, 100);
		btnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfCola.getText();
				String price=tfCoffeeP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnCola.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\cola.png"));
		contentPane.add(btnCola);
		
		btnCoffee = new JButton("");
		btnCoffee.setBounds(150, 153, 100, 100);
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfCoffee.getText();
				String price=tfCoffeeP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnCoffee.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\coffe.png"));
		contentPane.add(btnCoffee);
		
		btnIceCream = new JButton("");
		btnIceCream.setBounds(272, 153, 100, 100);
		btnIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfIcecream.getText();
				String price=tfIcecreamP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnIceCream.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\icecream.png"));
		contentPane.add(btnIceCream);
		
		btnPotato = new JButton("");
		btnPotato.setBounds(397, 153, 100, 100);
		btnPotato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfPotato.getText();
				String price=tfPotatoP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnPotato.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\potato.png"));
		contentPane.add(btnPotato);
		
		btnSet1 = new JButton("");
		btnSet1.setBounds(509, 10, 200, 200);
		btnSet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfSet1.getText();
				String price=tfSet1P.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnSet1.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\set1.png"));
		contentPane.add(btnSet1);
		
		btnSet2 = new JButton("");
		btnSet2.setBounds(509, 263, 200, 200);
		btnSet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfSet3.getText();
				String price=tfSet3P.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
		btnSet2.setIcon(new ImageIcon(
				"D:\\work_java\\javaProject\\src\\JsProject\\set3.png"));
		contentPane.add(btnSet2);
		
		btnSet3 = new JButton("");
		btnSet3.setBounds(746, 10, 200, 200);
		btnSet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfSet2.getText();
				String price=tfSet2P.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			
			}
		});
		btnSet3.setIcon(new ImageIcon("D:\\work_java\\javaProject\\src\\JsProject\\set2.png"));
		contentPane.add(btnSet3);
		
		btnPizzaL = new JButton("");
		btnPizzaL.setBounds(746, 263, 200, 200);
		btnPizzaL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=tfPizzaLage.getText();
				String price=tfPizzaLageP.getText();
				tfMenu.setText(menu);
				tfPrice.setText(price);
			}
		});
	
		btnPizzaL.setIcon(new ImageIcon
				("D:\\work_java\\javaProject\\src\\JsProject\\bigpizza.png"));
		contentPane.add(btnPizzaL);
		
		num=new Vector<String>();
//		num.add("선택");
		for(int i=0; i<=100; i++) {
			num.add(String.valueOf(i));
		}
		comboBox = new JComboBox(num);
		comboBox.setBounds(789, 504, 55, 30);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object a=e.getItem();
			     combonum=a+"";
			}
		});
		contentPane.add(comboBox);
		
		btnChoice = new JButton("선택");

		btnChoice.setBounds(856, 505, 90, 29);
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfMenu.getText().equals("")){
					JOptionPane.showMessageDialog(JsFastFoodSell.this, "메뉴를 선택해주세요.");						
				} else if(Integer.parseInt(combonum)==0 || Double.parseDouble(tfPrice.getText())==0){
					JOptionPane.showMessageDialog(JsFastFoodSell.this, "수량을 선택해주세요");	
				}  else {
					if(Integer.parseInt(combonum) > 0 ||  Double.parseDouble(tfPrice.getText()) > 0) {
				double price=Double.parseDouble(tfPrice.getText());
				int amount=Integer.parseInt(combonum);
				double tot=price*amount;
				Vector list=new Vector();
				list.add(tfMenu.getText());
				list.add(amount);
				list.add(tot);
				items.add(list);			
				DefaultTableModel model=new DefaultTableModel(items,col);
				table.setModel(model);
					int idx=table.getRowCount();
					double sum =0.0;
					for(int i=0; i<idx; i++) {
						sum += Double.parseDouble(table.getValueAt(i, 2).toString());
					}			
					lblMent.setText("총가격은 "+sum+ "달러 입니다");	
					}
				}
			   comboBox.setSelectedIndex(0);
			   tfMenu.setText("");
			   tfPrice.setText("");	   
			}
		});
		
		contentPane.add(btnPizzaL);
		btnbuy = new JButton("구매");
		btnbuy.setBounds(509, 560, 114, 53);
		btnbuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menuname=tfMenu.getText();
				double price=Double.parseDouble(tfPrice.getText());
				int amount=Integer.parseInt(combonum);
				String tot=String.valueOf(price*amount);
			int response=JOptionPane.showConfirmDialog
					(JsFastFoodSell.this, lblMent.getText()+" 구매하시겠습니까?");			
			if(response==JOptionPane.YES_OPTION) {				
				JOptionPane.showMessageDialog(JsFastFoodSell.this, "주문하신 상품이 구매되었습니다.");	
				int idx=table.getRowCount();
				int minus =0;
				for(int i=0; i<idx;) {
						minus = Integer.parseInt(table.getValueAt(i, 1).toString());
						menuname=table.getValueAt(i, 0).toString();
						int a=dao.menuName(menuname).getAmount();
					    amount=a-minus;
						dto=new JsFastFoodDTO(menuname, amount);
						int result=dao.updateAmount(dto);
						i++;
					}
				Vector list=new Vector();
				list.add(tfMenu.getText());
				list.add(amount);
				list.add(tot);
				items.add(list);
				DefaultTableModel model=new DefaultTableModel(items,col);
				table.setModel(model);
				lblMent.setText("");
				tfMenu.setText("");
				tfPrice.setText("");
				comboBox.setSelectedIndex(0);	
				model.setNumRows(0);
			    }			
			}
		});
		btnbuy.setFont(new Font("굴림", Font.BOLD, 16));
		contentPane.add(btnbuy);
		btnChoice.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(btnChoice);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(832, 561, 114, 53);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog
						(JsFastFoodSell.this, "로그아웃 하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnLogout.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(btnLogout);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.setBounds(672, 560, 114, 53);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog
						(JsFastFoodSell.this, "취소하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					DefaultTableModel model=new DefaultTableModel(items,col);
					table.setModel(model);
					model.setNumRows(0);
					lblMent.setText("");
					tfMenu.setText("");
					tfPrice.setText("");
					comboBox.setSelectedIndex(0);
				}
			}
		});
		btnCancle.setFont(new Font("굴림", Font.BOLD, 16));
		contentPane.add(btnCancle);
		
		tfHotdog = new JTextField();
		tfHotdog.setBounds(150, 122, 70, 21);
		tfHotdog.setEditable(false);
		tfHotdog.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfHotdog);
		tfHotdog.setColumns(10);
		
		tfHotdogP = new JTextField();
		tfHotdogP.setBounds(224, 122, 26, 21);
		tfHotdogP.setEditable(false);
		tfHotdogP.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfHotdogP);
		tfHotdogP.setColumns(10);
		
		tfTacos = new JTextField();
		tfTacos.setBounds(272, 122, 70, 21);
		tfTacos.setFont(new Font("굴림", Font.BOLD, 12));
		tfTacos.setEditable(false);
		contentPane.add(tfTacos);
		tfTacos.setColumns(10);
		
		tfTacosP = new JTextField();
		tfTacosP.setBounds(346, 122, 26, 21);
		tfTacosP.setFont(new Font("굴림", Font.BOLD, 12));
		tfTacosP.setEditable(false);
		contentPane.add(tfTacosP);
		tfTacosP.setColumns(10);
		
		tfPizzaS = new JTextField();
		tfPizzaS.setBounds(397, 122, 70, 21);
		tfPizzaS.setFont(new Font("굴림", Font.BOLD, 12));
		tfPizzaS.setEditable(false);
		contentPane.add(tfPizzaS);
		tfPizzaS.setColumns(10);
		
		tfPizzaSP = new JTextField();
		tfPizzaSP.setBounds(471, 122, 26, 21);
		tfPizzaSP.setFont(new Font("굴림", Font.BOLD, 12));
		tfPizzaSP.setEditable(false);
		contentPane.add(tfPizzaSP);
		tfPizzaSP.setColumns(10);
		
		tfCola = new JTextField();
		tfCola.setBounds(22, 263, 70, 21);
		tfCola.setFont(new Font("굴림", Font.BOLD, 12));
		tfCola.setEditable(false);
		contentPane.add(tfCola);
		tfCola.setColumns(10);
		
		tfColaP = new JTextField();
		tfColaP.setBounds(96, 263, 26, 21);
		tfColaP.setFont(new Font("굴림", Font.BOLD, 12));
		tfColaP.setEditable(false);
		contentPane.add(tfColaP);
		tfColaP.setColumns(10);
		
		tfCoffee = new JTextField();
		tfCoffee.setBounds(150, 263, 70, 21);
		tfCoffee.setEditable(false);
		tfCoffee.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfCoffee);
		tfCoffee.setColumns(10);
		
		tfCoffeeP = new JTextField();
		tfCoffeeP.setBounds(224, 263, 26, 21);
		tfCoffeeP.setEditable(false);
		tfCoffeeP.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfCoffeeP);
		tfCoffeeP.setColumns(10);
		
		tfIcecream = new JTextField();
		tfIcecream.setBounds(272, 263, 70, 21);
		tfIcecream.setEditable(false);
		tfIcecream.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfIcecream);
		tfIcecream.setColumns(10);
		
		tfIcecreamP = new JTextField();
		tfIcecreamP.setBounds(346, 263, 26, 21);
		tfIcecreamP.setFont(new Font("굴림", Font.BOLD, 12));
		tfIcecreamP.setEditable(false);
		contentPane.add(tfIcecreamP);
		tfIcecreamP.setColumns(10);
		
		tfPotato = new JTextField();
		tfPotato.setBounds(397, 263, 70, 21);
		tfPotato.setEditable(false);
		tfPotato.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfPotato);
		tfPotato.setColumns(10);
		
		tfPotatoP = new JTextField();
		tfPotatoP.setBounds(471, 263, 26, 21);
		tfPotatoP.setEditable(false);
		tfPotatoP.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfPotatoP);
		tfPotatoP.setColumns(10);
		
		tfSet1 = new JTextField();
		tfSet1.setBounds(509, 220, 116, 21);
		tfSet1.setEditable(false);
		tfSet1.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfSet1);
		tfSet1.setColumns(10);
		
		tfSet1P = new JTextField();
		tfSet1P.setBounds(639, 220, 70, 21);
		tfSet1P.setEditable(false);
		tfSet1P.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfSet1P);
		tfSet1P.setColumns(10);
		
		tfSet2 = new JTextField();
		tfSet2.setBounds(746, 220, 116, 21);
		tfSet2.setFont(new Font("굴림", Font.BOLD, 12));
		tfSet2.setEditable(false);
		contentPane.add(tfSet2);
		tfSet2.setColumns(10);
		
		tfSet2P = new JTextField();
		tfSet2P.setBounds(876, 220, 70, 21);
		tfSet2P.setFont(new Font("굴림", Font.BOLD, 12));
		tfSet2P.setEditable(false);
		contentPane.add(tfSet2P);
		tfSet2P.setColumns(10);
		
		tfSet3 = new JTextField();
		tfSet3.setBounds(509, 473, 116, 21);
		tfSet3.setFont(new Font("굴림", Font.BOLD, 12));
		tfSet3.setEditable(false);
		contentPane.add(tfSet3);
		tfSet3.setColumns(10);
		
		tfSet3P = new JTextField();
		tfSet3P.setBounds(639, 473, 70, 21);
		tfSet3P.setFont(new Font("굴림", Font.BOLD, 12));
		tfSet3P.setEditable(false);
		contentPane.add(tfSet3P);
		tfSet3P.setColumns(10);
		
		tfPizzaLage = new JTextField();
		tfPizzaLage.setBounds(746, 473, 116, 21);
		tfPizzaLage.setFont(new Font("굴림", Font.BOLD, 12));
		tfPizzaLage.setEditable(false);
		contentPane.add(tfPizzaLage);
		tfPizzaLage.setColumns(10);
		
		tfPizzaLageP = new JTextField();
		tfPizzaLageP.setBounds(876, 473, 70, 21);
		tfPizzaLageP.setEditable(false);
		tfPizzaLageP.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(tfPizzaLageP);
		tfPizzaLageP.setColumns(10);
		
		
		cols= new Vector();
		cols.add("제품번호");
		cols.add("메뉴");
		cols.add("가격");
		cols.add("수량");
        
		
//		model1=new DefaultTableModel(dao.listFastFood(),cols);		
//        table_1.setModel(model1);
//
//		tfHambuger.setText(table_1.getValueAt(0, 1)+"");
//		tfHambugerP.setText( table_1.getValueAt(0, 2)+"");
//		tfHotdog.setText(table_1.getValueAt(1, 1)+"");
//		tfHotdogP.setText(table_1.getValueAt(1, 2)+"");
//		tfTacos.setText(table_1.getValueAt(2, 1)+"");
//		tfTacosP.setText(table_1.getValueAt(2, 2)+"");
//		tfPizzaS.setText(table_1.getValueAt(3, 1)+"");
//		tfPizzaSP.setText(table_1.getValueAt(3, 2)+"");
//		tfCola.setText(table_1.getValueAt(4, 1)+"");
//		tfColaP.setText(table_1.getValueAt(4, 2)+"");
//		tfCoffee.setText(table_1.getValueAt(5, 1)+"");
//		tfCoffeeP.setText(table_1.getValueAt(5, 2)+"");
//		tfIcecream.setText(table_1.getValueAt(6, 1)+"");
//		tfIcecreamP.setText(table_1.getValueAt(6, 2)+"");
//		tfPotato.setText(table_1.getValueAt(7, 1)+"");
//		tfPotatoP.setText(table_1.getValueAt(7, 2)+"");
//		tfSet1.setText(table_1.getValueAt(8, 1)+"");
//		tfSet1P.setText(table_1.getValueAt(8, 2)+"");
//		tfSet2.setText(table_1.getValueAt(9, 1)+"");
//		tfSet2P.setText(table_1.getValueAt(9, 2)+"");
//		tfSet3.setText(table_1.getValueAt(10, 1)+"");
//		tfSet3P.setText(table_1.getValueAt(10, 2)+"");
//		tfPizzaLage.setText(table_1.getValueAt(11, 1)+"");
//		tfPizzaLageP.setText(table_1.getValueAt(11, 2)+"");

		dao=new JsFastFoodDAO();
		model1=new DefaultTableModel(dao.listFastFood(),cols);
		tfHambuger.setText(model1.getValueAt(0, 1)+"");
		tfHambugerP.setText(model1.getValueAt(0, 2)+"");
		tfHotdog.setText(model1.getValueAt(1, 1)+"");
		tfHotdogP.setText(model1.getValueAt(1, 2)+"");
		tfTacos.setText(model1.getValueAt(2, 1)+"");
		tfTacosP.setText(model1.getValueAt(2, 2)+"");
		tfPizzaS.setText(model1.getValueAt(3, 1)+"");
		tfPizzaSP.setText(model1.getValueAt(3, 2)+"");
		tfCola.setText(model1.getValueAt(4, 1)+"");
		tfColaP.setText(model1.getValueAt(4, 2)+"");
		tfCoffee.setText(model1.getValueAt(5, 1)+"");
		tfCoffeeP.setText(model1.getValueAt(5, 2)+"");
		tfIcecream.setText(model1.getValueAt(6, 1)+"");
		tfIcecreamP.setText(model1.getValueAt(6, 2)+"");
		tfPotato.setText(model1.getValueAt(7, 1)+"");
		tfPotatoP.setText(model1.getValueAt(7, 2)+"");
		tfSet1.setText(model1.getValueAt(8, 1)+"");
		tfSet1P.setText(model1.getValueAt(8, 2)+"");
		tfSet2.setText(model1.getValueAt(9, 1)+"");
		tfSet2P.setText(model1.getValueAt(9, 2)+"");
		tfSet3.setText(model1.getValueAt(10, 1)+"");
		tfSet3P.setText(model1.getValueAt(10, 2)+"");
		tfPizzaLage.setText(model1.getValueAt(11, 1)+"");
		tfPizzaLageP.setText(model1.getValueAt(11, 2)+"");

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 315, 485, 219);
		contentPane.add(scrollPane);
			
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblMent = new JLabel("");
		lblMent.setFont(new Font("굴림", Font.BOLD, 20));
		lblMent.setBounds(12, 544, 376, 69);
		contentPane.add(lblMent);
		
		lblNewLabel = new JLabel(" 수량");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setBounds(736, 504, 50, 30);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("메뉴삭제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model=(DefaultTableModel) table.getModel();
//				int selectidx=table.getSelectedRow();
//				model.removeRow(selectidx);
				
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int response=JOptionPane.showConfirmDialog
						(JsFastFoodSell.this, "선택하신 메뉴를 삭제 하시겠습니까?");	
			    if(response==JOptionPane.YES_OPTION) {
			    	int selectidx=table.getSelectedRow();							  
			     if(selectidx==-1) {
			    	JOptionPane.showMessageDialog(JsFastFoodSell.this, "메뉴를 선택하세요.");
			      }
			      else {
			    	    JOptionPane.showMessageDialog(JsFastFoodSell.this, "삭제 되었습니다.");
			    	    int idx=table.getRowCount();
						double sum =0.0;
						for(int i=0; i<idx; i++) {
							sum += Double.parseDouble(table.getValueAt(i, 2).toString());
						}			
						sum = sum-Double.parseDouble(table.getValueAt(selectidx, 2).toString());		
					lblMent.setText("총가격은 "+sum+ "달러 입니다");	
					model.removeRow(selectidx);
			      }	
			    }
			}
		});
		btnNewButton.setBounds(397, 544, 100, 69);
		contentPane.add(btnNewButton);
		
		
		
	}
	public void clear() {
		DefaultTableModel model=new DefaultTableModel(items,col);
		table.setModel(model);
		model.setNumRows(0);
		lblMent.setText("");
		tfMenu.setText("");
		tfPrice.setText("");
		comboBox.setSelectedIndex(0);
	}
}
