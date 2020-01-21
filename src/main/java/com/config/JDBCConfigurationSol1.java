package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Slf4j
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JDBCConfigurationSol1 {
	
	
	@Bean
    public static Connection getConnection(){		

		Connection connection = null;
		
		try {
		      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		      connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/ville_france?user=root&password=password");
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return connection;
	
    }
    
}
