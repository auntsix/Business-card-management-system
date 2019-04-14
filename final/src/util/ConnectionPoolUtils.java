package util;

import util.pool.ConnectionPool;

/*连接池工具类，返回唯一的一个数据库连接池对象,单例模式*/
public class ConnectionPoolUtils {
    private ConnectionPoolUtils(){};//私有静态方法
    private static ConnectionPool poolInstance = null;
    public static ConnectionPool GetPoolInstance(){
        if(poolInstance == null) {
            poolInstance = new ConnectionPool();
            try {
                poolInstance.createPool();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return poolInstance;
    }

}