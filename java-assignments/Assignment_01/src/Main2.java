public class Main2 {
    public static String getReversedWord(String word){
        String reversedWord="";
        for(int i=word.length()-1;i>=0;i--){
            reversedWord+=word.charAt(i);
        }
        return reversedWord;
    }
    public static boolean checkPallindrome(String word){
//        System.out.println(getReversedWord(word));
        if(getReversedWord(word).equals(word)){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) {
            Person person=new Person("maaz",26);
            System.out.println("\n"+person);

            Person student=new Student("Bhushan",34,100,"Java","IT");
            Person teacher =new Teacher("Nihal",45,"CS","masters in software development");

            System.out.println("\n2) ----------Student-------------\n");
            System.out.println(student);
            System.out.println(teacher);

            TalkingClass talkingClass=new TalkingClass(student);
            System.out.println("\n 3) --------------------------- ");
            talkingClass.talk();
            talkingClass.talk(student);
            System.out.println("\n 4) --------------------------- ");
            String word="orrarro";
            if(checkPallindrome(word)){
                System.out.println(word+" is a Pallindrome word");
            }
            else{
                System.out.println(word+" is not a Pallindrome word");
            }
        }
    }
