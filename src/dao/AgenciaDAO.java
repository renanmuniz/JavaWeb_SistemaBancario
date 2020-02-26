package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Agencia;
import utils.JDBCUtils;

public class AgenciaDAO 
{
	private static String erro = null;
	
    private static final String INSERT_AGENCIA_SQL = 
    "INSERT INTO TB03_AGENCIA " 
    + "(TB03_NUM_AGENCIA, TB03_ENDERECO, TB03_CIDADE, TB03_ESTADO, TB03_TELEFONE) " 
    + "VALUES (?,?,?,?,?);";
    
    private static final String SELECT_AGENCIA_SQL = 
    "SELECT TB03_NUM_AGENCIA, TB03_ENDERECO, TB03_CIDADE, TB03_ESTADO, TB03_TELEFONE from TB03_AGENCIA where TB03_NUM_AGENCIA = ?"; 
    
    private static final String SELECTALL_AGENCIA_SQL = 
    "SELECT * from TB03_AGENCIA ORDER BY TB03_NUM_AGENCIA"; 
    
    private static final String DELETE_AGENCIA_SQL = 
    "DELETE from TB03_AGENCIA where TB03_NUM_AGENCIA = ?"; 
    
    private static final String UPDATE_AGENCIA_SQL = 
    "UPDATE TB03_AGENCIA set TB03_ENDERECO=?, TB03_CIDADE=?, TB03_ESTADO=?, TB03_TELEFONE=? where TB03_NUM_AGENCIA = ?"; 
    

    
    public static Integer insereAgencia(Agencia ag)
    {        
    	Integer rowsInserted = 0;
    	
    	try(Connection connection = JDBCUtils.getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AGENCIA_SQL);)
    	{
    		preparedStatement.setString(1, ag.getNumAgencia());
    		preparedStatement.setString(2, ag.getEndereco());
    		preparedStatement.setString(3, ag.getCidade());
    		preparedStatement.setString(4, ag.getUf());
    		preparedStatement.setString(5, ag.getTelefone());
    		
    		rowsInserted = preparedStatement.executeUpdate();
     	}
    	catch(Exception e)
    	{
    		System.err.println(e.getLocalizedMessage());
    		erro = e.getMessage();
    	}
    	JDBCUtils.closeConnection();
    	
    	return rowsInserted;
    }
    
    public static Agencia selectAG(String numAgencia)
    {
        
    	Agencia ag = null;
    	
    	try(Connection connection = JDBCUtils.getConnection();
        		PreparedStatement ps = connection.prepareStatement(SELECT_AGENCIA_SQL);)
        	{
        		ps.setString(1, numAgencia);
        		ResultSet rs = ps.executeQuery();
        		while(rs.next()) 
        		{
        			String endereco = rs.getString("TB03_ENDERECO");
        			String cidade = rs.getString("TB03_CIDADE");
        			String uf = rs.getString("TB03_ESTADO");
        			String telefone = rs.getString("TB03_TELEFONE");
        			
        			ag = new Agencia(numAgencia, endereco, cidade, uf, telefone);
        		}
         	}
        	catch(Exception e)
        	{
        		System.err.println(e.getLocalizedMessage());    		
        	}   	
    	JDBCUtils.closeConnection();
    	return ag;
    }
    
    
    
    
    public static List <Agencia> selectAllAG()
    {

        
    	List <Agencia> ags = new ArrayList<>();
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(SELECTALL_AGENCIA_SQL);
    		)
        {
    		System.out.println(ps);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) 
    		{
    			String numAgencia = rs.getString("TB03_NUM_AGENCIA");
    			String endereco = rs.getString("TB03_ENDERECO");
    			String cidade = rs.getString("TB03_CIDADE");
    			String uf = rs.getString("TB03_ESTADO");
    			String telefone = rs.getString("TB03_TELEFONE");
    			ags.add(new Agencia(numAgencia,endereco,cidade,uf,telefone));
    		}
    		
       	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}     	
    	JDBCUtils.closeConnection();
    	return ags;
    }
    
    
    
    public static Integer deleteAgencia(String numAgencia)
    {
        
    	Integer rowsDeleteded = 0;
    	
    	try
    	{
			Connection connection = JDBCUtils.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(DELETE_AGENCIA_SQL);    	   
    	
    		ps.setString(1, numAgencia);
    		
    		rowsDeleteded = ps.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}    	
    	JDBCUtils.closeConnection();
    	return rowsDeleteded;
    }
    
    
    public static Integer updateAgencia(Agencia ag)
    {
        
    	Integer rowUpdated = 0;
    	
    	try{
    		Connection connection = JDBCUtils.getConnection();
    		PreparedStatement ps = connection.prepareStatement(UPDATE_AGENCIA_SQL);
      
    		ps.setString(1, ag.getEndereco());
    		ps.setString(2, ag.getCidade());
    		ps.setString(3, ag.getUf());
    		ps.setString(4, ag.getTelefone());
            ps.setString(5, ag.getNumAgencia());
    		
            rowUpdated = ps.executeUpdate();
        }
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		erro = e.getMessage();
    	}   
    	JDBCUtils.closeConnection();
    	return rowUpdated;
    }
    
    public static String retornaErro()
    {
    	return erro;
    }
    
    

}
