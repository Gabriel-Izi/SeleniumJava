package tests;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumoPage;

public class ResumoTest extends BaseTest{

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void validarExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();

        resumoPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", 
            resumoPage.obterMensagemDeSucesso());

    }
    
    @Test
    public void validarTituloDaPagina(){
        menuPage.acessarTelaResumoMensal();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    
        resumoPage.selecionarAno("2016");
        resumoPage.buscar();

        List<WebElement> elementosEncontrados = 
            DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
            
        Assert.assertEquals(0, elementosEncontrados.size());
    }
    
}
