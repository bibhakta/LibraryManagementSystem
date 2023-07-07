/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javatest;
import org.junit.Assert;
/**
 *
 * @author Bibhakta lamsal
 */
public class JavaTest {
       public static void main(String[] args) {
        Assert.assertEquals(16,add(8,7));
        Assert.assertEquals("admin",Login("admin"));
        Assert.assertEquals('A',30);
                }
    public static int add(int x,int y)
    {
        return x+y;
    }
    public static String Login(String username)
    {
        return "admin";
    }
    
   public static char grade(int number)
   {
       if(number>45)
       {
           return 'A';
       }
       else if(number>60)
       {
           return 'B';
       }
       else if(number>80)
       {
           return  'C';
       }
       else{
           return 'D';
       }
   }
}
