package q2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface Person{
      void printName();

      /*A default interface method which returns the topper on the basis of marks obtained
       which is an Optional of Student class*/
      default Optional<Student> getHighScorer(List<Student> studentList){

          Optional<Student> topperOptional=studentList.stream().max(new Comparator<Student>() {
              @Override
              public int compare(Student o1, Student o2) {
                  return o1.marks>o2.marks?o1.marks: o2.marks;
              }
          });
          return topperOptional;

            /* Just For my reference */
//          int[] max= {studentList.get(0).marks};
//          int[] index={0};
//          IntStream.range(1, studentList.size()).forEach(i -> {
//              int studentIMarks = studentList.get(i).marks;
//              if (studentIMarks > max[0]) {
//                  max[0] = studentIMarks;
//                  index[0]=i;
//              }
//          });
//          return studentList.get(index[0]);
      }

      /* A static Method in an Interface which returns the list of failed students
      * and accepts the list of all students*/
      static List<Student> getFailures(List<Student> studentList){
         List<Student> failedStudents=studentList.stream().filter(student->student.marks<35).collect(Collectors.toList());
         return failedStudents;
      }

}

class Student  {
    String name;
    int marks;
    public Student(){
    }
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }

    /*prints the name of the student*/
    public void printName2() {
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

public class ForeachOptionalDefault {
    public static void main(String[] args) {
        Person person=new Student("Shadab",93)::printName2;
        person.printName();

        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student("maaz",98));
        studentList.add(new Student("Bhushan",85));
        studentList.add(new Student("Harshal",28));
        studentList.add(new Student("Shubham",91));
        studentList.add(new Student("Akshay",34));

        /*Default method call*/
        Optional<Student> topperOptional=person.getHighScorer(studentList);
        if(topperOptional.isPresent()){
            System.out.println("\n--------------- Topper ---------------");
            System.out.println(topperOptional.get().name+" : "+topperOptional.get().marks);
        }

        /*Static method call*/
        System.out.println("--------------Failures---------------");
        List<Student> failedStudents=Person.getFailures(studentList);
        failedStudents.forEach(System.out::println);

    }
}
