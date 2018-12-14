package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Sems;
import kr.ac.hansung.model.Subject;

@Repository
public class GradeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Sems> getSems() {
		String sqlStatement = "select * from 1494020_semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Sems>() {

			public Sems mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sems sems = new Sems();

				sems.setSyear(rs.getInt("year"));
				sems.setSsemester(rs.getInt("semester"));
				sems.setScredit(rs.getInt("credit"));

				return sems;
			}

		});

	}

	public List<Subject> getSubjectList(int year, int semester) {
		String sqlStatement = "select * from 1494020_sublist where year = " + year + " and semester = " + semester;

		return getList(sqlStatement);
	}

	public boolean registe(String subcode) {
		String sqlStatement = "select * from registersublist where subcode=?";

		Subject subject = jdbcTemplate.queryForObject(sqlStatement, new Object[] { subcode }, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();

				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubcode(rs.getString("subcode"));
				subject.setSubname(rs.getString("subname"));
				subject.setDivision(rs.getString("division"));
				subject.setCredit(rs.getInt("credit"));

				return subject;
			}

		});

		int year = subject.getYear();
		int semester = subject.getSemester();
		String subname = subject.getSubname();
		String division = subject.getDivision();
		int credit = subject.getCredit();

		sqlStatement = "insert into 1494020_regisublist (year,semester,subcode,subname,division,credit) values (?,?,?,?,?,?)";
		return jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, subcode, subname, division, credit }) == 1;
	}

	public List<Subject> getRegisteSubject() {
		String sqlStatement = "select * from registersublist";

		return getList(sqlStatement);
	}

	public List<Subject> getRegistedSubject() {
		String sqlStatement = "select * from 1494020_regisublist";

		return getList(sqlStatement);
	}

	public boolean dropSubject(String subcode) {
		String sqlStatement = "delete from 1494020_regisublist where subcode = ?";

		return jdbcTemplate.update(sqlStatement, new Object[] { subcode }) == 1;
	}
	
	private List<Subject> getList(String sqlStatement){
		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();

				subject.setYear(rs.getInt("year"));
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
