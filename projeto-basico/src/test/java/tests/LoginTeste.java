package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTest;
import pages.LoginPage;
import pages.MenuPage;

public class LoginTeste extends BaseTest{
    
    private LoginPage loginPage = new LoginPage();
    private MenuPage menuPage = new MenuPage();

    @Test
    public void validarLoginComSucesso(){
        loginPage.logar("gabriel123@izidorio.com", "321654");
        Assert.assertEquals("Bem vindo, Gabriel Izidorio!", 
            loginPage.obterTexto(By.xpath("//div[@class='alert alert-success']")));
     
    }

    @Test
    public void validarMensagemEmailObrigatorio(){  
        loginPage.logar("", "321654");
        Assert.assertEquals("Email é um campo obrigatório", 
            loginPage.obterTexto(By.xpath("//div[@class='alert alert-danger']")));
     
    }

    @Test
    public void validarMensagemSenhaObrigatoria(){
        loginPage.logar("gabriel123@izidorio.com","");
        Assert.assertEquals("Senha é um campo obrigatório", 
            loginPage.obterTexto(By.xpath("//div[@class='alert alert-danger']")));
     
    }

    @Test
    public void validarMensagemEmailNaoCadastrado(){
        loginPage.logar("34535654623@gmail.com","123456");
        Assert.assertEquals("Problemas com o login do usuário", 
            loginPage.obterTexto(By.xpath("//div[@class='alert alert-danger']")));
     
    }

    @Test
    public void validarLogout(){
        loginPage.logar("gabriel123@izidorio.com", "321654");
        menuPage.logout();
        Assert.assertEquals("http://seubarriga.wcaquino.me/logout", 
        loginPage.obterUrl());
    }
}
