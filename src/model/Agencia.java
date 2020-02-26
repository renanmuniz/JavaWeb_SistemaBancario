package model;

public class Agencia 
{
	private String numAgencia;
	private String endereco;
	private String cidade;
	private String uf;
	private String telefone;
	
	public Agencia()
	{
		
	}
	
	public Agencia(String numAgencia, String endereco, String cidade, String uf, String telefone) 
	{
		if(numAgencia == "")
		{
			this.numAgencia = null;
		}
		else
		{
			this.numAgencia = numAgencia;
		}
		
		if(endereco == "")
		{
			this.endereco = null;
		}
		else
		{
			this.endereco = endereco;
		}
		
		if(cidade == "")
		{
			this.cidade = null;
		}
		else
		{
			this.cidade = cidade;
		}
		
		if(uf == "")
		{
			this.uf = null;
		}
		else
		{
			this.uf = uf;
		}
		
		if(telefone == "")
		{
			this.telefone = null;
		}
		else
		{
			this.telefone = telefone;
		}
	}
	
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
