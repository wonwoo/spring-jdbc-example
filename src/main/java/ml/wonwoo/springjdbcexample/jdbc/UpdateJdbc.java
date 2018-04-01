package ml.wonwoo.springjdbcexample.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdateJdbc {

  private final JdbcTemplate jdbcTemplate;

  public UpdateJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int insert(String name) {
    return jdbcTemplate.update("insert into persons (name) values (?)", name);
  }

  public void batchUpdate(List<String> name) {
    List<Object[]> ts = name.stream().map(i -> new Object[]{i}).collect(Collectors.toList());
    this.jdbcTemplate.batchUpdate("insert into persons (name) values (?)", ts);
  }
}
