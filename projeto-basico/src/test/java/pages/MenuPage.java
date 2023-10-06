package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class MenuPage extends BasePage{

    public void acessarTelaHome(){
        clicarLink("Home");
    }

    public void acessarTelaAdicionarContas(){
        clicarBotao(By.xpath("//a[@class='dropdown-toggle']"));
        clicarBotao(By.xpath("//ul[@class='dropdown-menu']//a[.='Adicionar']"));
    }

    public void acessarTelaListarContas(){
        clicarBotao(By.xpath("//a[@class='dropdown-toggle']"));
        clicarBotao(By.xpath("//ul[@class='dropdown-menu']//a[.='Listar']"));
    }

    public void acessarTelaCriarMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumoMensal(){
        clicarLink("Resumo Mensal");
    }

    public void logout(){
        clicarLink("Sair");
    }
}
