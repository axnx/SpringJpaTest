package de.axnx;

import java.sql.*;   

public class TestDBConnection {
	
  private final static String DB_URL = "jdbc:sqlserver://localhost;databaseName=DBLIC";
  private final static String USER = "sa";
  private final static String PASS = "sasql";

  public static void main(String[] args) {
    Connection conn = null;  
    try {    
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
      System.out.println("Connecting to database...");    
      conn = DriverManager.getConnection(DB_URL,USER,PASS);    
    } catch (Exception e) {    
      e.printStackTrace();    
    } finally {    
      if (conn != null) {    
        try {    
          conn.close();    
        } catch (SQLException e) {    
          // ignore    
        }    
      }    
    }            
  }    
}