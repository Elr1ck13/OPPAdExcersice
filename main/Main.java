package org.generations.main;

import org.generations.classes.Student;
import org.generations.classes.StudentService;

public class Main {
	 public static void main(String[] args) {
		    StudentService studentService = new StudentService();
		    studentService.addStudent( new Student( "Carlos", "1030", 31 ) );
	        studentService.addStudent( new Student ( "Ian", "1040", 28 ) );
	        studentService.addStudent( new Student ( "Elise", "1050", 26 ) );
	        studentService.addStudent( new Student ( "Santiago", "1020", 33 ) );

	        studentService.enrollStudents( "Math", "1030" );
	        studentService.enrollStudents( "Math", "100" );
	        studentService.showEnrolledStudents("Math");
	        studentService.showAllCourses();
	}
}
