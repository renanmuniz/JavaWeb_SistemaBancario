<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaAgencia" var="linkServletDeletaAgencia"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclusão de Agência</title>
</head>
<body>

	<form action="${linkServletDeletaAgencia }" method="post">
	
		Número da Agência: <input type="text" name="numAgencia"  value='${param.numAgencia}' readonly/>

		<input type="submit" value="Confirmar exclusão"/>
	</form>

</body>
</html>