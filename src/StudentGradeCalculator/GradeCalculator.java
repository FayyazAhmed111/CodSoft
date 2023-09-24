package StudentGradeCalculator;

import java.util.Scanner;

public class GradeCalculator {
    static void CalculateGrade(){
        Scanner scan = new Scanner(System.in);
        float totalMarks = 0;
        float averagePercentage;

        System.out.print("Enter the number of subjects: ");
        int subjects = scan.nextInt();
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            float marks = scan.nextFloat();
            totalMarks += marks;
        }

        averagePercentage = totalMarks / (float) subjects;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        }
        else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage+"%");
        System.out.println("Grade: " + grade);

    }

    public static void main(String[] args) {
        CalculateGrade();
    }
}

