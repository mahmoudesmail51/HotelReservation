/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Mahmoud Esmail
 */
public class CustomerDbUtil {
   private DataSource dataSource;

    public CustomerDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }
   
    public List<Customer> getCustomers() throws SQLException
    {
        List<Customer> customers = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet RS = null;
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "select * from customer";
        
            statement = connection.createStatement();
        
            RS = statement.executeQuery(query);
            
            while(RS.next())
            {
                int id = RS.getInt("id");
                String firstName = RS.getString("firstName");
                String lastName = RS.getString("lastName");
                String userName = RS.getString("userName");
                String password = RS.getString("password");
                String email = RS.getString("email");
                String phoneNumber = RS.getString("phoneNumber");
                
                Customer customerTemp = new Customer(id, firstName, lastName, userName, password,
                email, phoneNumber);
                
                customers.add(customerTemp);
            }
        
        }
        finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
      
        return customers;
    }
    
    

    private void close(Connection connection, Statement statement, ResultSet RS) throws SQLException
    {
        try 
        {
            if(RS != null)
                RS.close();
            
            if (connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
        
    }
      private void close(Connection connection, Statement statement) throws SQLException{
        try 
        {
           
            
            if (connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
        
    }

    boolean addCustomer(Customer tempCustomer) throws SQLException
    {
       boolean flag = false;
       
        Connection connection = null;
        Statement statement = null;
        
        ResultSet RS = null;
        
        // get a connection
        try
        {  
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            
            String query = "select * from customer where userName='"+tempCustomer.getUserName()+"'";
            
            RS = statement.executeQuery(query);
            
            if(!RS.next())
            {
                query = "insert into CUSTOMER(firstName,lastName,userName,password,email,phoneNumber)"
                        + "values('" + tempCustomer.getFirstName() + "','" + tempCustomer.getLastName() + "','" + tempCustomer.getUserName() + "','" + tempCustomer.getPassword() + "','" + tempCustomer.getEmail() + "','" + tempCustomer.getPhoneNumber() + "');";

                statement.executeUpdate(query);
                close(connection, statement);
                flag = true;
            }
        
        }
         finally{
            // close JDBC objects
            close(connection, statement, RS);
        }
       
        
    
       return flag; 
    }

    void updateInfo(Customer tempCustomer) throws SQLException 
    {
        
         Connection connection = null;
        Statement statement = null;
       
        
        try
        {  
            connection = dataSource.getConnection();
            
            String query = "UPDATE CUSTOMER SET firstName='"+tempCustomer.getFirstName()+"',lastName='"+tempCustomer.getLastName()+"',password='"+tempCustomer.getPassword()+"',phoneNumber='"+tempCustomer.getPhoneNumber()+"' WHERE userName='"+tempCustomer.getUserName()+"'; ";
        
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
       
            
        }
        finally{
            // close JDBC objects
            close(connection, statement);
        }
      
    }
    
    
}
