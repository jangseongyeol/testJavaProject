package jsProject;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JsFastFoodMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector col;
	private JsFastFoodDAO dao;
	private DefaultTableModel model;
	private JTextField tfMenuname;
	private JTextField tfPrice;
	private JTextField tfAmount;
	private ManagerDms join;
	private JsFastFoodDTO dto;
	private JTextField tfItemnum;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JsFastFoodMenu frame = new JsFastFoodMenu();
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
	public JsFastFoodMenu(ManagerDms join) {
		this();
		this.join=join;
	}
	
	public JsFastFoodMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 317, 344);
		contentPane.add(scrollPane);
		dao=new JsFastFoodDAO();
		col= new Vector();
		col.add("제품번호");
		col.add("메뉴");
		col.add("가격");
		col.add("재고");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectTable();
			}
		});
		scrollPane.setViewportView(table);
		
		tfMenuname = new JTextField();
		tfMenuname.setBounds(402, 46, 95, 21);
		contentPane.add(tfMenuname);
		tfMenuname.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(402, 83, 95, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(402, 120, 95, 21);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
		
		JButton btnInsert = new JButton("재고 추가");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menuname=tfMenuname.getText();
				int amount=Integer.parseInt(tfAmount.getText());
				dto = new JsFastFoodDTO(menuname, amount);
				int result=dao.updateAmount(dto);
				if(result==1){
				JOptionPane.showMessageDialog(JsFastFoodMenu.this, "추가 되었습니다");
				list();
				table.setModel(model);
				clear();	
				} 
			}
		});
		btnInsert.setBounds(383, 164, 114, 47);
		contentPane.add(btnInsert);
		
		
		JButton btnUpdate = new JButton("메뉴 수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemnum=Integer.parseInt(tfItemnum.getText());
				String menuname=tfMenuname.getText();
				double price=Double.parseDouble(tfPrice.getText());
				int amount=Integer.parseInt(tfAmount.getText());
				dto=new JsFastFoodDTO(itemnum, menuname, price, amount);
				int result=dao.updateFastFood(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(JsFastFoodMenu.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(381, 238, 116, 47);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("메뉴 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemnum=Integer.parseInt(tfItemnum.getText());
				int result=0;
				int response=JOptionPane.showConfirmDialog(JsFastFoodMenu.this, "삭제하시겠습니까?");
				if(response==JOptionPane.YES_OPTION) {
					result=dao.deleteFastFood(itemnum);				
				}
				if(result==1) {
					JOptionPane.showMessageDialog(JsFastFoodMenu.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();					
				}
			}
		});
		btnDelete.setBounds(381, 307, 116, 47);
		contentPane.add(btnDelete);
		
		tfItemnum = new JTextField();
		tfItemnum.setEditable(false);
		tfItemnum.setBounds(402, 10, 95, 21);
		contentPane.add(tfItemnum);
		tfItemnum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("제품번호");
		lblNewLabel.setBounds(341, 13, 55, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("메뉴명");
		lblNewLabel_1.setBounds(341, 49, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("가격");
		lblNewLabel_2.setBounds(341, 86, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("재고");
		lblNewLabel_3.setBounds(341, 123, 57, 15);
		contentPane.add(lblNewLabel_3);
		refreshTable();
	}
	public void refreshTable() {
		DefaultTableModel model= new 
				DefaultTableModel(dao.listFastFood(),col);
		table.setModel(model);
		}
	
	public void selectTable() {
		int idx=table.getSelectedRow();
		tfItemnum.setEditable(false);
		tfItemnum.setText(table.getValueAt(idx, 0)+"");
		tfMenuname.setText(table.getValueAt(idx, 1)+"");
		tfPrice.setText(table.getValueAt(idx, 2)+"");
		tfAmount.setText(table.getValueAt(idx, 3)+"");
	}
	
	public void input() {
		String menuname=tfMenuname.getText();
		double price=Double.parseDouble(tfPrice.getText());
		int amount=Integer.parseInt(tfAmount.getText());
		dto=new JsFastFoodDTO(menuname, price, amount);		
	}
	
	public void clear() {
		tfItemnum.setText("");
		tfMenuname.setText("");
		tfPrice.setText("");
		tfAmount.setText("");;
	}//end clear()	
	
	public void list() {
		model=new DefaultTableModel(dao.listFastFood(),col) {
			@Override
			public boolean isCellEditable(int row, int column) {	
				return false;
			}
		};
	}//end list()



	
}
