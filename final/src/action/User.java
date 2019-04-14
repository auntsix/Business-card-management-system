package action;
import com.opensymphony.xwork2.ActionSupport;
import dao.*;
import dao.daoimpl.userDaoImpl;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

public class User extends ActionSupport implements SessionAware, RequestAware {

  public static final long serialVersionUID = 1L;
  private Map<String,Object> request;
  private Map<String,Object> session;

  private int flag;
  private String userName;
  private String password;

  userDao userDao = new userDaoImpl();


  //登录判断
  public String login() throws SQLException{
          if(userDao.isLogin(userName,password)==true){
            session.put("userName",userName);
            session.put("password",password);
            return SUCCESS;
          }else{
            return "fail";
          }
  }

  //修改密码
  public String updatePwd() throws SQLException{
    if (userDao.updatepwd((String)session.get("userName"),password)==true){
      return SUCCESS;
    }else{
      return "fail";
    }
  }

  //注册
  public String isRegist() throws SQLException{
    if(flag==1){
    if(userDao.isRegist(userName,password)==true){
      request.put("isExit","true");
      return SUCCESS;}
    else {
      request.put("isExit","false");
      return "fail";
    }}
    else
      return "fail";
  }

  //安全退出
  public String logout(){
    session.clear();
    return SUCCESS;
  }

  public String execute() {
    return SUCCESS;
  }

  @Override
  public void setRequest(Map<String, Object> map) {
    request=map;
  }

  @Override
  public void setSession(Map<String, Object> map) {
    session=map;
  }
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public User() {
  }
}
