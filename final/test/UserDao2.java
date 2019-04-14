/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao2 extends BaseDao {
    //判断用户名是否存在

    public boolean isExit(String uname) throws Exception{
        boolean b=false;
        Connection con = BaseDao.getConnection();
       ResultSet rs=null;
        PreparedStatement ps=null;
        try{
            String sql = "select * from usertable where userName=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, uname);
            rs = ps.executeQuery();
            if (rs.next()) {
                b = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {if(rs!=null||ps!=null||con!=null)
                    close(rs,ps,con);
        }
        return b;
    }

    //注册
    public boolean isRegist(String uname,String upass) throws Exception{
        boolean b=false;
        Connection con = BaseDao.getConnection();
        String sql="insert into usertable value (?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,upass);
        int i=ps.executeUpdate();
        if(i>0)   //注册成功
            b=true;
        close(null,ps,con);
        return b;
    }
    //登录
    public boolean isLogin(String uname,String upass) throws Exception{
        boolean b=false;
        Connection con = BaseDao.getConnection();
        String sql="select * from usertable where userName=? and password=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,upass);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            b=true;
        close(rs,ps,con);
        return b;
    }

    //修改密码
    public boolean updatepwd(String uname,String upass) throws Exception{
        boolean b=false;
        Connection con = BaseDao.getConnection();
        String sql="update usertable set password=? where userName=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,upass);
        int i=ps.executeUpdate();
        if(i>0) //修改成功
            b=true;
        close(null,ps,con);
        return b;
    }





}
*/
