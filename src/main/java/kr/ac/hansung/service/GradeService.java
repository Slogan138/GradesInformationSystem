package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.GradeDAO;
import kr.ac.hansung.model.Subject;

@Service
public class GradeService {
	
	@Autowired
	private GradeDAO gradeDAO;
	
	public List<Subject> getSublist(){
		return gradeDAO.getSubjectList();
	}
	
	public void register(String subcode) {
		gradeDAO.registe(subcode);
	}
	
	public List<Subject> getRegisteSublist(){
		return gradeDAO.getRegisteSubject();
	}
	
	public List<Subject> getRegistedSublist(){
		return gradeDAO.getRegistedSubject();
	}
	
	public void drop(String subcode) {
		gradeDAO.dropSubject(subcode);
	}

}
