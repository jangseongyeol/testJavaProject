package jsProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {
	
	public Vector listMember() {
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select cstnum, name, userid, password, passwordck, "
					+ " birthday, sx, email, hp, adrsnum, adrs, dadrs from jsmember";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getInt("cstnum"));
				row.add(rs.getString("name"));
				row.add(rs.getString("userid"));
				row.add(rs.getString("password"));
				row.add(rs.getString("passwordck"));
				row.add(rs.getString("birthday"));
				row.add(rs.getString("sx"));
				row.add(rs.getString("email"));
				row.add(rs.getString("hp"));
				row.add(rs.getString("adrsnum"));
				row.add(rs.getString("adrs"));
				row.add(rs.getString("dadrs"));
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
	
	public int insertMember(MemberDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="insert into jsmember(name, userid, "
					+ " password, passwordck, birthday, sx, email, hp, adrsnum, adrs, dadrs) "
                       +" values (?,?,?,?,?,?,?,?,?,?,?)";		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getPasswordck());
			pstmt.setString(5, dto.getBirthday());
			pstmt.setString(6, dto.getSx());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getHp());
			pstmt.setString(9, dto.getAdrsnum());
			pstmt.setString(10, dto.getAdrs());
			pstmt.setString(11, dto.getDadrs());
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
	}//end insertMember()
	
	public int deleteMember(int cstnum) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="delete from jsmember where cstnum=?;";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cstnum);
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
	}//end deleteMember()
	
	public int updateMember(MemberDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="update jsmember set name=?, userid=?, password=?, "
                       +" passwordck=?, birthday=?, sx=?, email=?, hp=?, adrsnum=?, adrs=?, dadrs=? "
                        +" where cstnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getPasswordck());
			pstmt.setString(5, dto.getBirthday());
			pstmt.setString(6, dto.getSx());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getHp());
			pstmt.setString(9, dto.getAdrsnum());
			pstmt.setString(10, dto.getAdrs());
			pstmt.setString(11, dto.getDadrs());
			pstmt.setInt(12, dto.getCstnum());
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
	}//end updateMember()
	
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
	
	public MemberDTO viewMember(int cstnum) {
		MemberDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select cstnum, name, userid, password, "
					+ " passwordck, birthday, sx, email, hp, adrsnum, adrs, dadrs "
                        +" FROM jsmember WHERE cstnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cstnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				String userid=rs.getString("userid");
				String password=rs.getString("password");
				String passwordck=rs.getString("passwordck");
				String birthday=rs.getString("birthday");
				String sx=rs.getString("sx");
				String email=rs.getString("email");
				String hp=rs.getString("hp");
				String adrsnum=rs.getString("adrsnum");
				String adrs=rs.getString("adrs");
				String dadrs=rs.getString("dadrs");
				dto=new MemberDTO(cstnum, name, userid, password, 
						passwordck, birthday, sx, email, hp, adrsnum, adrs, dadrs);
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
	}//end viewMember()
}
