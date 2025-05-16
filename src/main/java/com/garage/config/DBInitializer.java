/*package com.garage.repository;
*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
       private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
       String createDatabaseSQL = "IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'DbGarage') "
                   + "BEGIN "
                   + "CREATE DATABASE DbGarage;"
                   + "END";

       jdbcTemplate.execute(createDatabaseSQL);
    }
}
*/