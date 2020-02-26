<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.ContaPJ" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Conta Pessoa Jurídica</title>
</head>
<body>
		<p>Conta Pessoa Jurídica:</p>		

		<p>${ contaPessoaJuridicaNaoAlterada } não alterada!	</p>	
		<p>ERRO: ${ erro } </p>		
		
		<br/>
		<br/>
		<br/>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=listaContaPJ'>Voltar para lista de cadastradas.</a> </button>	
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
		
		<!-- <button><a href='http://localhost:8080/SistemaBancario/listaContaPJ'>Voltar para lista de cadastradas.</a> </button>  -->	
		<!-- <button><a href='http://localhost:8080/SistemaBancario/MenuPrincipal.html'>Voltar para menu principal.</a> </button>	  -->
</body>
</html>