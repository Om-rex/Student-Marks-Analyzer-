import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double calculateAverage() {
        return (double) calculateTotal() / marks.length;
    }

    int findHighest() {
        int highest = marks[0];

        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    int findLowest() {
        int lowest = marks[0];

        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    void displayResult() {
        System.out.println("\n----- Student Result -----");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average: " + calculateAverage());
        System.out.println("Highest Marks: " + findHighest());
        System.out.println("Lowest Marks: " + findLowest());
        System.out.println("Grade: " + calculateGrade());
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = sc.nextInt();

        int[] marks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {

            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                int mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                }

                System.out.println("Invalid marks! Enter marks between 0 and 100.");
            }
        }

        Student student = new Student(name, marks);

        student.displayResult();

        sc.close();
    }
}
