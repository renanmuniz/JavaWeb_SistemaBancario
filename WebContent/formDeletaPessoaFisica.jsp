<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaPessoaFisica" var="linkServletDeletaPessoaFisica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclusão de Pessoa Física</title>
</head>
<body>

	<form action="${linkServletDeletaPessoaFisica }" method="post">
	
		CPF:        <input type="text" name="cpf"  value='${param.cpf}' readonly />

		<input type="submit" value="Confirmar exclusão"/>
	</form>

</body>
</html>