<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaAgencia" var="linkServletNovaAgencia"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Agência</title>
</head>
<body>

	<form action="${linkServletNovaAgencia }" method="post">
	<h1>Cadastro de agência:</h1>
	<br/>
	<p>	Número da Agência:        <input type="text" name="numAgencia"  /></p>
    <p> Endereço:                 <input type="text" name="endereco"  /></p>
	<p>	Cidade:                   <input type="text" name="cidade"  /></p>
    <p> Estado:                   <input type="text" name="estado"  /></p>
    <p> Telefone:                 <input type="text" name="telefone"  /></p>
	<br/>
	<input type="submit" value="Salvar"/>
	</form>

</body>
</html>