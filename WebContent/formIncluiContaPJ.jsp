<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaContaPJ" var="linkServletNovaContaPJ"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Conta Pessoa Jur�dica</title>
</head>
<body>

	<form action="${linkServletNovaContaPJ }" method="post">
	<h1>Cadastro de Conta Pessoa Jur�dica:</h1>
	<br/>
	<p>	N�mero da Ag�ncia:        <input type="text" name="numAgenciaPJ"  /></p>
    <p> CNPJ do Titular:       <input type="text" name="cnpjTitularPJ"  /></p>
    <p> Saldo:   <input type="text" name="saldoPJ"  /></p>
	<br/>
	<input type="submit" value="Salvar"/>
	</form>

</body>
</html>