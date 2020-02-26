<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaContaPJ" var="linkServletDeletaContaPJ"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclusão de Conta Pessoa Jurídica</title>
</head>
<body>

	<form action="${linkServletDeletaContaPJ }" method="post">
	
		Número da Conta:        <input type="text" name="numConta"  value='${param.numConta}' readonly/>
        Número da Agência:        <input type="text" name="numAgencia"  value='${param.numAgencia}' readonly/>

		<input type="submit" value="Confirmar exclusão"/>
	</form>

</body>
</html>