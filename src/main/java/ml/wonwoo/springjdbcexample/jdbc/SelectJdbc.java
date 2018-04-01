package ml.wonwoo.springjdbcexample.jdbc;

import ml.wonwoo.springjdbcexample.model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class SelectJdbc {

  private final JdbcTemplate jdbcTemplate;

  public SelectJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Map<String, Object> findAllMap(Long id) {
    return this.jdbcTemplate.queryForMap("SELECT id FROM persons where id = ?", id);
  }

  public Person findOne(Long id) {
    return this.jdbcTemplate.queryForObject("SELECT id, name FROM persons where id = ?",
        (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name")),
        id);
  }

  public List<Person> findAll() {
    return this.jdbcTemplate.query("SELECT id, name FROM persons",
        (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name")), 1);
  }

  public Long findId(Long id) {
    return this.jdbcTemplate.queryForObject("SELECT id FROM persons where id = ?", Long.class, id);
  }

  public List<Long> findAllId() {
    return this.jdbcTemplate.queryForList("SELECT id FROM persons", Long.class);
  }

  public int count() {
    return this.jdbcTemplate.queryForObject("SELECT count(id) FROM persons", int.class);
  }
}
