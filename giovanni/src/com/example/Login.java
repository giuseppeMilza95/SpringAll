package com.example;

import java.io.Console;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    private String username;
    private String email;
    private String password;
    private Scanner scanner;



    public Login() {
        this.scanner = new Scanner(System.in);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loginIntoTheApp(){
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        if (email.equals(this.email) && password.equals(this.password)){
            System.out.println("Access granted");


        }else{
            System.out.println("You do not have the permission");
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
