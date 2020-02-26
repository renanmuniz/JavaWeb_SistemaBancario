package model;

public class ContaPJ 
{
	private Integer numConta;
	private String  tpoConta;
    private String  numAgencia;
    private String  numNovaAgencia;
    

	private String  cnpjTitular;
	private Double  saldo;
	
	public ContaPJ()
	{
		
	}
    
    public ContaPJ(String numAgencia, String cnpjTitular, Double saldo) 
	{
		this.numAgencia = numAgencia;
		this.cnpjTitular = cnpjTitular;
		this.saldo = saldo;
	}
	
	public ContaPJ(Integer numConta, String tpoConta, String numAgencia, String cnpjTitular, Double saldo) 
	{
		this.numConta = numConta;
		this.tpoConta = tpoConta;
		this.numAgencia = numAgencia;
		this.cnpjTitular = cnpjTitular;
		this.saldo = saldo;
	}
	
    
	public Integer getNumConta() {
		return numConta;
	}
	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}
    
    public String getTpoConta() {
		return tpoConta;
	}
	public void setTpoConta(String tpoConta) {
		this.tpoConta = tpoConta;
	}
    
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public String getNumNovaAgencia() {
		return numNovaAgencia;
	}
	public void setNumNovaAgencia(String numNovaAgencia) {
		this.numNovaAgencia = numNovaAgencia;
	}
    
	public String getCnpjTitular() {
		return cnpjTitular;
	}
	public void setCnpjTitular(String cnpjTitular) {
		this.cnpjTitular = cnpjTitular;
	}
    
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
