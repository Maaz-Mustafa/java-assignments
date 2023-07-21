package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean("student", Student.class);
        Address address=student.getAddress();
        System.out.println("User: " + student.getName());
        System.out.println("address : "+address.getCity()+","+address.getState()+","+address.getCountry());

    }
}