package org.sakaiproject.gradebookng.tool.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.sakaiproject.service.gradebook.shared.GradeDefinition;
import org.sakaiproject.user.api.User;

/**
 * Model for storing the grade info for a student
 * 
 * @author Steve Swinsburg (steve.swinsburg@gmail.com)
 *
 */
public class StudentGradeInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Getter
	private String studentUuid;
	
	@Getter
	private String studentName;
	
	@Getter
	private String studentEid;
	
	@Getter @Setter
	private String courseGrade;
	
	@Getter
	private Map<Long,GradeInfo> grades;
	
	@Getter @Setter
	private String sectionId;
		
	public StudentGradeInfo(){
	}
	
	public StudentGradeInfo(User u) {
		this.studentEid = u.getId();
		this.studentEid = u.getEid();
		this.studentName = u.getDisplayName();
		this.grades = new HashMap<Long,GradeInfo>();
	}
	
	/**
	 * Helper to add a grade to the map
	 * 
	 * @param assignmentId
	 * @param gd
	 */
	public void addGrade(Long assignmentId, GradeInfo gradeInfo) {
		this.grades.put(assignmentId, gradeInfo);
	}
	
}
