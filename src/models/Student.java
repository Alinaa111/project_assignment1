package models;

import java.util.ArrayList;

public class Student extends Person {
    private int studentID;
    private static int id_gen = 1;
    private ArrayList<Integer> grades;


    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        this.studentID = id_gen++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (0 <= grade && grade <= 100) {
            this.grades.add(grade);
        }
        else {
            System.out.println("Invalid grade");
        }
    }

    public double calculateGpa() {
        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String Gpa() {
        double gpa = calculateGpa();
        if (gpa >= 95 && gpa <= 100) return "4.0 A";
        else if (gpa >= 90 && gpa < 95) return "3.67 A-";
        else if (gpa >= 85 && gpa < 90) return  "3.33 B+";
        else if (gpa >= 80 && gpa < 85) return "3.0 B";
        else if (gpa >= 75 && gpa < 80) return "2.67 B-";
        else if (gpa >= 70 && gpa < 75) return  "2.33 C+";
        else if (gpa >= 65 && gpa < 70) return "2.0 C";
        else if (gpa >= 60 && gpa < 65) return "1.67 C-";
        else if (gpa >= 54 && gpa < 60) return  "1.33 D+";
        else if (gpa >= 50 && gpa < 55) return "1.0 D";
        else if (gpa >= 25 && gpa < 50) return "0 FX";
        else if (gpa >= 0 && gpa < 25) return "0 F";
        else return "Invalid gpa and grades";
    }

    public int getId() {
        return studentID;
    }


    @Override
    public String toString() {
        return super.toString() + "I am a student with ID " + studentID + ".";
    }

}
