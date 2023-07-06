/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.*;
import view.DashboardView;

/**
 *
 * @author Bibhakta lamsal
 */
public class AddissueController {
    AddissueModel model2;
    DashboardView view;
    ResultSet rs;
    PreparedStatement pst=null;
    private String errorMessage;

    
   
    
    public  AddissueController(DashboardView view)
        {
            
            this.view=view;
            view.addAddissueListner(new AddissueListener());
        }
    
        class AddissueListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                
            model2=view.getIssue();
            if (validateAddissue(model2)) {
                if (checkUser2(model2)) {
                    view.setMessage("Book issued Successfully"); 
                } 
            } else {
                view.setMessage("Validation Error: " + errorMessage);
            }


            }
            catch(Exception e1)
            {
               System.out.println(e1.getMessage());
            }

        }
        
        
      public boolean validateAddissue(AddissueModel addissueModel) {
    // Validate username
    if (addissueModel.getBook_id().isEmpty()) {
        errorMessage = "id is required.";
        return false;
    }

    // Validate firstname
    if (addissueModel.getUser_id().isEmpty()) {
        errorMessage = " name is required.";
        return false;
    }

    // Validate lastname
    if (addissueModel.getIssue_date().isEmpty()) {
        errorMessage = "phonenum is required.";
        return false;
    }

    // Validate gmail
    if (addissueModel.getDuedate().isEmpty()) {
        errorMessage = "father name is required.";
        return false;
    }

    

    // All fields are valid
    errorMessage = null;
    return true;
}

}
       
        public boolean checkUser2(AddissueModel user) throws Exception
        {
           
        try
          {
              
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/app","root","bibhaktadon123");
            String sql="insert into issue(book_id,user_id,issueDate,dueDate,returnBook) values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);

            // String sql="select * from patient where pname='"+user.getUsername()+"' AND paddress='"+user.getPassword()+"'";
            pst.setString(1,user.getBook_id());
            pst.setString(2,user.getUser_id());
            pst.setString(3,user.getIssue_date());
            pst.setString(4,user.getDuedate());
            pst.setString(5,user.getReturnBook());
            pst.executeUpdate();
                    System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null,"book issued Successfully");
            view.clearIssue();
          
          }
          catch(SQLException e2)
          {
              System.out.println(e2.getMessage());
          }         
            
            return false;
        }
   public void clearMe(){
   }

}
