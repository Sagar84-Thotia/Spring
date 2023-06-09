package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student)
	{
		//insert query
		String query = "insert into Student(Id,Name,City) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}
	
	public int change(Student student)
	{
		//updating data
		String query = "update student set Name=? , City=? where Id=? ";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(int  studentId)
	{
		// delete operation
		String query = "delete from student where Id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	public Student getStudent(int studentId)
	{
		//selecting single student data
		String query = "select * from student where Id=?";
		//parent                 // childclassobject 
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student =this.jdbcTemplate.queryForObject(query, rowMapper , studentId);
		return student;
	}

	public List<Student> getAllStudents()
	{
		// selecting multiple student;
		String query="select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() 
	{
		return jdbcTemplate;
	}

//	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	
}
