package util;

import javax.servlet.http.HttpServletRequest;
import org.owasp.encoder.Encode;

import entidade.Cliente;

public class RequestCliente {
    
    public static Cliente recuperaCliente(HttpServletRequest request) {
        Cliente cliente = new Cliente();
        String encodeCLIENTEID = Encode.forHtml(request.getParameter("CLIENTEID"));        
        cliente.setClienteId(encodeCLIENTEID);
        String encodeNOME = org.owasp.encoder.Encode.forHtml(request.getParameter("NOME"));
        cliente.setNome(encodeNOME);
        String encodeCPF = org.owasp.encoder.Encode.forHtml(request.getParameter("CPF"));
        cliente.setCpf(encodeCPF);
        return cliente;
    }    
}