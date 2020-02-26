<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerenciamento de Conta Pessoa Física</title>
</head>
<body>
	<center>
		<h1>Gerenciamento de Conta Pessoa Física</h1>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Contas de Pessoa Física Cadastradas:</h2></caption>
            <tr>
                <th>Número da Conta</th>
                <th>Tipo da Conta</th>
                <th>Número da Agência</th>
                <th>CPF do Titular</th>
                <th>Saldo</th>
            </tr>
            <c:forEach var="ContaPF" items="${ContasPFCadastradas}">
                <tr>
                    <td><c:out value="${ContaPF.numConta}" /></td>
                    <td><c:out value="${ContaPF.tpoConta}" /></td>
                    <td><c:out value="${ContaPF.numAgencia}" /></td>
                    <td><c:out value="${ContaPF.cpfTitular}" /></td>
                    <td><c:out value="${ContaPF.saldo}" /></td>
                    <td>
<!--                     	<a href="formAlteraContaPF.jsp?numContaPF=<c:out value='${ContaPF.numConta}' />&amp;tpoContaPF=<c:out value='${ContaPF.tpoConta}' />&amp;numAgenciaPF=<c:out value='${ContaPF.numAgencia}' />&amp;cpfTitularPF=<c:out value='${ContaPF.cpfTitular}' />&amp;saldoPF=<c:out value='${ContaPF.saldo}' />          									   
                    			">Edit</a>
 -->                    			
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=alteraContaPF&amp;numContaPF=<c:out value='${ContaPF.numConta}' />&amp;tpoContaPF=<c:out value='${ContaPF.tpoConta}' />&amp;numAgenciaPF=<c:out value='${ContaPF.numAgencia}' />&amp;cpfTitularPF=<c:out value='${ContaPF.cpfTitular}' />&amp;saldoPF=<c:out value='${ContaPF.saldo}' />          									   
                    			">Edit</a>
                    			
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
<!--                     	<a href="formDeletaContaPF.jsp?numContaPF=<c:out value='${ContaPF.numConta}' />&amp;numAgenciaPF=<c:out value='${ContaPF.numAgencia}' />">Delete</a>  -->                    	
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=deletaContaPF&amp;numContaPF=<c:out value='${ContaPF.numConta}' />&amp;numAgenciaPF=<c:out value='${ContaPF.numAgencia}' />">Delete</a>  

                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/> <br/> <br/>
        <button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
    </div>
    	
</body>
</html>
