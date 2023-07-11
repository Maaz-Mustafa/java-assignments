package q1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Person{
    void printName();

    /* To check if we can write default methods in functional interfaces :- yes we can but it is not a good practice
    * because by the definition Functional interfaces are supposed to have one single abstract method which is used
    * in method Referencing or lambda expressions*/

//    default int addition(int a,int b){
//        return a+b;
//    }
}

class Student implements Person{
    String name;
    int marks;
    public Student(){
    }
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }

    /*prints the name of the student*/
    @Override
    public void printName() {
        System.out.println("Name : "+name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class Teacher implements Person{
    String name;
    String subject;
    public Teacher(){}
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void printName() {

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}

public class StreamLambdaSAM {
    public static void main(String[] args) {
        Person person=new Student("Shadab",93)::printName;
        System.out.println("\n------------Refernce Method call()-----------");
        person.printName();

        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student("maaz",98));
        studentList.add(new Student("Bhushan",85));
        studentList.add(new Student("Harshal",61));
        studentList.add(new Student("Shubham",29));
        studentList.add(new Student("Akshay",34));

        int maxScore=studentList.get(0).marks;
        Student topper=studentList.get(0);
        for(Student student:studentList){
            if(student.marks>maxScore){
                maxScore=student.marks;
                topper=student;
            }
        }
        System.out.println("--------------- Topper ---------------");
        System.out.println(topper);

        System.out.println("------------ Failures --------------");
        List<Student> failedStudents=studentList.stream().filter(student->student.marks<35).collect(Collectors.toList());
        failedStudents.stream().forEach(System.out::println);

        System.out.println("-------------Teachers and Students concat----------------");
        List<Teacher> teachersList=new ArrayList<Teacher>();
        teachersList.add(new Teacher("Ishaque","Maths"));
        teachersList.add(new Teacher("Kulkarni","Physics"));
        teachersList.add(new Teacher("Halke","Chemistry"));
        teachersList.add(new Teacher("Mane","Biology"));

        Stream<Person> combinedList= Stream.concat(studentList.stream(),teachersList.stream());
        combinedList.forEach(System.out::println);

    }



}
