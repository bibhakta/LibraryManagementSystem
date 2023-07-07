/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javatest;

import static org.junit.Assert.*;
/**
 *
 * @author Bibhakta lamsal
 */


public class LoginTest {

    public static void main(String[] args) {
        // Set up test data
        String username= "bib123";
        String password = "9813056161";

        // Invoke the login() method
        String result = loginView(username, password);

        // Verify the result
        assertEquals("bib123, 9813056161", result);   
        System.out.println("Test passed");
    }

    public static String loginView(String username, String password){
        return username+ ", " + password;
    }
}
