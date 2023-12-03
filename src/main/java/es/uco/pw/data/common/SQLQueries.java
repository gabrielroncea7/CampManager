package es.uco.pw.data.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SQLQueries {
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = SQLQueries.class.getResourceAsStream("sql.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getQuery(String key) {
        return properties.getProperty(key);
    }
}

