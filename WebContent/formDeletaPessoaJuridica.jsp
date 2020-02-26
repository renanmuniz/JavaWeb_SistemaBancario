<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaPessoaJuridica" var="linkServletDeletaPessoaJuridica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclusão de Pessoa Jurídica</title>
</head>
<body>

	<form action="${linkServletDeletaPessoaJuridica }" method="post">
	
		CNPJ:        <input type="text" name="cnpj"  value='${param.cnpj}' readonly />

		<input type="submit" value="Confirmar exclusão"/>
	</form>

</body>
</html>