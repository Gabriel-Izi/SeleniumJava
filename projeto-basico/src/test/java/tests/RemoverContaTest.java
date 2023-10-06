package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ContaPage;
import pages.MenuPage;

public class RemoverContaTest extends BaseTest{

    private MenuPage menuPage = new MenuPage();
    private ContaPage contaPage = new ContaPage();

    @Test
    public void testExcluirContaComMovimentacaoPendente(){
        menuPage.acessarTelaListarContas();

        contaPage.clicarExcluiConta("Conta com movimentacao");

        Assert.assertEquals("Conta em uso na movimentações", 
            contaPage.obterMensagemDeErro());
    }
}
