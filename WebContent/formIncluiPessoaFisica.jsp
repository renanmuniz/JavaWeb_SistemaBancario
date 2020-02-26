<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaPessoaFisica" var="linkServletNovaPessoaFisica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoa Física</title>
</head>
<body>

	<form action="${linkServletNovaPessoaFisica }" method="post">
	<h1>Cadastro de pessoa física:</h1>
	<br/>
	<p>	CPF:        <input type="text" name="cpf"  /></p>
    <p> Nome:       <input type="text" name="nome"  /></p>
    <p> Endereço:   <input type="text" name="endereco"  /></p>
	<p>	Cidade:     <input type="text" name="cidade"  /></p>
    <p> Estado:     <input type="text" name="estado"  /></p>
    <p> Telefone:   <input type="text" name="telefone"  /></p>
	<br/>
	<input type="submit" value="Salvar"/>
	</form>

</body>
</html>