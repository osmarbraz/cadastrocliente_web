package controle.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import entidade.Cliente;

public class TestClienteAlterar {

    @Test
    public void testDoPost() throws IOException, ServletException {

        // Dados da alteração        
        Cliente cliente = new Cliente("131", "Teste", "11111111111");
        Cliente clienteAlterado = new Cliente("131", "Cliente Existente", "11111111111");
        // Insere os dados para serem alterados
        cliente.inserir();

        //Servlet
        HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockedResponse = mock(HttpServletResponse.class);
        ServletContext mockedServletContext = mock(ServletContext.class);
        HttpSession mockedSession = mock(HttpSession.class);
        doReturn(mockedServletContext).when(mockedRequest).getServletContext();

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(mockedResponse.getWriter()).thenReturn(writer);

        //Parâmetros da alteração
        when(mockedRequest.getParameter("CLIENTEID")).thenReturn(clienteAlterado.getClienteId());
        when(mockedRequest.getParameter("NOME")).thenReturn(clienteAlterado.getNome());
        when(mockedRequest.getParameter("CPF")).thenReturn(clienteAlterado.getCpf());
        when(mockedRequest.getSession()).thenReturn(mockedSession);

        //Servlet Alteração
        ClienteAlterar clienteAlterar = new ClienteAlterar();
        clienteAlterar.doPost(mockedRequest, mockedResponse);

        //Resultado do servlet
        String resultado = stringWriter.toString();
        assertTrue(resultado.contains("Altera&ccedil;&atilde;o realizada com sucesso."));

        //Exclui os dados da consulta
        cliente.excluir();
    }
}
