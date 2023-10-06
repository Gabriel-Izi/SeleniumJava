package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;
import pages.MenuPage;

public class SaldoTest extends BaseTest{
    MenuPage menuPage = new MenuPage();
    HomePage homePage = new HomePage();

    @Test
    public void validarSaldoDaConta(){
        menuPage.acessarTelaHome();
        Assert.assertEquals("534.00", 
            homePage.obterSaldoConta("Conta para saldo"));
    }

}
