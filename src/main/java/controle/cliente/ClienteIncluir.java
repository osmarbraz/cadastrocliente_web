package controle.cliente;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import util.Valida;
import entidade.Cliente;

public class ClienteIncluir extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Cadastro de Cliente - Incluir</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Incluir</h1>");

        Cliente cliente = new Cliente();
        cliente.setClienteId(request.getParameter("CLIENTEID"));
        cliente.setNome(request.getParameter("NOME"));
        cliente.setCpf(request.getParameter("CPF"));
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            boolean resultado = cliente.inserir();
            if (resultado == true) {
                out.print("<span class='mensagenIncluir'>Inclus&atilde;o realizada com sucesso</span><p>");
            } else {
                out.print("<span class='mensagenIncluir'>Inclus&atilde;o n&atilde;o realizada</span><p>");
            }
        } else {
            out.print("CPF Invalido!");
        }
        out.print("<a href=\"" + request.getContextPath() + "/FrmClienteIncluir.jsp\"> Incluir </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
