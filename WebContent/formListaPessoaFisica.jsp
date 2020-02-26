<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerenciamento de Pessoa Física</title>
</head>
<body>
	<center>
		<h1>Gerenciamento de Pessoa Física</h1>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de cadastrados:</h2></caption>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>UF</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="PessoaFisica" items="${pessoasCadastradas}">
                <tr>
                    <td><c:out value="${PessoaFisica.cpf}" /></td>
                    <td><c:out value="${PessoaFisica.nome}" /></td>
                    <td><c:out value="${PessoaFisica.endereco}" /></td>
                    <td><c:out value="${PessoaFisica.cidade}" /></td>
                    <td><c:out value="${PessoaFisica.uf}" /></td>
                    <td><c:out value="${PessoaFisica.telefone}" /></td>
                    <td>
<!--                 	<a href="formAlteraPessoaFisica.jsp?cpf=<c:out value='${PessoaFisica.cpf}' />&amp;nome=<c:out value='${PessoaFisica.nome}' />&amp;endereco=<c:out value='${PessoaFisica.endereco}' />&amp;cidade=<c:out value='${PessoaFisica.cidade}' />&amp;uf=<c:out value='${PessoaFisica.uf}' />&amp;telefone=<c:out value='${PessoaFisica.telefone}' />          									   
                    			">Edit</a>                                                                                  -->
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=alteraPessoaFisica&amp;cpf=<c:out value='${PessoaFisica.cpf}' />&amp;nome=<c:out value='${PessoaFisica.nome}' />&amp;endereco=<c:out value='${PessoaFisica.endereco}' />&amp;cidade=<c:out value='${PessoaFisica.cidade}' />&amp;uf=<c:out value='${PessoaFisica.uf}' />&amp;telefone=<c:out value='${PessoaFisica.telefone}' />          									   
                    			">Edit</a>                    			
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
<!--                    <a href="formDeletaPessoaFisica.jsp?cpf=<c:out value='${PessoaFisica.cpf}' />">Delete</a>           -->
                     	<a href="http://localhost:8080/SistemaBancario/entrada?acao=deletaPessoaFisica&amp;cpf=<c:out value='${PessoaFisica.cpf}' />">Delete</a>                               	
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/> <br/> <br/>
        <button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
    </div>
    	
</body>
</html>
