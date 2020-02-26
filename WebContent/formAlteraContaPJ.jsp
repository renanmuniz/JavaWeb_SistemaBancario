<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraContaPJ" var="linkServletAlteraContaPJ"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o de Conta Pessoa Jur�dica</title>
</head>
<body>
    <h5>(permitido alterar apenas a ag�ncia)</h5>
	<form action="${linkServletAlteraContaPJ }" method="post">
	
		<p>N�mero da Conta:        <input type="text" name="numContaPJ" value="${param.numConta}" readonly /></p>
        
        <p>Tipo de Conta:       <input type="text" name="tpoContaPJ" value='${param.tpoConta}' readonly /></p>
        <p>N�mero da Ag�ncia:   <input type="text" name="numAgenciaPJ" value='${param.numAgencia}' readonly   /></p>
        <p>N�mero da Ag�ncia:   <input type="text" name="numNovaAgenciaPJ" value='${param.numNovaAgencia}'      /></p>
		<p>cnpj do Titular:      <input type="text" name="cnpjTitularPJ" value='${param.cnpjTitular}' readonly /></p>
        <p>Saldo:               <input type="text" name="saldoPJ" value='${param.saldo}' readonly /></p>
        
		<input type="submit" value="Salvar Altera��o"/>
	</form>

</body>
</html>