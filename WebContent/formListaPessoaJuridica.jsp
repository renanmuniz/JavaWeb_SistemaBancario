<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gerenciamento de Pessoa Jurídica</title>
</head>
<body>
	<center>
		<h1>Gerenciamento de Pessoa Jurídica</h1>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de cadastrados:</h2></caption>
            <tr>
            	<th>Razão Social</th>
                <th>CNPJ</th>
                <th>CPF do Sócio</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>UF</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="PessoaJuridica" items="${pessoasCadastradas}">
                <tr>
                    <td><c:out value="${PessoaJuridica.razaoSocial}" /></td>
                    <td><c:out value="${PessoaJuridica.cnpj}" /></td>
                    <td><c:out value="${PessoaJuridica.socioCpf}" /></td>
                    <td><c:out value="${PessoaJuridica.endereco}" /></td>
                    <td><c:out value="${PessoaJuridica.cidade}" /></td>
                    <td><c:out value="${PessoaJuridica.uf}" /></td>
                    <td><c:out value="${PessoaJuridica.telefone}" /></td>
                    <td>
<!--                     	<a href="formAlteraPessoaJuridica.jsp?cnpj=<c:out value='${PessoaJuridica.cnpj}' />&amp;razaoSocial=<c:out value='${PessoaJuridica.razaoSocial}' />&amp;socioCpf=<c:out value='${PessoaJuridica.socioCpf}' />&amp;endereco=<c:out value='${PessoaJuridica.endereco}' />&amp;cidade=<c:out value='${PessoaJuridica.cidade}' />&amp;uf=<c:out value='${PessoaJuridica.uf}' />&amp;telefone=<c:out value='${PessoaJuridica.telefone}' />          									   
                    			">Edit</a>
 -->                    			
                    	<a href="http://localhost:8080/SistemaBancario/entrada?acao=alteraPessoaJuridica&amp;cnpj=<c:out value='${PessoaJuridica.cnpj}' />&amp;razaoSocial=<c:out value='${PessoaJuridica.razaoSocial}' />&amp;socioCpf=<c:out value='${PessoaJuridica.socioCpf}' />&amp;endereco=<c:out value='${PessoaJuridica.endereco}' />&amp;cidade=<c:out value='${PessoaJuridica.cidade}' />&amp;uf=<c:out value='${PessoaJuridica.uf}' />&amp;telefone=<c:out value='${PessoaJuridica.telefone}' />          									   
                    			">Edit</a>                    			
                    			
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
<!--                  	<a href="formDeletaPessoaJuridica.jsp?cnpj=<c:out value='${PessoaJuridica.cnpj}' />">Delete</a>   -->
	                   	<a href="http://localhost:8080/SistemaBancario/entrada?acao=deletaPessoaJuridica&amp;cnpj=<c:out value='${PessoaJuridica.cnpj}' />">Delete</a>                       	
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/> <br/> <br/>
        <button><a href='http://localhost:8080/SistemaBancario/entrada?acao=MenuPrincipal.html'>Voltar para menu principal.</a> </button>
    </div>
    	
</body>
</html>
