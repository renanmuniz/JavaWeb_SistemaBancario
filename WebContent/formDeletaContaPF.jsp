<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/deletaContaPF" var="linkServletDeletaContaPF"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exclusão de Conta Pessoa Física</title>
</head>
<body>

	<form action="${linkServletDeletaContaPF }" method="post">
	
		<p>Número da Conta:        <input type="text" name="numContaPF"     value='${param.numContaPF}'   readonly /></p>
        <p>Número da Agência:      <input type="text" name="numAgenciaPF"   value='${param.numAgenciaPF}' readonly /></p>

		<p><input type="submit" value="Confirmar exclusão"/></p>
	</form>

</body>
</html>