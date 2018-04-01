package ml.wonwoo.springjdbcexample.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DdlJdbc {

  private final JdbcTemplate jdbcTemplate;

  public DdlJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void execute(String sql) {
    this.jdbcTemplate.execute(sql);
  }
}
