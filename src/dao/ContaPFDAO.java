package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.ContaPF;
import utils.JDBCUtils;

public class ContaPFDAO 
{
	
	public static String erro = null;
	
    private static final String INSERT_CONTAPF_SQL = 
    "INSERT INTO TB04_CONTA_PF " 
    + "(TB04_NUM_AGENCIA, TB04_CPF_TITULAR, TB04_SALDO) " 
    + "VALUES (?,?,?);";
    
    private static final String SELECT_CONTAPF_SQL = 
    "SELECT TB04_NUM_CONTA, TB04_TPO_CONTA, TB04_NUM_AGENCIA, TB04_CPF_TITULAR, TB04_SALDO from TB04_CONTA_PF where TB04_NUM_CONTA = ? and TB04_TPO_CONTA = '01' and TB04_NUM_AGENCIA = ?"; 
    
    private static final String SELECTALL_CONTAPF_SQL = 
    "SELECT * from TB04_CONTA_PF ORDER BY TB04_NUM_AGENCIA, TB04_NUM_CONTA"; 
    
    private static final String DELETE_CONTAPF_SQL = 
    "DELETE from TB04_CONTA_PF where TB04_NUM_CONTA = ? and TB04_TPO_CONTA = '01' and TB04_NUM_AGENCIA = ?"; 
    
    private static final String UPDATE_CONTAPF_SQL = 
    "UPDATE TB04_CONTA_PF set TB04_NUM_AGENCIA=? where TB04_NUM_CONTA = ? and TB04_TPO_CONTA = '01' and TB04_NUM_AGENCIA = ?"; 
    

    
    public static Integer InsereContaPF(ContaPF c)
    {
        
    	Integer rowsInserted = 0;
    	
    	try(Connection connection = JDBCUtils.getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTAPF_SQL);)
    	{
    		preparedStatement.setString(1, c.getNumAgencia());
    		preparedStatement.setString(2, c.getCpfTitular());
    		preparedStatement.setDouble(3, c.getSaldo());
    		
    		rowsInserted = preparedStatement.executeUpdate();
    		
    		
     	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}
    	JDBCUtils.closeConnection();
    	return rowsInserted;
    }
    
    public static ContaPF selectContaPF(String numContaPF, String numAgencia)
    {
        
    	ContaPF c = null;
    	try(Connection connection = JDBCUtils.getConnection();
        		PreparedStatement ps = connection.prepareStatement(SELECT_CONTAPF_SQL);)
        	{
        		ps.setString(1, numContaPF);
                ps.setString(2, numAgencia);
        		ResultSet rs = ps.executeQuery();
        		while(rs.next()) 
        		{
                    Integer numConta = rs.getInt("TB04_NUM_CONTA");
                    String  tpoConta = rs.getString("TB04_TPO_CONTA");
                    String  nAgencia = rs.getString("TB04_NUM_AGENCIA");
                    String  cpfTitular = rs.getString("TB04_CPF_TITULAR");
                    Double  saldo = rs.getDouble("TB04_SALDO");
                    
        			c = new ContaPF(numConta, tpoConta, nAgencia, cpfTitular, saldo);
        		}
         	}
        	catch(Exception e)
        	{
        		System.err.println(e.getLocalizedMessage());    		
        	}   	
    	JDBCUtils.closeConnection();
    	return c;
    }
    
    
    public static List <ContaPF> selectAllContaPF()
    {

        
    	List <ContaPF> c = new ArrayList<>();
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(SELECTALL_CONTAPF_SQL);
    		)
        {
    		System.out.println(ps);
            
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) 
    		{
                 Integer numConta   = rs.getInt("TB04_NUM_CONTA");
                 String  tpoConta   = rs.getString("TB04_TPO_CONTA");
                 String  numAgencia = rs.getString("TB04_NUM_AGENCIA");
                 String  cpfTitular = rs.getString("TB04_CPF_TITULAR");
                 Double  saldo      = rs.getDouble("TB04_SALDO");
                 
                 //paenas para teste, retirar depois.
                 System.out.println("numConta: " + numConta);
                 System.out.println("tpoConta: " + tpoConta);
                 System.out.println("numAgencia: " + numAgencia);
                 System.out.println("cpfTitular: " + cpfTitular);
                 System.out.println("saldo: " + saldo);
                 // ------------------------------------------------
                 
                 c.add(new ContaPF(numConta, tpoConta, numAgencia, cpfTitular, saldo));
    		}
       	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}     
    	JDBCUtils.closeConnection();
    	return c;
    }
    
    
    public static Integer deleteContaPF(String numConta, String numAgencia)
    {
        
    	Integer rowsDeleted = 0;
    	
    	try
    	{
    		Connection connection = JDBCUtils.getConnection();
    	
    		PreparedStatement ps = connection.prepareStatement(DELETE_CONTAPF_SQL);
    	
    		ps.setString(1, numConta);
            ps.setString(2, numAgencia);
            
    		rowsDeleted = ps.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}
    	JDBCUtils.closeConnection();
    	return rowsDeleted;
    }
    
    
    public static Integer updateContaPF(ContaPF c)
    {
        
    	Integer rowUpdated = 0;
    	
    	try{
    		Connection connection = JDBCUtils.getConnection();
    		
    		PreparedStatement ps = connection.prepareStatement(UPDATE_CONTAPF_SQL);
      
    		ps.setString(1, c.getNumAgenciaNovo());    		
    		ps.setInt(2, c.getNumConta());
    		ps.setString(3, c.getNumAgencia());    		
    
    		rowUpdated = ps.executeUpdate();
        }
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}
    	JDBCUtils.closeConnection();
    	
    	System.out.println("Updated: " + rowUpdated);
    	
    	return rowUpdated;
    }
    
    public static String retornaErro()
    {
    	return erro;
    }
    
    
    
}
