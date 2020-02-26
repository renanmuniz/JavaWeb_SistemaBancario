package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JDBCUtils
{                                         
    private static final String jdbcURL = "jdbc:mysql://127.0.0.1:3306/sistemabancario?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "3885";
	
	static Connection connection = null;
	

	
    public static final Connection getConnection()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    		System.out.println("Conexão ao banco de dados estabelecida com sucesso.");
    	}catch (Exception e) {
    		System.out.println("Conexão ao banco de dados falhou!");
    		e.printStackTrace();
		}
    	return connection;
    }
    
    public static final void closeConnection()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        
    	if (connection == null)
    	{
    		System.out.println("Não há conexôes a serem encerradas.");
    	}
    	else
    	{
    		try {
				connection.close();
				System.out.println("Conexão ao banco de dados encerrada.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    
    //Ver se vai usar, senão apagar:
	public static void printSQLException(SQLException ex)
	{
		
		for(Throwable e: ex)
		{
			if(e instanceof SQLException)
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while(t != null) 
				{
					t = t.getCause();
					System.out.println("Cause: " +t);
					
				}
			}
		}
	}
	//-------------------------------------

}
