package au.com.alpha.demo.service;

import au.com.alpha.demo.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Service class which handles all Issue logic
 */

@Repository
public class IssueService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Issue findById(long id) {
        return jdbcTemplate.queryForObject("select * from issue_tracker.issue where id=?", new Object[]{
                        id
                },
                new BeanPropertyRowMapper<Issue>(Issue.class));

    }

    public List< Issue > findAll() {
        return jdbcTemplate.query("select * from issue_tracker.issue", new BeanPropertyRowMapper<Issue>(Issue.class));
    }


    public int deleteById(long id) {
        return jdbcTemplate.update("delete from issue_tracker.issue where id=?", new Object[] {
                id
        });
    }
    public int insert(Issue issue) {
        return jdbcTemplate.update("insert into issue_tracker.issue (id, title, description) " + "values(?,  ?, ?)",
                new Object[] {
                        issue.getId(), issue.getTitle(), issue.getDescription()
                });
    }
    public int update(Issue issue) {
        return jdbcTemplate.update("update student " + " set title = ?, description = ? " + " where id = ?",
                new Object[] {
                        issue.getTitle(), issue.getDescription(), issue.getId()
                });
    }
}
