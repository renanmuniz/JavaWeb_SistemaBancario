<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaAgencia" var="linkServletDeletaAgencia"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclus�o de Ag�ncia</title>
</head>
<body>

	<form action="${linkServletDeletaAgencia }" method="post">
	
		N�mero da Ag�ncia: <input type="text" name="numAgencia"  value='${param.numAgencia}' readonly/>

		<input type="submit" value="Confirmar exclus�o"/>
	</form>

</body>
</html>