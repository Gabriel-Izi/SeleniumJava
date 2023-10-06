package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MovimentacaoPage extends BasePage{
    
    public void setDataMovimentacao(String data){
        escrever("data_transacao", data);
    }

    public void setDataPagamento(String data){
        escrever("data_pagamento", data);
    }

    public void setDescricao(String descricao){
        escrever("descricao", descricao);
    }

    public void setInteressado(String interessado){
        escrever("interessado", interessado);
    }
    
    public void setValor(String valor){
        escrever("valor", valor);
    }

    public void setConta(String conta){
        selecionarCombo("conta", conta);
    }

    public void setStatusPago(){
        clicarRadio("status_pago");
    }

    public void salvarMovimentacao(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemDeSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemDeErro(){
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public List<String> obterErros(){
        List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros){
            retorno.add(erro.getText());
        }
        return retorno;
    }
}