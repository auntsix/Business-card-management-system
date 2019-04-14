package dao.daoimpl;
import action.Card;
import dao.cardDao;
import util.*;
import util.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cardDaoImpl implements cardDao{
    ConnectionPool connectionPool =ConnectionPoolUtils.GetPoolInstance();

    //查询名片信息
    @Override
    public Card qurey(int id) throws SQLException {
        Card card=null;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from cardinfo where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                int Id =rs.getInt("id");
                String name = rs.getString("name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String company = rs.getString("company");
                String address = rs.getString("address");
                String logo = rs.getString("logo");
                card = new Card(Id,name,telephone,email,company,address,logo);
            }
            return card;
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
        return card;

    }

    //查询全部数据
    @Override
    public List<Card> qureyAll(String userName) throws SQLException {
        List<Card> cards=new ArrayList<Card>();
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Card card;
        try {
            String sql = "select * from cardinfo where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs=pstmt.executeQuery();
            for(int i=1;i<=selectAccount();i++) {
            if(rs.next()){
                    int Id = rs.getInt("id");
                    String name = rs.getString("name");
                    String company = rs.getString("company");
                    card = new Card(Id, name, company);
                    cards.add(card);
                }
            }
            return cards;
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

        return cards;
    }

    //分页查询
    @Override
    public List<Card> qureyByPage(int pageCur,String userName) throws SQLException {
        List<Card> cards=new ArrayList<Card>();
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x=pageCur-1;

        try {
            String sql = "select a.id,a.name,a.telephone,a.email,a.company,a.post" +
                    ",a.address,a.logo from cardinfo a where a.userName=? limit ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            pstmt.setInt(2,x*10);
            pstmt.setInt(3,10);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Card card =new Card();
                card.setId(rs.getInt("id"));
                card.setName(rs.getString("name"));
                card.setTelephone(rs.getString("telephone"));
                card.setEmail(rs.getString("email"));
                card.setCompany(rs.getString("company"));
                card.setPost(rs.getString("post"));
                card.setAddress(rs.getString("address"));
                card.setLogo(rs.getString("logo"));
                cards.add(card);
            }
            return cards;
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

        return cards;
    }

    //删除
    @Override
    public int delete1(int id, String userName) throws SQLException {
        int b = 0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "delete from cardinfo where id=? and userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,userName);
            b =pstmt.executeUpdate();
            return b;
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
        return b;
    }

    @Override
    public boolean delete(int id, String userName) throws SQLException {
        return delete1(id,userName)!=0?true:false;
    }


    //添加
    @Override
    public int add1(Card card) throws SQLException {
        int rows=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into cardinfo(name,telephone,email,company,post,address,logo,userName,id) values(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,card.getName());
            pstmt.setString(2,card.getTelephone());
            pstmt.setString(3,card.getEmail());
            pstmt.setString(4,card.getCompany());
            pstmt.setString(5,card.getPost());
            pstmt.setString(6,card.getAddress());
            pstmt.setString(7,card.getLogo());
            pstmt.setString(8,card.getUserName());
            pstmt.setInt(9,selectAccount()+1);
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

    @Override
    public boolean add(Card card) throws SQLException {
        return add1(card)!=0?true:false;
    }

    @Override
    public int update1(Card card) throws SQLException {
        int rows=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "update cardinfo set name=?,telephone=?" +
                    ",email=?,company=?,logo=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,card.getName());
            pstmt.setString(2,card.getTelephone());
            pstmt.setString(3,card.getEmail());
            pstmt.setString(4,card.getCompany());
            pstmt.setString(5,card.getLogo());
            pstmt.setInt(6,card.getId());
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

    //修改
    @Override
    public boolean update(Card card) throws SQLException {
        return update1(card)!=0?true:false;


    }



    @Override
    //查总数
    public int selectAccount() throws SQLException {
        int count=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        try {
            String sql = "select count(*) from cardinfo ";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
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
        return count;

    }

    @Override
    public int selectAccount1(String userName) throws SQLException {
        int count=0;
        Connection conn = connectionPool.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        try {
            String sql = "select count(*) from cardinfo where userName=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs=pstmt.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
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
        return count;

    }
}
