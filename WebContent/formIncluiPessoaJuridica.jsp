<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaPessoaJuridica" var="linkServletNovaPessoaJuridica"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoa Jur�dica</title>
</head>
<body>

	<form action="${linkServletNovaPessoaJuridica }" method="post">
	<h1>Cadastro de pessoa Jur�dica:</h1>
	<br/>
	<p>	CNPJ:        <input type="text" name="cnpj"  /></p>
	<p>	CPF do S�cio:        <input type="text" name="cpfSocio"  /></p>
    <p> Raz�o Social:       <input type="text" name="razaoSocial"  /></p>
    <p> Endere�o:   <input type="text" name="endereco"  /></p>
	<p>	Cidade:     <input type="text" name="cidade"  /></p>
    <p> Estado:     <input type="text" name="estado"  /></p>
    <p> Telefone:   <input type="text" name="telefone"  /></p>
	<br/>
	<input type="submit" value="Salvar"/>
	</form>

</body>
</html>