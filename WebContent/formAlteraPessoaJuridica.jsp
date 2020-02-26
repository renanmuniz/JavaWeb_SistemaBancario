<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraPessoaJuridica" var="linkServletAlteraPessoaJuridica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o de Pessoa jur�dica</title>
</head>
<body>

	<form action="${linkServletAlteraPessoaJuridica }" method="post">
	
		<p>CNPJ:        <input type="text" name="cnpj" value="${param.cnpj}" readonly /></p>
        
        <p>Raz�o Social:       <input type="text" name="razaoSocial" value='${param.razaoSocial}' /></p>
        <p>CPF do S�cio:       <input type="text" name="cpfSocio" value='${param.socioCpf}' /></p>
        <p>Endere�o:   <input type="text" name="endereco" value='${param.endereco}' /></p>
		<p>Cidade:     <input type="text" name="cidade" value='${param.cidade}' /></p>
        <p>Estado:     <input type="text" name="estado" value='${param.uf}' /></p>
        <p>Telefone:   <input type="text" name="telefone" value='${param.telefone}' /></p>
        
		<input type="submit" value="Salvar Altera��o"/>
	</form>

</body>
</html>