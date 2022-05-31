<html><head><title>Cadastro de Cliente - Incluir</title></head><body>
        <h1>Cadastro de Cliente - Incluir</h1>
        <form name="FrmCliente" method="post" action="servlet/ClienteIncluir">	
            ClienteId: <input type=text name="CLIENTEID"> <p>
                Nome: <input type=text size="100" name="NOME"> <p>
                Cpf (Somente números): <input type=text name="CPF"> <p>
                <input type="reset" value="Limpar">
            <input type="submit" name="Incluir" value="Incluir"> <p>
                <a href="menu.jsp"> Menu </a> <p>	  
        </form>
    </body></html>	