<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraAgencia" var="linkServletAlteraAgencia"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Agência</title>
</head>
<body>

	<form action="${linkServletAlteraAgencia }" method="post">
	
		<p>Número da Agência: <input type="text" name="numAgencia" value="${param.numAgencia}" readonly /></p>
        
        <p>Endereço:   <input type="text" name="endereco" value='${param.endereco}' /></p>
		<p>Cidade:     <input type="text" name="cidade" value='${param.cidade}' /></p>
        <p>Estado:     <input type="text" name="estado" value='${param.uf}' /></p>
        <p>Telefone:   <input type="text" name="telefone" value='${param.telefone}' /></p>
        
		<input type="submit" value="Salvar Alteração"/>
	</form>

</body>
</html>