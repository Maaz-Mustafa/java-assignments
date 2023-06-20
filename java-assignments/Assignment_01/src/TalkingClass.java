public class TalkingClass {
    private Person person;

    public TalkingClass(Person person){
        this.person=person;
    }
    public static void talk(){
        System.out.println("Hello");
    }

//    public static  void talk(String name){
//        System.out.println("Hello "+name);
//    }
    public void talk(Person person){
        System.out.println("Hello "+person.getName());
        if(person instanceof Student){
            System.out.println("Role     :- Student");
            System.out.println("Roll no. :- "+((Student) person).getRollNo());
        } else if (person instanceof Teacher) {
            System.out.println("Role           :- Teacher");
            System.out.println("Specialization :- "+((Teacher) person).getSpecialization());
        } else {
            System.out.println("Not an Entity");
        }
    }
}
