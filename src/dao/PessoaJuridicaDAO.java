package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.PessoaJuridica;
import utils.JDBCUtils;

public class PessoaJuridicaDAO 
{

	private static String erro = null;
    
    private static final String INSERT_PESSOA_JURIDICA_SQL = 
    "INSERT INTO TB02_PESSOA_JURIDICA " 
    + "(TB02_CNPJ, TB02_SOCIO_CPF, TB02_RAZAO_SOCIAL, TB02_ENDERECO, TB02_CIDADE, TB02_UF, TB02_TELEFONE) " 
    + "VALUES (?,?,?,?,?,?,?);";
    
    private static final String SELECT_PESSOA_JURIDICA_SQL = 
    "SELECT TB02_CNPJ, TB02_SOCIO_CPF, TB02_RAZAO_SOCIAL, TB02_ENDERECO, TB02_CIDADE, TB02_UF, TB02_TELEFONE from TB02_PESSOA_JURIDICA where TB02_CNPJ = ?"; 
    
    private static final String SELECTALL_PESSOA_JURIDICA_SQL = 
    "SELECT * from TB02_PESSOA_JURIDICA ORDER BY TB02_RAZAO_SOCIAL, TB02_CNPJ"; 
    
    private static final String DELETE_PESSOA_JURIDICA_SQL = 
    "DELETE from TB02_PESSOA_JURIDICA where TB02_CNPJ = ?"; 
    
    private static final String UPDATE_PESSOA_JURIDICA_SQL = 
    "UPDATE TB02_PESSOA_JURIDICA set TB02_SOCIO_CPF=?,TB02_RAZAO_SOCIAL=?, TB02_ENDERECO=?, TB02_CIDADE=?, TB02_UF=?, TB02_TELEFONE=? where TB02_CNPJ = ?"; 
    

    
    public static Integer inserePessoaJuridica(PessoaJuridica pj)
    {
        
    	Integer rowsInserted = 0;
    	
    	try(Connection connection = JDBCUtils.getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PESSOA_JURIDICA_SQL);)
    	{
    		preparedStatement.setString(1, pj.getCnpj());
    		preparedStatement.setString(2, pj.getSocioCpf());
    		preparedStatement.setString(3, pj.getRazaoSocial());
    		preparedStatement.setString(4, pj.getEndereco());
    		preparedStatement.setString(5, pj.getCidade());
    		preparedStatement.setString(6, pj.getUf());
    		preparedStatement.setString(7, pj.getTelefone());
    		
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
    
    public static PessoaJuridica selectPJ(String cnpj)
    {
        
    	PessoaJuridica pj = null;
    	try(Connection connection = JDBCUtils.getConnection();
        		PreparedStatement ps = connection.prepareStatement(SELECT_PESSOA_JURIDICA_SQL);)
        	{
        		ps.setString(1, cnpj);
        		ResultSet rs = ps.executeQuery();
        		while(rs.next()) 
        		{
        			String socioCpf = rs.getString("TB02_SOCIO_CPF");
        			String razaoSocial = rs.getString("TB02_RAZAO_SOCIAL");
        			String endereco = rs.getString("TB02_ENDERECO");
        			String cidade = rs.getString("TB02_CIDADE");
        			String uf = rs.getString("TB02_UF");
        			String telefone = rs.getString("TB02_TELEFONE");
        			
        			pj = new PessoaJuridica(cnpj, socioCpf, razaoSocial, endereco, cidade, uf, telefone);
        		}
         	}
        	catch(Exception e)
        	{
        		System.err.println(e.getLocalizedMessage());    		
        	}   	
    	JDBCUtils.closeConnection();
    	return pj;
    }
    
    
    
    
    public static List <PessoaJuridica> selectAllPJ()
    {
        
    	List <PessoaJuridica> pjs = new ArrayList<>();
    	
    	try(
    			Connection connection = JDBCUtils.getConnection();
    			PreparedStatement ps = connection.prepareStatement(SELECTALL_PESSOA_JURIDICA_SQL);
    		)
        {
    		System.out.println(ps);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) 
    		{
    			String cnpj = rs.getString("TB02_CNPJ");
    			String socio_cpf = rs.getString("TB02_SOCIO_CPF");
    			String razao_social = rs.getString("TB02_RAZAO_SOCIAL");
    			String endereco = rs.getString("TB02_ENDERECO");
    			String cidade = rs.getString("TB02_CIDADE");
    			String uf = rs.getString("TB02_UF");
    			String telefone = rs.getString("TB02_TELEFONE");
    			pjs.add(new PessoaJuridica(cnpj,socio_cpf,razao_social,endereco,cidade,uf,telefone));
    		}
    		
       	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}     
    	JDBCUtils.closeConnection();
    	return pjs;
    }
    
    
    
    public static Integer deletePessoaJuridica(String cnpj)
    {
        
    	Integer rowsDeleteded = 0;
    	
    	try
    	{
    		Connection connection = JDBCUtils.getConnection();
    	
    		PreparedStatement ps = connection.prepareStatement(DELETE_PESSOA_JURIDICA_SQL);
    	    	
    		ps.setString(1, cnpj);
    		
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
    

    public static Integer updatePessoaJuridica(PessoaJuridica pj)
    {
        
    	Integer rowUpdated = 0;
    	
    	try{
    		Connection connection = JDBCUtils.getConnection();
    		PreparedStatement ps = connection.prepareStatement(UPDATE_PESSOA_JURIDICA_SQL);
    		
    		ps.setString(1, pj.getSocioCpf());
            ps.setString(2, pj.getRazaoSocial());
    		ps.setString(3, pj.getEndereco());
    		ps.setString(4, pj.getCidade());
    		ps.setString(5, pj.getUf());
    		ps.setString(6, pj.getTelefone());
    		ps.setString(7, pj.getCnpj());
            
    		
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
