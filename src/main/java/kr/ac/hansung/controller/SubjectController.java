package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Sems;
import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.GradeService;

@Controller
public class SubjectController {

	@Autowired
	private GradeService gradeService;

	@RequestMapping("/showSemester")
	public String showSemester(Model model) {
		List<Sems> sems = gradeService.getSems();
		model.addAttribute("sems", sems);
		return "semester";
	}

	@RequestMapping("/registeSubject")
	public String registerSubject(@RequestParam(value = "subcode", required = false) String subcode, Model model) {
		List<Subject> subjects = gradeService.getRegisteSublist();
		model.addAttribute("sublist", subjects);
		if (subcode != null) {
			gradeService.register(subcode);
		}
		return "registeSubject";
	}

	@RequestMapping("/showRegistedSubject")
	public String showRegisteSubject(@RequestParam(value = "subcode", required = false) String subcode, Model model) {
		List<Subject> subjects = gradeService.getRegistedSublist();
		model.addAttribute("subjects", subjects);
		if (subcode != null) {
			gradeService.drop(subcode);
		}
		return "showregistedsubject";
	}

	@RequestMapping("/showSubject")
	public String showSubject(@RequestParam(value = "year", required = false) int year,
			@RequestParam(value = "semester", required = false) int semester, Model model) {
		List<Subject> subjects = gradeService.getSublist(year,semester);
		model.addAttribute("sublist", subjects);
		return "showsubjects";
	}

}
