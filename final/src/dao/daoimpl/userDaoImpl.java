package dao.daoimpl;
import dao.userDao;
import action.User;
import util.ConnectionPoolUtils;
import util.pool.ConnectionPool;

import java.sql.*;

public class userDaoImpl implements userDao {
     ConnectionPool connectionPool =ConnectionPoolUtils.GetPoolInstance();
    //是否存在用户
    @Override
    public boolean isExit(String userName) throws SQLException {
        return isExitbyName(userName)==null?false:true;
    }

    @Override
    public User isExitbyName(String userName) throws SQLException {
        User user = null;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from usertable where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            rs=pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("userName");
                String pwd = rs.getString("password");
                user = new User(name, pwd);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //修改密码
    @Override
    public boolean updatepwd(String userName, String password) throws SQLException {
        if(updatepwd1(userName,password)!=0) return true;
        else return false;
    }

    @Override
    public int updatepwd1(String userName, String password) throws SQLException {
        int rows=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "update usertable set password=? where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2,userName);
            rows=pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    //登录
    public User isLogin1(String userName, String password) throws SQLException{
        User user = null;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from usertable where userName=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("userName");
                String pwd = rs.getString("password");
                user = new User(name, pwd);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public boolean isLogin(String userName, String password) throws SQLException {
        return isLogin1(userName,password)==null?false:true;
    }
    //注册
    @Override
    public boolean isRegist(String userName, String password) throws SQLException {
        if(isExit(userName)==false&&isRegist1(userName,password)!=0)
            return true;
        else
            return false;
    }

    @Override
    public int isRegist1(String userName, String password) throws SQLException {
        int rows=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into usertable(userName, password) values(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(2, password);
            pstmt.setString(1,userName);
            rows=pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }
}
