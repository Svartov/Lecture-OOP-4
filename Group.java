package sample;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public  Group(String groupName, Student [] students){
        super();
        this.students = students;
        this.groupName = groupName;
    }

    public Group(){
        super();
    }

    // Get
    public String getGroupName(){
        return  groupName;
    }
    public Student[] getStudents(){
        return students;
    }

    // Set

    public  void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public void setStudent(Student[] students){
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        for(int i = 0; i < students.length; i++){
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
        for(int i = 0; i < students.length; i++){
            if(students[i] != null){
                if(students[i].getLastName().equals(lastName)){
                    return students[i];
                }
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id){
        for(int i = 0; i < students.length; i++){
            if(students[i] != null){
                if(students[i].getId() == id){
                    students[i] = null;
                    return  true;
                }
            }
        }
        return  false;
    }

    public void SortStudentsByLastName(){
        Arrays.sort(students, Comparator.nullsFirst(new SortStudentsByLastName()));
        for(int i = 0; i < students.length; i++){
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "[" + "Students = " + Arrays.toString(students) + " GroupName = " + groupName + "]";
    }

}