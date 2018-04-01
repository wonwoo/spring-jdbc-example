package ml.wonwoo.springjdbcexample;

import ml.wonwoo.springjdbcexample.jdbc.DdlJdbc;
import ml.wonwoo.springjdbcexample.jdbc.SelectJdbc;
import ml.wonwoo.springjdbcexample.jdbc.UpdateJdbc;
import ml.wonwoo.springjdbcexample.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJdbcExampleApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(DdlJdbc ddlJdbc, UpdateJdbc updateJdbc, SelectJdbc selectJdbc) {
    return args -> {
    ddlJdbc.execute("drop table persons if exists");
    ddlJdbc.execute("create table persons(" +
        "id serial, name varchar(255))");
      updateJdbc.insert("wonwoo");
      updateJdbc.insert("kevin");
      updateJdbc.batchUpdate(Arrays.asList("hello", "world"));
      System.out.println(selectJdbc.findAll());
      System.out.println(selectJdbc.findOne(1L));
      System.out.println(selectJdbc.findAllMap(1L));
      System.out.println(selectJdbc.findId(1L));
      System.out.println(selectJdbc.findAllId());
      System.out.println(selectJdbc.count());
    };
  }
}
