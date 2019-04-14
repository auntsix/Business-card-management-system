import dao.daoimpl.userDaoImpl;

import java.sql.SQLException;

public class userDaoimplTest {
    public static void main(String [] args) throws SQLException {
        userDaoImpl userDao = new userDaoImpl();

//        boolean t=userDao.updatepwd("44","444");
        boolean t=userDao.isRegist("128888","11");
        System.out.println(t);

    }
}
