<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraContaPF" var="linkServletAlteraContaPF"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o de Conta Pessoa F�sica</title>
</head>
<body>
    <h5>(permitido alterar apenas a ag�ncia)</h5>
	<form action="${linkServletAlteraContaPF }" method="post">
	
		<p>N�mero da Conta:        <input type="text" name="numContaPF" value="${param.numContaPF}" readonly /></p>
        
        <p>Tipo de Conta:       	 <input type="text" name="tpoContaPF" value="${param.tpoContaPF}" readonly /></p>
        <p>N�mero da Ag�ncia:  		 <input type="text" name="numAgenciaPF" value='${param.numAgenciaPF}' readonly /></p>
        <p>N�mero da Nova Ag�ncia:   <input type="text" name="numAgenciaNovaPF" value=''  /></p>
		<p>CPF do Titular:      	 <input type="text" name="cpfTitularPF" value='${param.cpfTitularPF}' readonly /></p>
        <p>Saldo:               	 <input type="text" name="saldoPF" value='${param.saldoPF}' readonly /></p>
        
		<input type="submit" value="Salvar Altera��o"/>
	</form>

</body>
</html>