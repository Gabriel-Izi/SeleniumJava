package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ContaPage extends BasePage{
    
    public void setNomeConta(String nome){
        escrever("nome", nome);
    }

    public void salvarConta(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemDeSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemDeErro(){
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarAlterarconta(String nomeConta){
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas")
            .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }
    
    public void clicarExcluiConta(String nomeConta){
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas")
            .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
