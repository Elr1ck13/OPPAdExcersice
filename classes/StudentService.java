package org.generations.classes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generations.exceptions.CourseNotFoundException;
import org.generations.exceptions.StudentNotFoundException;

public class StudentService {
	private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID )
    {
    	
    	try {
    		if (!courseList.containsKey(courseName)) {
    		    throw new CourseNotFoundException("The defined course "+ courseName+" doesn't exist");
			}
    		Course course = courseList.get( courseName );
    		if(!students.containsKey(studentID)) {
    		    throw new StudentNotFoundException("The defined student "+ studentID+" doesn't exist");
			}
    	}
    	catch (CourseNotFoundException e) {
    		System.out.println("Try again with another course name");
		}
    	catch (StudentNotFoundException e) {
    		System.out.println("Try again with another student id");
		}
    	
        

        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( getCourse(courseName) );
    }

    public void unEnrollStudents( String courseName, String studentID )
    {
    	try {
    		if (!courseList.containsKey(courseName)) {
    		    throw new CourseNotFoundException("The defined course "+ courseName+" doesn't exist");
			}
    		Course course = courseList.get( courseName );
    		if(!students.containsKey(studentID)) {
    		    throw new StudentNotFoundException("The defined student "+ studentID+" doesn't exist");
			}
    	}
    	catch (CourseNotFoundException e) {
    		
    		System.out.println("Try again with another course name");
		}
    	catch (StudentNotFoundException e) {
    		System.out.println("Try again with another student id");
		}
        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( getCourse(courseName) );
        }
    }

    public void showEnrolledStudents(String courseId){

    	System.out.println("Los alumnos inscritos en el curso "+ courseId+" son : ");

    	for (String studentId : coursesEnrolledByStudents.keySet()) {
            List<Course> courses = coursesEnrolledByStudents.get(studentId);
            for (Course course : courses) {
                if (course.getName().equals(courseId)) {
                    System.out.println("Student Id: " + studentId);            
                    break; 
                }
            }
        }

    }

    

    public Course getCourse(String key) {
        return courseList.get(key);
    }

   public void addStudent(Student student) {
	   if (! students.containsKey(student.getId())) {
		students.put(student.getId(), student);
	}
   }
    
    public void showAllCourses(){
    	courseList.forEach((key,value) -> System.out.println("Course: " + key));
    }
    
    
}
