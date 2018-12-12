package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Subject {
	
	private int year;
	private int semester;
	private String subcode;
	private String subname;
	private String division;
	private int credit;

}
