<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaContaPJ" var="linkServletDeletaContaPJ"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclus�o de Conta Pessoa Jur�dica</title>
</head>
<body>

	<form action="${linkServletDeletaContaPJ }" method="post">
	
		N�mero da Conta:        <input type="text" name="numConta"  value='${param.numConta}' readonly/>
        N�mero da Ag�ncia:        <input type="text" name="numAgencia"  value='${param.numAgencia}' readonly/>

		<input type="submit" value="Confirmar exclus�o"/>
	</form>

</body>
</html>