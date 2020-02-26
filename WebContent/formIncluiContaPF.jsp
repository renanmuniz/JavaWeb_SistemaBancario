<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaContaPF" var="linkServletNovaContaPF"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Conta Pessoa Física</title>
</head>
<body>

	<form action="${linkServletNovaContaPF }" method="post">
	<h1>Cadastro de Conta Pessoa Física:</h1>
	<br/>
	<p>	Número da Agência:        <input type="text" name="numAgenciaPF"  /></p>
    <p> CPF do Titular:       <input type="text" name="cpfTitularPF"  /></p>
    <p> Saldo:   <input type="text" name="saldoPF"  /></p>
	<br/>
	<input type="submit" value="Salvar"/>
	</form>

</body>
</html>