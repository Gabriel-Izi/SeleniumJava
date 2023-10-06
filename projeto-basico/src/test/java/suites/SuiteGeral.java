package suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import tests.ContaTest;
import tests.MovimentacaoTest;
import tests.RemoverContaTest;
import tests.ResumoTest;
import tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
    ContaTest.class,
    MovimentacaoTest.class,
    RemoverContaTest.class,
    SaldoTest.class,
    ResumoTest.class
})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();
    
    @BeforeClass
    public static void reset(){
        page.acessarTelaLogin();
        page.logar("gabriel123@izidorio.com","321654");
        page.reset();

        DriverFactory.killDriver();
    }
}
