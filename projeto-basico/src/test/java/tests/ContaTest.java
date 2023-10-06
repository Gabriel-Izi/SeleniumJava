package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ContaPage;
import pages.MenuPage;

public class ContaTest extends BaseTest{
    
    private MenuPage menuPage = new MenuPage();
    private ContaPage contaPage = new ContaPage();

    @Test
    public void validarAdicionarConta(){
        menuPage.acessarTelaAdicionarContas();
        
        contaPage.setNomeConta("Conta 3");
        contaPage.salvarConta();

        Assert.assertEquals("Conta adicionada com sucesso!", 
            contaPage.obterMensagemDeSucesso());
    }

    @Test
    public void validarAlterarConta(){
        menuPage.acessarTelaListarContas();

        contaPage.clicarAlterarconta("Conta para alterar");
        contaPage.setNomeConta("Conta alterada");
        contaPage.salvarConta();

        Assert.assertEquals("Conta alterada com sucesso!", 
            contaPage.obterMensagemDeSucesso());
    }

    @Test 
    public void validarMensagemContaExistente(){
        menuPage.acessarTelaAdicionarContas();

        contaPage.setNomeConta("Conta mesmo nome");
        contaPage.salvarConta();

        Assert.assertEquals("Já existe uma conta com esse nome!", 
            contaPage.obterMensagemDeErro());
    }
}
