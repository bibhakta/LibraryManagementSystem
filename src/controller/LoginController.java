/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import model.*;
import view.*;
import java.sql.*;

/**
 *
 * @author Bibhakta lamsal
 */
public class LoginController {
     LoginModel model;
    LoginView view;
    ResultSet rs;
    Statement stmt;
    public LoginController(LoginView view)
    {
        this.view=view;
        new LoginListener().actionPerformed();
        
    }
    class LoginListener
    {
        public void actionPerformed() {
            try
            {
                model=view.getUser();
                if(checkUser(model))
                {
                    view.setMessage("Login Successfully");
                }
                else
                {
                    view.setMessage("Invalid username or password");
                    
                }
            }
            catch(Exception e1)
            {
                
            }

        }
        public boolean checkUser(LoginModel user) throws Exception
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/app","root","bibhaktadon123");
          String sql="select * from registration where username='"+user.getUsername()+"' AND password='"+user.getPassword()+"'";
          try
          {
            stmt=conn.createStatement();
             rs=stmt.executeQuery(sql);
             if(rs.next())
             {
                 return true;
             }
             conn.close();
            
          
          }
          catch(Exception e2)
          {
              System.out.println(e2.getMessage());
          }         
            
            return false;
        }
        
    }
    
    
}
