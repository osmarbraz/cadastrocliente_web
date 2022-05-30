package controle.cliente;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import entidade.Cliente;

public class ClienteExcluir extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Cadastro de Cliente - Excluir</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Excluir</h1>");

        Cliente cliente = new Cliente();
        cliente.setClienteId(request.getParameter("CLIENTEID"));
        int resultado = cliente.excluir();
        if (resultado != 0) {
            out.print("<span class='mensagenExcluir'>Exclus&atilde;o realizada com sucesso!</span><p>");
        } else {
            out.print("<span class='mensagenExcluir'>Exclus&atilde;o n&atilde;o realizada!</span><p>");
        }
        out.print("<a href=\"" + request.getContextPath() + "/FrmClienteExcluir.jsp\"> Excluir </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
