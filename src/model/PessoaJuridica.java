package model;

public class PessoaJuridica
{
	private String cnpj;
	private String socio_cpf;
	private String razao_social;
	private String endereco;
	private String cidade;
	private String uf;
	private String telefone;	
	
	public PessoaJuridica()
	{
		//Construtor padrão vazio.
	}
	
	public PessoaJuridica(String cnpj, String socio_cpf, String razao_social, String endereco, String cidade, String uf, String telefone) 
	{
		
		if(cnpj == "")
		{
			this.cnpj = null;
		}
		else
		{
			this.cnpj = cnpj;
		}
		
		if(socio_cpf == "")
		{
			this.socio_cpf = null;
		}
		else
		{
			this.socio_cpf = socio_cpf;
		}
		
		if(razao_social == "")
		{
			this.razao_social = null;
		}
		else
		{
			this.razao_social = razao_social;
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
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getSocioCpf() {
		return socio_cpf;
	}
	public void setSocioCpf(String socio_cpf) {
		this.socio_cpf = socio_cpf;
	}
	
	public String getRazaoSocial() {
		return razao_social;
	}
	public void setRazaoSocial(String razao_social) {
		this.razao_social = razao_social;
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
