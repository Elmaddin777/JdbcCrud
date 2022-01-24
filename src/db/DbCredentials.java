package db;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class DbCredentials {

    private String user;
    private String passwrod;
    private String dbUrl;
    private final Properties props = new Properties();

    public DbCredentials(String user, String password, String dbUrl) throws IOException {
        props.load(new FileInputStream("demo.properties"));
        setPropertiesForProp(user, password, dbUrl);
        getPropertiesFromProp();
    }

    public DbCredentials() throws IOException {
        props.load(new FileInputStream("demo.properties"));
        getPropertiesFromProp();
    }

    private void getPropertiesFromProp(){
        this.user = props.getProperty("username");
        this.passwrod = props.getProperty("password");
        this.dbUrl = props.getProperty("dburl");
    }

    private void setPropertiesForProp(String user, String password, String dbUrl){
        props.setProperty("username", user);
        props.setProperty("password", password);
        props.setProperty("dburl", dbUrl);
    }


    public String getUser() {
        return user;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public String getDbUrl() {
        return dbUrl;
    }
}
