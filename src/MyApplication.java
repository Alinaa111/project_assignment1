import models.Person;
import models.School;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        File file1 = new File("src/students.txt");
        Scanner sc1 = new Scanner(file1);

        File file2 = new File("src/teachers.txt");
        Scanner sc2 = new Scanner(file2);

        School group = new School("Hogwarts School");

        while (sc1.hasNext()){
            Student student = new Student(sc1.next(),sc1.next(), sc1.nextInt(),sc1.next());
            while (sc1.hasNextInt()){
                student.addGrade(sc1.nextInt());
            }
            group.addMember(student);
        }
        while (sc2.hasNext()){
            Teacher teacher = new Teacher(sc2.next(),sc2.next(), sc2.nextInt(),sc2.next(),sc2.next(),sc2.nextInt(),sc2.nextInt());
            group.addMember(teacher);
        }

        System.out.println(group);

        for (Student student : group.getStudents()) {
            System.out.println(student.getName() + " " + student.getSurname() + ", GPA: " + student.Gpa());
        }
        System.out.println("\n");
        for (Teacher teacher : group.getTeachers()) {
            teacher.giveRaise(10);
            System.out.println(teacher.getName() + " " + teacher.getSurname() + ", salary: " + teacher.getSalary());
        }

    }
}
