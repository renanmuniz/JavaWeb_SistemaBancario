package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.PessoaFisica;
import utils.JDBCUtils;

public class PessoaFisicaDAO 
{

    private static String erro;
    
    private static final String INSERT_PESSOA_FISICA_SQL = 
    "INSERT INTO TB01_PESSOA_FISICA " 
    + "(TB01_CPF, TB01_NOME, TB01_ENDERECO, TB01_CIDADE, TB01_UF, TB01_TELEFONE) " 
    + "VALUES (?,?,?,?,?,?);";
    
    private static final String SELECT_PESSOA_FISICA_SQL = 
    "SELECT TB01_CPF, TB01_NOME, TB01_ENDERECO, TB01_CIDADE, TB01_UF, TB01_TELEFONE from TB01_PESSOA_FISICA where TB01_CPF = ?"; 
    
    private static final String SELECTALL_PESSOA_FISICA_SQL = 
    "SELECT * from TB01_PESSOA_FISICA ORDER BY TB01_NOME, TB01_CPF"; 
    
    private static final String DELETE_PESSOA_FISICA_SQL = 
    "DELETE from TB01_PESSOA_FISICA where TB01_CPF = ?"; 
    
    private static final String UPDATE_PESSOA_FISICA_SQL = 
    "UPDATE TB01_PESSOA_FISICA set TB01_NOME=?, TB01_ENDERECO=?, TB01_CIDADE=?, TB01_UF=?, TB01_TELEFONE=? where TB01_CPF = ?"; 
    

    
    public static Integer inserePessoaFisica(PessoaFisica pf)
    {
        
    	Integer rowsInserted = 0;
    	
    	try
    	{
    		Connection connection = JDBCUtils.getConnection();
    	
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PESSOA_FISICA_SQL);
    	
    		preparedStatement.setString(1, pf.getCpf());
    		preparedStatement.setString(2, pf.getNome());
    		preparedStatement.setString(3, pf.getEndereco());
    		preparedStatement.setString(4, pf.getCidade());
    		preparedStatement.setString(5, pf.getUf());
    		preparedStatement.setString(6, pf.getTelefone());
     	
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
    
    public static PessoaFisica selectPF(String cpf)
    {
        
    	PessoaFisica pf = null;
    	try(Connection connection = JDBCUtils.getConnection();
        		PreparedStatement ps = connection.prepareStatement(SELECT_PESSOA_FISICA_SQL);)
        	{
        		ps.setString(1, cpf);
        		ResultSet rs = ps.executeQuery();
        		while(rs.next()) 
        		{
        			String nome = rs.getString("TB01_NOME");
        			String endereco = rs.getString("TB01_ENDERECO");
        			String cidade = rs.getString("TB01_CIDADE");
        			String uf = rs.getString("TB01_UF");
        			String telefone = rs.getString("TB01_TELEFONE");
        			
        			pf = new PessoaFisica(cpf, nome, endereco, cidade, uf, telefone);
        		}
         	}
        	catch(Exception e)
        	{
        		System.err.println(e.getLocalizedMessage());    		
        	}   	
    	JDBCUtils.closeConnection();
    	return pf;
    }
    
    
    
    
    public static List <PessoaFisica> selectAllPF()
    {
        
    	List <PessoaFisica> pfs = new ArrayList<>();
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(SELECTALL_PESSOA_FISICA_SQL);
    		)
        {
    		System.out.println(ps);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) 
    		{
    			String cpf = rs.getString("TB01_CPF");
    			String nome = rs.getString("TB01_NOME");
    			String endereco = rs.getString("TB01_ENDERECO");
    			String cidade = rs.getString("TB01_CIDADE");
    			String uf = rs.getString("TB01_UF");
    			String telefone = rs.getString("TB01_TELEFONE");
    			pfs.add(new PessoaFisica(cpf,nome,endereco,cidade,uf,telefone));
    		}
    		
       	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}   
    	JDBCUtils.closeConnection();
    	return pfs;
    }
    
    
    
    public static Integer deletePessoaFisica(String cpf)
    {
        
    	Integer rowsDeleteded = 0;
    	
    	try 
    	{
    		Connection connection = JDBCUtils.getConnection();
    		
    		PreparedStatement ps = connection.prepareStatement(DELETE_PESSOA_FISICA_SQL);    	   
    	
    		ps.setString(1, cpf);
    		
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
    

    public static Integer updatePessoaFisica(PessoaFisica pf)
    {
        
    	Integer rowsUpdated = 0;
    	
    	try{
    		Connection connection = JDBCUtils.getConnection();
    		
    		PreparedStatement ps = connection.prepareStatement(UPDATE_PESSOA_FISICA_SQL);
      
            ps.setString(1, pf.getNome());
    		ps.setString(2, pf.getEndereco());
    		ps.setString(3, pf.getCidade());
    		ps.setString(4, pf.getUf());
    		ps.setString(5, pf.getTelefone());
            ps.setString(6, pf.getCpf());
    		
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
