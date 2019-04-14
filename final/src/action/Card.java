package action;


import com.opensymphony.xwork2.ActionSupport;
import dao.daoimpl.cardDaoImpl;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Card  extends ActionSupport implements SessionAware, RequestAware {

  public static final long serialVersionUID = 1L;
  private Map<String,Object> request;
  private Map<String,Object> session;
  private List<Card> cards;
  private Card acard;
  private Card ucard;
  private List<Card> pageCard;
  private Card addcard;

//  private int ids;
  private int[] ids=new int[]{};
  private int id;
  private String name;
  private String telephone;
  private String email;
  private String company;
  private String post;
  private String address;
  private String logo;
  private String userName;
  private int pageCur;
  private int totalCount; //总数
  private int totalPage; //总页数
  Card card;

  cardDao cardDao=new cardDaoImpl();

  //添加
  public String add() throws SQLException{
    addcard=new Card(name,telephone,email,company,post,address,logo,(String)session.get("userName"));

    if(cardDao.add(addcard)==true)
      return SUCCESS;
    else
      return "fail";
  }


//查询表
    public String queryAll() throws SQLException{

      int temp = cardDao.selectAccount1((String) session.get("userName"));
      setTotalCount(temp);
//      if(temp == 0){
//        totalPage = 0;//总页数
//      }else{
//        totalPage=(int)Math.ceil((double)temp/10);
//      }
/*      if((pageCur-1)*10>=temp){
        pageCur = pageCur-1;
      }
      if(pageCur == 0){
        pageCur = 1;
      }*/
      cards=cardDao.qureyByPage(pageCur,(String) session.get("userName"));
      return SUCCESS;
    }

//详情 名片详细信息
  public String selectAll() throws SQLException{
    acard = cardDao.qurey(id);
   int total= cardDao.selectAccount1((String)session.get("userName"));
    session.put("total",total);
    return SUCCESS;
  }

  //删除一个
  public String detele()throws SQLException{
    if(cardDao.delete(id,(String)session.get("userName"))==true){
        System.out.println("删除成功");
      return SUCCESS;

    }
    else return ERROR;
  }


  //删除多个
    public String detele2() throws SQLException{

    if(ids!=null){
        for(int i=0;i<ids.length;i++){
          cardDao.delete(ids[i],(String)session.get("userName"));
                System.out.println(ids[i]);}
          return SUCCESS;

    }
     else return ERROR;
    }


//  修改
    public String update() throws SQLException{
        ucard=new Card(name,telephone,email,company,logo,id);
        if(cardDao.update(ucard)==true)
          return SUCCESS;
        else return ERROR;
    }














  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public int getPageCur() {
    return pageCur;
  }

  public void setPageCur(int pageCur) {
    this.pageCur = pageCur;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }


  public String getAddress() {
    return address;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public List<Card> getPageCard() {
    return pageCard;
  }

  public void setPageCard(List<Card> pageCard) {
    this.pageCard = pageCard;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Card(String name, String telephone, String email, String company, String post, String address, String logo, String userName) {
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.company = company;
    this.post = post;
    this.address = address;
    this.logo = logo;
    this.userName = userName;
  }

  public Card(String name, String telephone, String email, String company, String post, String address) {
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.company = company;
    this.post = post;
    this.address = address;
  }

  public Card(String name, String telephone, String email, String company, String post, String address, String logo) {
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.company = company;
    this.post = post;
    this.address = address;
    this.logo = logo;
  }

  public Card(int id, String name, String telephone, String email, String company, String address, String logo) {
    this.id = id;
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.company = company;
    this.address = address;
    this.logo = logo;
  }

  public Card() {
  }

  public Card(int id, String name, String telephone, String email, String company, String post, String address, String logo, String userName) {
    this.id = id;
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.company = company;
    this.post = post;
    this.address = address;
    this.logo = logo;
    this.userName = userName;
  }

    public Card(String name, String telephone, String email, String company, String logo,int id) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.company = company;
        this.logo = logo;
    }

    public Card(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public Card getAcard() {
    return acard;
  }

  public Card getUcard() {
    return ucard;
  }

  public void setUcard(Card ucard) {
    this.ucard = ucard;
  }

  public void setAcard(Card acard) {
    this.acard = acard;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public Card getAddcard() {
    return addcard;
  }

  public void setAddcard(Card addcard) {
    this.addcard = addcard;
  }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

//        public int getIds() {
//        return ids;
//    }
//
//    public void setIds(int ids) {
//        this.ids = ids;
//    }

    @Override
  public void setRequest(Map<String, Object> map) {
  request=map;
  }

  @Override
  public void setSession(Map<String, Object> map) {
    session=map;
  }
}

