<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaContaPF" var="linkServletDeletaContaPF"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclus�o de Conta Pessoa F�sica</title>
</head>
<body>

	<form action="${linkServletDeletaContaPF }" method="post">
	
		<p>N�mero da Conta:        <input type="text" name="numContaPF"     value='${param.numContaPF}'   readonly /></p>
        <p>N�mero da Ag�ncia:      <input type="text" name="numAgenciaPF"   value='${param.numAgenciaPF}' readonly /></p>

		<p><input type="submit" value="Confirmar exclus�o"/></p>
	</form>

</body>
</html>