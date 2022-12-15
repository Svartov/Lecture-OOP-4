package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Program {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Student student1 = new Student("Davyd", "Svartov",Gender.Man, 3, "231");
        Student student2 = new Student("Vasya", "Velkons",Gender.Man, 1, "231");
        Student student3 = new Student("Alex", "Zikelson",Gender.Man, 5, "231");
        Student student4 = new Student("Dima", "Visko",Gender.Man, 2, "231");
        Student student5 = new Student("Harald", "Bjørnsøk",Gender.Man, 6, "231");
        Student student6 = ScannerStudents.ScannerStudents();

        Group groupA = new Group();

        try {
           groupA.addStudent(student1);
           groupA.addStudent(student2);
           groupA.addStudent(student3);
           groupA.addStudent(student4);
           groupA.addStudent(student5);
           groupA.addStudent(student6);
        }catch (GroupOverflowException e){
            e.printStackTrace();
        }

        Student [] students = new Student[]{student1, student2, student3, student4, student5, student6};
        Arrays.sort(students, Comparator.nullsFirst(new SortStudentsByLastName()));
        for(int i = 0; i < students.length; i++){
            System.out.println(students[i]);
        }
    }



}