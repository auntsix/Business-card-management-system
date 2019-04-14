package dao;
import action.User;

import java.sql.SQLException;

public interface userDao {
    //判断用户名是否存在
    boolean isExit(String userName) throws SQLException;
    User isExitbyName(String userName) throws SQLException;
    //修改密码
    boolean updatepwd(String userName, String password) throws SQLException;
    int updatepwd1(String userName, String password) throws SQLException;

    //登录
    User isLogin1(String userName, String password) throws SQLException;
    boolean isLogin(String userName, String password) throws SQLException;

    //注册
    boolean isRegist(String userName, String password) throws SQLException;
    int isRegist1(String userName, String password) throws SQLException;

}
