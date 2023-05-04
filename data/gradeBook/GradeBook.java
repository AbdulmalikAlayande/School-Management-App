package data.gradeBook;

public class GradeBook {
	private final int[][] grades;
	private String courseName;
	
	    public GradeBook(int[][] grades, String courseName){
	        this.grades = grades;
	        this.courseName = courseName;
	    }
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getCourseName()  {
			return courseName;
		}
	    public void processGrades(){
	        displayBarChart();
	    }
	
	    private void displayBarChart() {
			int[] frequency = new int[11];
		    for (int[] eachGradeList : grades) {
			    for (int eachGrade : eachGradeList) {
					++frequency[eachGrade/10];
			    }
		    }
		    int i;
		    for (i = 0; i < frequency.length; i++) {
			    int gradeRange = (i * 10);
				if (i == 10)
					System.out.printf("\t  %02d%s",gradeRange, ": ");
				else System.out.printf("%02d%s%02d%s",gradeRange, " --> ",(gradeRange+9), ": ");
			    for (int j = 0; j < frequency[i]; j++) {
				    System.out.print("*");
			    }
			    System.out.println();
		    }
	    }
	
	    public String getAverage(int[] grade) {
	        int sum = 0;
		    double studentAverage;
		
		    for (int theGrade: grade) {
				sum+=theGrade;
		    }
			studentAverage = (double) sum/grade.length;
			return String.format("%.2f",studentAverage);
	    }
	
	    public int getMaximum() {
	        int highestGrade = grades[0][0];
	        for (int[] grade : grades) {
	            for (int theGrade : grade) {
	                if (theGrade > highestGrade) {
	                    highestGrade = theGrade;
	                }
	            }
	        }
	        return highestGrade;
	    }
	
	    public int getMinimum() {
	
	        int lowestGrade = grades[0][0];
	        for (int[] grade: grades) {
	            for (int theGrade: grade) {
	               if (theGrade < lowestGrade){
	                   lowestGrade = theGrade;
	               }
	            }
	        }
	        return lowestGrade;
	    }
		public void outputGrades(){
			int counter =1;
			System.out.printf("%5s%5s%5s%5s%n","\t\t\t\tTest1\t\t","Test2\t\t","Test3\t\t","Average");
			for (int[] grade: grades) {
				System.out.print("Student" +counter+"\t\t");
				for (int theGrade: grade) {
					System.out.printf("%02d%s",theGrade, "\t\t\t");
				}
				System.out.print(getAverage(grade));
				System.out.println();
				counter++;
			}
		}
}
