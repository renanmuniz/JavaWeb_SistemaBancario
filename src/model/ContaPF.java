package model;

public class ContaPF 
{
	private Integer numConta;
	private String  tpoConta;
    private String  numAgencia;
	private String  cpfTitular;
	private Double  saldo;
	
	private String numAgenciaNovo;
	


	public ContaPF()
	{
		
	}
    
    public ContaPF(String numAgencia, String cpfTitular, Double saldo) 
	{
    	if(numAgencia == "")
    	{
    		this.numAgencia = null;
    	}
    	else
    	{
    		this.numAgencia = numAgencia;
    	}
		
    	if(cpfTitular == "")
    	{
    		this.cpfTitular = null;
    	}
    	else
    	{
    		this.cpfTitular = cpfTitular;
    	}
		
    	if(saldo == null)
    	{
    		this.saldo = 0.0;
    	}
    	else
    	{
    		this.saldo = saldo;
    	}
	}
	
	public ContaPF(Integer numConta, String tpoConta, String numAgencia, String cpfTitular, Double saldo) 
	{
	
    	if(numConta == 0)
    	{
    		this.numConta = null;
    	}
    	else
    	{
    		this.numConta = numConta;
    	}

    	if(tpoConta == "")
    	{
    		this.tpoConta = "01";
    	}
    	else
    	{
    		this.tpoConta = "01";
    	}
    	
    	if(numAgencia == "")
    	{
    		this.numAgencia = null;
    	}
    	else
    	{
    		this.numAgencia = numAgencia;
    	}
		
    	if(cpfTitular == "")
    	{
    		this.cpfTitular = null;
    	}
    	else
    	{
    		this.cpfTitular = cpfTitular;
    	}
		
    	if(saldo == 0)
    	{
    		this.saldo = 0.0;
    	}
    	else
    	{
    		this.saldo = saldo;
    	}
	}
	
    
	public Integer getNumConta() {
		return numConta;
	}
	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}
	
	public String getNumAgenciaNovo() {
		return numAgenciaNovo;
	}

	public void setNumAgenciaNovo(String numAgenciaNovo) {
		this.numAgenciaNovo = numAgenciaNovo;
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
    
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
    
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
