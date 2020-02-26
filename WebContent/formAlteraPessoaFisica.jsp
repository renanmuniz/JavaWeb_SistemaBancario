<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraPessoaFisica" var="linkServletAlteraPessoaFisica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Pessoa Física</title>
</head>
<body>

	<form action="${linkServletAlteraPessoaFisica }" method="post">
	
		<p>CPF:        <input type="text" name="cpf" value="${param.cpf}" readonly /></p>
        
        <p>Nome:       <input type="text" name="nome" value='${param.nome}' /></p>
        <p>Endereço:   <input type="text" name="endereco" value='${param.endereco}' /></p>
		<p>Cidade:     <input type="text" name="cidade" value='${param.cidade}' /></p>
        <p>Estado:     <input type="text" name="estado" value='${param.uf}' /></p>
        <p>Telefone:   <input type="text" name="telefone" value='${param.telefone}' /></p>
        
		<input type="submit" value="Salvar Alteração"/>
	</form>

</body>
</html>