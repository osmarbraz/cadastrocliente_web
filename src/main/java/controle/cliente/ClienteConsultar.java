package controle.cliente;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import entidade.Cliente;

public class ClienteConsultar extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cadastro de Cliente - Consultar</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Consultar</h1>");

        Cliente cliente = new Cliente();
        cliente.setClienteId(request.getParameter("CLIENTEID"));
        boolean resultado = cliente.abrir();
        if (resultado == true) {
            out.print("<span class='mensagenConsultar'>Cliente encontrado!</span><p>");
            out.print(" Cliente : " + cliente.getClienteId() + " <br> ");
            out.print(" Nome : " + cliente.getNome() + " <br> ");
            out.print(" Cpf : " + cliente.getCpf() + " <br> <p>");
        } else {
            out.print("<span class='mensagenConsultar'>Cliente n&atilde;o encontrado!</span><p>");
        }
        out.print("<a href =\"" + request.getContextPath() + "/FrmClienteConsultar.jsp\"> Consultar </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
