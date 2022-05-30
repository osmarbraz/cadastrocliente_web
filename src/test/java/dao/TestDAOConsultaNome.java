package dao;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

public class TestDAOConsultaNome {

    Cliente cliente;

    @Before
    public void inicializa() {
        cliente = new Cliente("131", "TesteConsulta", "11111111111");
    }

    @Test
    public void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setNome(cliente.getNome());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    public void testConsulta2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setNome(cliente.getNome());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    public void testConsulta3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setNome(cliente.getNome());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @After
    public void Finaliza() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        cliente = null;
    }
}
