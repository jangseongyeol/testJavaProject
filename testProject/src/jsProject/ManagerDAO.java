package jsProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ManagerDAO {
	
	public int insertManager(ManagerDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="INSERT INTO manager (managerid, managerpwd) "
                        +" VALUES (?,?)";		
			pstmt=conn.prepareStatement(sql);	
			pstmt.setString(1, dto.getManagerid());
			pstmt.setString(2, dto.getManagerpwd());
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
	}//end insertManager()
	
	public Vector listManager() {
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select managerid, managerpwd from manager";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getString("managerid"));
				row.add(rs.getString("managerpwd"));
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
	}//end listManager()
	
	public int deleteManager(String managerid) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="delete from manager where managerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, managerid);
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
	}//end deleteManager()
	
	public int updateManager(ManagerDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="update manager set managerpwd=? where managerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getManagerpwd());
			pstmt.setString(2, dto.getManagerid());
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
	}//end updateManager()
	
	public ManagerDTO viewManager(String managerid) {
		ManagerDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select managerid, managerpwd FROM manager WHERE managerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, managerid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String managerpwd=rs.getString("managerpwd");
				dto=new ManagerDTO(managerid, managerpwd);
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
	}//end viewManager()
	

	
	

}
