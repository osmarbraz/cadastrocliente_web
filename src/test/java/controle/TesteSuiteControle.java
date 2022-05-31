package controle;

import controle.cliente.TestClienteAlterar;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;

import controle.cliente.TestClienteConsultar;
import controle.cliente.TestClienteExcluir;
import controle.cliente.TestClienteIncluir;

@RunWith(Suite.class)
@SuiteClasses({
    TestClienteConsultar.class,
    TestClienteExcluir.class,
    TestClienteAlterar.class,
    TestClienteIncluir.class
})

public class TesteSuiteControle {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuiteControle.class);
    }
}
