<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerenciamento de Conta Pessoa Jurídica</title>
</head>
<body>
	<center>
		<h1>Gerenciamento de Conta Pessoa Jurídica</h1>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Contas de Pessoa Jurídica Cadastradas:</h2></caption>
            <tr>
                <th>Número da Conta</th>
                <th>Tipo da Conta</th>
                <th>Número da Agência</th>
                <th>CNPJ do Titular</th>
                <th>Saldo</th>
            </tr>
            <c:forEach var="ContaPJ" items="${ContasPJCadastradas}">
                <tr>
                    <td><c:out value="${ContaPJ.numConta}" /></td>
                    <td><c:out value="${ContaPJ.tpoConta}" /></td>
                    <td><c:out value="${ContaPJ.numAgencia}" /></td>
                    <td><c:out value="${ContaPJ.cnpjTitular}" /></td>
                    <td><c:out value="${ContaPJ.saldo}" /></td>
                    <td>
<!--                 <a href="formAlteraContaPJ.jsp?numConta=<c:out value='${ContaPJ.numConta}' />&amp;tpoConta=<c:out value='${ContaPJ.tpoConta}' />&amp;numAgencia=<c:out value='${ContaPJ.numAgencia}' />&amp;cnpjTitular=<c:out value='${ContaPJ.cnpjTitular}' />&amp;saldo=<c:out value='${ContaPJ.saldo}' />          									   
                    			">Edit</a>
 -->                    			
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=alteraContaPJ&amp;numConta=<c:out value='${ContaPJ.numConta}' />&amp;tpoConta=<c:out value='${ContaPJ.tpoConta}' />&amp;numAgencia=<c:out value='${ContaPJ.numAgencia}' />&amp;cnpjTitular=<c:out value='${ContaPJ.cnpjTitular}' />&amp;saldo=<c:out value='${ContaPJ.saldo}' />          									   
                    			">Edit</a>                    	
                    			
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
<!--                    <a href="formDeletaContaPJ.jsp?numConta=<c:out value='${ContaPJ.numConta}' />&amp;numAgencia=<c:out value='${ContaPJ.numAgencia}' />">Delete</a>     -->
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=deletaContaPJ&amp;numConta=<c:out value='${ContaPJ.numConta}' />&amp;numAgencia=<c:out value='${ContaPJ.numAgencia}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/> <br/> <br/>
        <button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
    </div>
    	
</body>
</html>
