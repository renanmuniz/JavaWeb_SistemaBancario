<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraPessoaJuridica" var="linkServletAlteraPessoaJuridica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Pessoa jurídica</title>
</head>
<body>

	<form action="${linkServletAlteraPessoaJuridica }" method="post">
	
		<p>CNPJ:        <input type="text" name="cnpj" value="${param.cnpj}" readonly /></p>
        
        <p>Razão Social:       <input type="text" name="razaoSocial" value='${param.razaoSocial}' /></p>
        <p>CPF do Sócio:       <input type="text" name="cpfSocio" value='${param.socioCpf}' /></p>
        <p>Endereço:   <input type="text" name="endereco" value='${param.endereco}' /></p>
		<p>Cidade:     <input type="text" name="cidade" value='${param.cidade}' /></p>
        <p>Estado:     <input type="text" name="estado" value='${param.uf}' /></p>
        <p>Telefone:   <input type="text" name="telefone" value='${param.telefone}' /></p>
        
		<input type="submit" value="Salvar Alteração"/>
	</form>

</body>
</html>