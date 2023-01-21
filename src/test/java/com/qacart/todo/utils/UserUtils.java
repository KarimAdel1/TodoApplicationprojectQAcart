package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {

    public static User generateRandomUser(){

        String firstname = new Faker().name().firstName();
        String lastname = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();

            User user =new User(firstname,lastname,email,password);

            return user;



    }
}
