package controle.cliente;

import org.owasp.encoder.Encode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Valida;
import entidade.Cliente;

public class ClienteAlterar extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Cadastro de Cliente - Alterar</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Alterar</h1>");

        Cliente cliente = new Cliente();
        String encodeCLIENTEID = Encode.forHtml(request.getParameter("CLIENTEID"));        
        cliente.setClienteId(encodeCLIENTEID);
        String encodeNOME = org.owasp.encoder.Encode.forHtml(request.getParameter("NOME"));
        cliente.setNome(encodeNOME);
        String encodeCPF = org.owasp.encoder.Encode.forHtml(request.getParameter("CPF"));
        cliente.setCpf(encodeCPF);
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            int resultado = cliente.alterar();
            if (resultado != 0) {
                out.print("<span class='mensagemAlterar'>Altera&ccedil;&atilde;o realizada com sucesso.</span><p>");
            } else {
                out.print("<span class='mensagemAlterar'>Altera&ccedil;&atilde;o n&atilde;o realizada.</span><p>");
            }
        } else {
            out.print("CPF Inv&aacute;lido!");
        }
        out.print("<a href=\"" + request.getContextPath() + "/FrmClienteAlterar.jsp\"> Alterar </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
