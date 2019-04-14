package dao;

import action.Card;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface cardDao {
    //按值查询名片
    Card qurey(int id) throws SQLException;
//    查询所有名片
    List<Card> qureyAll(String userName)throws SQLException;
    //分页查询
    List<Card> qureyByPage(int pageCur, String userName)throws SQLException;

    //删除一个名片信息
    int delete1(int id, String userName)throws SQLException;
    boolean delete(int id, String userName)throws SQLException;
    //添加
    int add1(Card card) throws SQLException;
    boolean add(Card card) throws SQLException;

    //修改
    int update1(Card card) throws SQLException;
    boolean update(Card card) throws SQLException;
    //查总数
    int selectAccount()throws SQLException;
    int selectAccount1(String userName)throws SQLException;

}
