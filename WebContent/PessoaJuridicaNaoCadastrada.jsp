<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.PessoaJuridica" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoa Jurídica</title>
</head>
<body>
		<p>Pessoa Jurídica Não Cadastrada:</p>		

		<p>${ pessoaJuridicaNaoCadastrada } não cadastrada!	</p>	
		<p>Erro: ${ erro }</p>
		
		<br/>
		<br/>
		<br/>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=novaPessoaJuridica'>Voltar para cadastro.</a> </button>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=listaPessoaJuridica'>Voltar para lista de cadastrados.</a> </button>	
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
		
		<!-- <button><a href='http://localhost:8080/SistemaBancario/formIncluiPessoaJuridica.jsp'>Voltar para cadastro.</a> </button>  -->
		<!-- <button><a href='http://localhost:8080/SistemaBancario/listaPessoaJuridica'>Voltar para lista de cadastrados.</a> </button>	 -->
		<!-- <button><a href='http://localhost:8080/SistemaBancario/MenuPrincipal.html'>Voltar para menu principal.</a> </button>  -->
</body>
</html>