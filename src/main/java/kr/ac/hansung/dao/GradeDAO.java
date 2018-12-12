package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;


@Repository
public class GradeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Subject> getSubjectList() {
		String sqlStatement = "select * from 1494020_sublist";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();

				subject.setYear(rs.getInt("Year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubcode(rs.getString("subcode"));
				subject.setSubname(rs.getString("subname"));
				subject.setDivision(rs.getString("division"));
				subject.setCredit(rs.getInt("credit"));

				return subject;
			}

		});
	}

}
