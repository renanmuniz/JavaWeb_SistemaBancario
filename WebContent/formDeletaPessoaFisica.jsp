<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaPessoaFisica" var="linkServletDeletaPessoaFisica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclus�o de Pessoa F�sica</title>
</head>
<body>

	<form action="${linkServletDeletaPessoaFisica }" method="post">
	
		CPF:        <input type="text" name="cpf"  value='${param.cpf}' readonly />

		<input type="submit" value="Confirmar exclus�o"/>
	</form>

</body>
</html>