<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.PessoaFisica" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoa F�sica</title>
</head>
<body>
		<p>Pessoa deletada:</p>		

		${ pessoaFisicaDeletada } deletada com Sucesso!		

		
		<br/>
		<br/>
		<br/>
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=listaPessoaFisica'>Voltar para lista de cadastrados.</a> </button>	
		<button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
		
		<!--<button><a href='http://localhost:8080/SistemaBancario/listaPessoas'>Voltar para lista de cadastrados.</a> </button> -->	
		<!--<button><a href='http://localhost:8080/SistemaBancario/MenuPrincipal.html'>Voltar para menu principal.</a> </button> -->
</body>
</html>