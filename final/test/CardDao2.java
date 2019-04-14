//import java.sql.*;
//import java.util.ArrayList;
//
//import action.*;
//
//public class CardDao2 {
//
////    添加名片信息
//
//
//    public boolean add(Card card) throws Exception {
//        boolean b = false;
//        Connection con = BaseDao.getConnection();
//        //其中id为自增
//        String sql = "insert into cardinfo values(null,?,?,?,?,?,?,?,?)";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, card.getName());
//        ps.setString(2, card.getTelephone());
//        ps.setString(3, card.getEmail());
//        ps.setString(4, card.getCompany());
//        ps.setString(5, card.getPost());
//        ps.setString(6, card.getAddress());
//        ps.setString(7, card.getLogo());
//        ps.setString(8, card.getUserName());
//        int i = ps.executeUpdate();
//        if (i > 0)
//            b = true;
//        return b;
//    }
////    修改名片信息
//
//    public boolean update(Card card) throws Exception {
//        boolean b = false;
//        Connection con = BaseDao.getConnection();
//        //其中id为自增
//        String sql = "update cardinfo set name=?,telephone=?,email=?,company=?,post=?,address=?";
//        if (card.getLogo() != null) {
//            sql = sql + ",logo=?";
//        }
//        sql = sql + " where id=?";
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, card.getName());
//        ps.setString(2, card.getTelephone());
//        ps.setString(3, card.getEmail());
//        ps.setString(4, card.getCompany());
//        ps.setString(5, card.getPost());
//        ps.setString(6, card.getAddress());
//        if (card.getLogo() != null) {
//            ps.setString(7, card.getLogo());
//            ps.setInt(8, card.getId());
//        } else {
//            ps.setInt(7, card.getId());
//        }
//        int i = ps.executeUpdate();
//        if (i > 0)
//            b = true;
//        return b;
//    }
//
//    //    查询所有名片
//    public ArrayList<Card> queryAll(String userName) throws Exception {
//        ArrayList<Card> ac = new ArrayList<Card>();
//        Connection con = BaseDao.getConnection();
//        String sql = "select * from cardinfo where userName=?";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, userName);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Card c = new Card();
//            c.setId(rs.getInt("id"));
//            c.setName(rs.getString("name"));
//            c.setTelephone(rs.getString("telephone"));
//            c.setEmail(rs.getString("email"));
//            c.setCompany(rs.getString("company"));
//            c.setPost(rs.getString("post"));
//            c.setAddress(rs.getString("address"));
//            c.setLogo(rs.getString("logo"));
//            ac.add(c);
//        }
//        return ac;
//    }
//
//    //分页查询
//    public ArrayList<Card> queryByPage(int pageCur, String userName) throws Exception {
//
//        ArrayList<Card> ac = new ArrayList<Card>();
//        Connection con = BaseDao.getConnection();
//        String sql = "select a.id,a.name,a.telephone,a.email,a.company,a.post,a.address,a.logo from cardinfo a where a.userName=? limit ?,?";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, userName);
//        ps.setInt(2,(pageCur-1)*10);
//        ps.setInt(3,pageCur*10);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Card c = new Card();
//            c.setId(rs.getInt("id"));
//            c.setName(rs.getString("name"));
//            c.setTelephone(rs.getString("telephone"));
//            c.setEmail(rs.getString("email"));
//            c.setCompany(rs.getString("company"));
//            c.setPost(rs.getString("post"));
//            c.setAddress(rs.getString("address"));
//            c.setLogo(rs.getString("logo"));
//            ac.add(c);
//        }
//        return ac;
//    }
//
//
////    查询名片
//    public Card selectA(int id) throws Exception{
//        Card c=new Card();
//        Connection con= BaseDao.getConnection();
//        String sql="select * from cardinfo where id=?";
//        PreparedStatement ps=con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            c.setId(rs.getInt("id"));
//            c.setName(rs.getString("name"));
//            c.setTelephone(rs.getString("telephone"));
//            c.setEmail(rs.getString("email"));
//            c.setCompany(rs.getString("company"));
//            c.setPost(rs.getString("post"));
//            c.setAddress(rs.getString("address"));
//            c.setLogo(rs.getString("logo"));
//        }
//        return c;
//    }
//
////    删除一个名片信息
//    public Boolean delete(int id) throws Exception{
//        boolean b=false;
//        Connection con= BaseDao.getConnection();
//        String sql="delete from cardinfo where id=?";
//        PreparedStatement ps=con.prepareStatement(sql);
//        ps.setInt(1,id);
//        int i=ps.executeUpdate();
//        if(i>0)
//            b=true;
//        return b;
//
//    }
//
//
//    //    删除多个名片信息
//    public Boolean delete(int ids[]) throws Exception{
//        boolean b=false;
//        Connection con= BaseDao.getConnection();
//        String sql="delete from cardinfo where id in(";
//        for(int i=0;i<ids.length-1;i++){
//            sql=sql+ids[i]+",";
//        }
//        sql=sql+ids[ids.length-1]+")";
//        PreparedStatement ps=con.prepareStatement(sql);
//        int i=ps.executeUpdate();
//        if(i>0)
//            b=true;
//        return b;
//    }
//
//
//
//}
//
//
//
//
