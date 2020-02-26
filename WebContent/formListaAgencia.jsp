<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerenciamento de Agências</title>
</head>
<body>
	<center>
		<h1>Gerenciamento de Agências</h1>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Agências Cadastradas:</h2></caption>
            <tr>
                <th>Número</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>UF</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="Agencia" items="${agenciasCadastradas}">
                <tr>
                    <td><c:out value="${Agencia.numAgencia}" /></td>
                    <td><c:out value="${Agencia.endereco}" /></td>
                    <td><c:out value="${Agencia.cidade}" /></td>
                    <td><c:out value="${Agencia.uf}" /></td>
                    <td><c:out value="${Agencia.telefone}" /></td>
                    <td>
<!--                     	<a href="formAlteraAgencia.jsp?numAgencia=<c:out value='${Agencia.numAgencia}' />&amp;endereco=<c:out value='${Agencia.endereco}' />&amp;cidade=<c:out value='${Agencia.cidade}' />&amp;uf=<c:out value='${Agencia.uf}' />&amp;telefone=<c:out value='${Agencia.telefone}' />          									   
                     			">Edit</a>
-->
						<a href="http://localhost:8080/SistemaBancario/entrada?acao=alteraAgencia&amp;numAgencia=<c:out value='${Agencia.numAgencia}' />&amp;endereco=<c:out value='${Agencia.endereco}' />&amp;cidade=<c:out value='${Agencia.cidade}' />&amp;uf=<c:out value='${Agencia.uf}' />&amp;telefone=<c:out value='${Agencia.telefone}' />          									   
                     			">Edit</a>
                    			
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
<!--                     	<a href="formDeletaAgencia.jsp?numAgencia=<c:out value='${Agencia.numAgencia}' />">Delete</a>                    	 -->
                     	<a href="http://localhost:8080/SistemaBancario/entrada?acao=deletaAgencia&amp;numAgencia=<c:out value='${Agencia.numAgencia}' />">Delete</a>                    	 
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/> <br/> <br/>
        <button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
    </div>
    	
</body>
</html>
