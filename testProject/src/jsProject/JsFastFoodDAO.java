package jsProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class JsFastFoodDAO {
	
	public JsFastFoodDTO menuName(String menuname) {
		JsFastFoodDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		conn=DB.dbConn();
		String sql="select amount from fastfood where menuname=?"; 
		pstmt=conn.prepareStatement(sql);		
		pstmt.setString(1, menuname);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			int amount= rs.getInt("amount");
			dto=new JsFastFoodDTO(menuname, amount);			
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}//finally
		return dto;
	}//end hambuger()
	
	public int updateFastFood(JsFastFoodDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="update fastfood set menuname=?, price=?, amount=? where itemnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMenuname());
			pstmt.setDouble(2, dto.getPrice());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getItemnum());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//end updateFastFood()
	
	public Vector listFastFood() {
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select itemnum, menuname, price, amount from fastfood";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getInt("itemnum"));
				row.add(rs.getString("menuname"));
				row.add(rs.getDouble("price"));
				row.add(rs.getInt("amount"));
				items.add(row);				
			}					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}//finally
		return items; //백터 리턴
	}//end listMember()	
	
	public boolean useridck (String userid) {
		boolean b= true;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		    conn=DB.dbConn();
			String sql="select userid from jsmember "
					+ " where userid like ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			b=rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}//finally
		return b; //백터 리턴
	}//end Joinck()	
	
	public JsFastFoodDTO viewFastFood(String menuname) {
		JsFastFoodDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select menuname, price, amount from fastfood "
					+ " FROM fastfood WHERE menuname=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, menuname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				double price=Double.parseDouble("price");
				int amount=Integer.parseInt("amount");
				dto=new JsFastFoodDTO(menuname, price, amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}//finally
		return dto; 
	}//end viewFastFood()
	
	public int deleteFastFood(int itemnum) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="delete from fastfood where itemnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, itemnum);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//end deleteFastFood()
	
	public int insertFastFood(JsFastFoodDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="INSERT INTO fastfood (menuname, price, amount) "
                        +" VALUES (?,?,?)";		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, dto.getMenuname());
			pstmt.setDouble(2, dto.getPrice());
			pstmt.setInt(3, dto.getAmount());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//end insertFastFood()
	
	public int updateAmount(JsFastFoodDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="update fastfood set amount=amount + ? where menuname=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getAmount());
			pstmt.setString(2, dto.getMenuname());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//end updateAmount()
	
	
}