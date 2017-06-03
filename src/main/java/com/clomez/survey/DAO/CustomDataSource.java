package com.clomez.survey.DAO;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by clomez on 27.5.2017.
 */

public class CustomDataSource {

    private static final String user = "xxx";
    private static final String password = "xxxxx";
    private static final String url = "jdbc:mysql://localhost:3306/survey";
    private static final  String driverClassName = "com.mysql.jdbc.Driver";

    public static DriverManagerDataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
