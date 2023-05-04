package data.gradeBook;

public class gradeBookMain {
	public static void main(String[] args) {
		int[][] gradesArray = {{89,23,45},{56,12,34},{34,90,9},
				{32,31,67},{12,8,9},{3,45,78},
				{90,100,84},{98,87,65},{64,92,26},
				{42,31,27}};
		
		GradeBook schoolGradeBook = new GradeBook(gradesArray,"Java How to Program");
		
		schoolGradeBook.processGrades();
		System.out.println(schoolGradeBook.getCourseName());
		System.out.println("Highest grade is: "+schoolGradeBook.getMaximum()+"\nlowest grade is: "+ schoolGradeBook.getMinimum());
		schoolGradeBook.outputGrades();
	}
}
