package edu.handong.analysis;

import java.util.ArrayList;
import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;


public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student>  initiateStudentArrayFromLines(String[] lines) {
		ArrayList<Student> students =new ArrayList<Student>();	
		for(int i=0; i <lines.length; i++){
		
		  Student student = new Student(lines[i].trim().split(",")[1]) ;
		   
		   if (!studentExist(students, student)){
			   students.add(student);
			   
		   		}
		}
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students1
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		for(Student aStudent:students) {
			if(aStudent != null && aStudent.getName().equals(student.getName()))
				return true;
		}

		return false;
	}
	


	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		ArrayList<Course> courses =new ArrayList<Course>();

		
	
	
		for(int i=0;i<lines.length;i++){
			Course course = new Course(lines[i].split(",")[2].trim());
			if(!courseExist(courses, course)) {
				courses.add(course);
				
			
			}
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		for(Course aCourse:courses) {
			if(aCourse != null && aCourse.getCourseName().equals(course.getCourseName()))
				return true;
		}
		
		return false;
	}

}