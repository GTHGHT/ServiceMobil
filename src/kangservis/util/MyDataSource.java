package kangservis.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDataSource {
    public static DataSource getDataSource(){
        Properties prop = new Properties();
        try(InputStream is = MyDataSource.class.getResourceAsStream("/kangservis/util/db.properties")){
            prop.load(is);
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(prop.getProperty("DB_URL"));
            dataSource.setUser(prop.getProperty("DB_USER"));
            dataSource.setPassword(prop.getProperty("DB_PASSWORD"));
            return dataSource;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
