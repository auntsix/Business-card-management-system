import action.Card;
import dao.*;
import dao.daoimpl.cardDaoImpl;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import sun.awt.geom.AreaOp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cardDaoImplTest {
    public static void main(String [] args) throws SQLException {





        Card card = new Card("12345", "12", "12", "12", "12","12","21","211");


        cardDao cardDao = new cardDaoImpl();
        for(int i=0;i<50;i++){
        boolean t=cardDao.add(card);}
//         List<Card> cards=new ArrayList<Card>();

//         cards=cardDao.qureyByPage(5,"211");
//         for(Card ca:cards) {
//             System.out.println(ca.getId()+"    "+ca.getName());
//         }

//        for(int i=1;i<40;i++){
//        boolean t = cardDao.add(card);
//        System.out.println(t);}
////        int x=cardDao.selectAccount();
//        System.out.println(x);
//        Card card2=new Card("2345","@34","@#23","@#32","233",1);
//        boolean t=cardDao.update(card2);

//        System.out.println(t);
/*        for (int i=1;i<=cardDao.selectAccount();i++) {
            card = cardDao.qurey(i);
            System.out.println(card.getId() + "  " + card.getName() + "  " + card.getCompany());
        }*/
//
//        List<Card> cards=cardDao.qureyByPage(1,"12");
//        for(Card x:cards){
//        System.out.println(x.getId()+"  "+x.getName());}
//    }
//        int i=cardDao.selectAccount1("12");
//        boolean i=cardDao.delete(1,"12");
//        boolean i=cardDao.update(card);
//        System.out.println(i);
}
}
