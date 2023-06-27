package q3;

public class MyClass {
        static int a = 20;
        static {
            a++;
        }
        {
            a++;
            System.out.println(a);
        }
        public static void main(String[] args) {
            MyClass obj = new MyClass();
            MyClass obj2 = new MyClass();
            MyClass obj3 = new MyClass();
        }
}

/*
*   Output :- 22,23,24
*
*   Explaination :-
*        This is because the static block will only once executed when the class is loaded in the memory
*        so at first value of a will be incremented to 21
*        but the instance block will execute everytime when the class is instantiated hence it will print all three times
*        the increamented value of a, starting with 22.
*
* */