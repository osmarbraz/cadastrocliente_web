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

public class TestClienteIncluir {

    @Test
    public void testDoPost() throws IOException, ServletException {

        // Dados da inclusão
        Cliente cliente = new Cliente("131", "Cliente Existente", "11111111111");
        
        // Servlet
        HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockedResponse = mock(HttpServletResponse.class);
        ServletContext mockedServletContext = mock(ServletContext.class);
        HttpSession mockedSession = mock(HttpSession.class);
        doReturn(mockedServletContext).when(mockedRequest).getServletContext();

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(mockedResponse.getWriter()).thenReturn(writer);

        //Parâmetros da inclusão
        when(mockedRequest.getParameter("CLIENTEID")).thenReturn(cliente.getClienteId());
        when(mockedRequest.getParameter("NOME")).thenReturn(cliente.getNome());
        when(mockedRequest.getParameter("CPF")).thenReturn(cliente.getCpf());
        when(mockedRequest.getSession()).thenReturn(mockedSession);

        //Servlet Consulta
        ClienteIncluir clienteIncluir = new ClienteIncluir();
        clienteIncluir.doPost(mockedRequest, mockedResponse);

        //Resultado do servlet
        String resultado = stringWriter.toString();
        assertTrue(resultado.contains("Inclus&atilde;o realizada com sucesso."));

        //Exclui os dados da inclusão
        cliente.excluir();
    }
}
