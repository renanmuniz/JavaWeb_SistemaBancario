<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.Agencia" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Agência</title>
</head>
<body>
		<p>Agência cadastrada:</p>		

		<p>${ agenciaCadastrada } Cadastrada com Sucesso!</p>		

		
		<br/>
		<br/>
		<br/>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=novaAgencia'>Voltar para Cadastro.</a> </button>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=listaAgencia'>Voltar para lista de cadastradas.</a> </button>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
		
		
		
		<!-- <button><a href='http://localhost:8080/SistemaBancario/formIncluiAgencia.jsp'>Voltar para cadastro.</a> </button> -->
		<!-- <button><a href='http://localhost:8080/SistemaBancario/listaAgencia'>Voltar para lista de cadastradas.</a> </button>	-->
		<!-- <button><a href='http://localhost:8080/SistemaBancario/MenuPrincipal.html'>Voltar para menu principal.</a> </button>  -->
</body>
</html>