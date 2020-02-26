package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.ContaPJ;
import utils.JDBCUtils;

public class ContaPJDAO 
{
	
	private static String erro = null;
	
	
    private static final String INSERT_CONTAPJ_SQL = 
    "INSERT INTO TB05_CONTA_PJ " 
    + "(TB05_NUM_AGENCIA, TB05_CNPJ_TITULAR, TB05_SALDO) " 
    + "VALUES (?,?,?);";
    
    private static final String SELECT_CONTAPJ_SQL = 
    "SELECT TB05_NUM_CONTA, TB05_TPO_CONTA, TB05_NUM_AGENCIA, TB05_CNPJ_TITULAR, TB05_SALDO from TB05_CONTA_PJ where TB05_NUM_CONTA = ? and TB05_TPO_CONTA = '02' and TB05_NUM_AGENCIA = ?"; 
    
    private static final String SELECTALL_CONTAPJ_SQL = 
    "SELECT * from TB05_CONTA_PJ ORDER BY TB05_NUM_AGENCIA, TB05_NUM_CONTA"; 
    
    private static final String DELETE_CONTAPJ_SQL = 
    "DELETE from TB05_CONTA_PJ where TB05_NUM_CONTA = ? and TB05_TPO_CONTA = '02' and TB05_NUM_AGENCIA = ?"; 
    
    private static final String UPDATE_CONTAPJ_SQL = 
    "UPDATE TB05_CONTA_PJ set TB05_NUM_AGENCIA=? where TB05_NUM_CONTA = ? and TB05_TPO_CONTA = '02' and TB05_NUM_AGENCIA = ?"; 
    

    
    public static Integer InsereContaPJ(ContaPJ c)
    {
        
    	Integer rowsInserted = 0;
    	
    	try(Connection connection = JDBCUtils.getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTAPJ_SQL);)
    	{
    		preparedStatement.setString(1, c.getNumAgencia());
    		preparedStatement.setString(2, c.getCnpjTitular());
    		preparedStatement.setDouble(3, c.getSaldo());
    		
    		rowsInserted = preparedStatement.executeUpdate();
     	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}    	
    	JDBCUtils.closeConnection();
    	
    	return rowsInserted;
    }
    
    public static ContaPJ selectContaPJ(String numContaPJ, String numAgencia)
    {
        
    	ContaPJ c = null;
    	try(Connection connection = JDBCUtils.getConnection();
        		PreparedStatement ps = connection.prepareStatement(SELECT_CONTAPJ_SQL);)
        	{
        		ps.setString(1, numContaPJ);
                ps.setString(2, numAgencia);
        		ResultSet rs = ps.executeQuery();
        		while(rs.next()) 
        		{
                    Integer numConta = rs.getInt("TB05_NUM_CONTA");
                    String  tpoConta = rs.getString("TB05_TPO_CONTA");
                    String  nAgencia = rs.getString("TB05_NUM_AGENCIA");
                    String  CNPJTitular = rs.getString("TB05_CNPJ_TITULAR");
                    Double  saldo = rs.getDouble("TB05_SALDO");
                    
        			c = new ContaPJ(numConta, tpoConta, nAgencia, CNPJTitular, saldo);
        		}
         	}
        	catch(Exception e)
        	{
        		System.err.println(e.getLocalizedMessage());    		
        	}   	
    	JDBCUtils.closeConnection();
    	return c;
    }
    
    
    public static List <ContaPJ> selectAllContaPJ()
    {
        
    	List <ContaPJ> c = new ArrayList<>();
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(SELECTALL_CONTAPJ_SQL);
    		)
        {
    		System.out.println(ps);
            
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) 
    		{
                 Integer numConta = rs.getInt("TB05_NUM_CONTA");
                 String  tpoConta = rs.getString("TB05_TPO_CONTA");
                 String  numAgencia = rs.getString("TB05_NUM_AGENCIA");
                 String  CNPJTitular = rs.getString("TB05_CNPJ_TITULAR");
                 Double  saldo = rs.getDouble("TB05_SALDO");
                    
                 c.add(new ContaPJ(numConta, tpoConta, numAgencia, CNPJTitular, saldo));
    		}
       	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}     	
    	JDBCUtils.closeConnection();
    	return c;
    }
    
    
    public static Integer deleteContaPJ(String numConta, String numAgencia)
    {
        
    	Integer rowsDeleted = 0;
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(DELETE_CONTAPJ_SQL);
    	   )
    	{
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
    
    
    public static Integer updateContaPJ(ContaPJ c)
    {

    	Integer rowsUpdated = 0;
    	
    	try{
    		Connection connection = JDBCUtils.getConnection();
    		PreparedStatement ps = connection.prepareStatement(UPDATE_CONTAPJ_SQL);
      
    		
    		ps.setString(1, c.getNumNovaAgencia());
    		ps.setInt(2, c.getNumConta());
    		ps.setString(3, c.getNumAgencia());
    
    		rowsUpdated = ps.executeUpdate();
        }
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}    
    	JDBCUtils.closeConnection();
    	return rowsUpdated;
    }
    
    public static String retornaErro()
    {
    	return erro;
    }
    
    
}
