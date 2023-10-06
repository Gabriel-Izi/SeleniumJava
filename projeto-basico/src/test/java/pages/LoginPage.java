package pages;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage{
    
    public void acessarTelaLogin(){
        DriverFactory.getDriver().get("http://seubarriga.wcaquino.me");
    }

    public void setEmail(String email){
        escrever("email", email);
    }

    public void setSenha(String senha){
        escrever("senha", senha);
    }

    public void entrar(){
        clicarBotaoPorTexto("Entrar");
    }

    public void logar(String email, String senha){
        setEmail(email);
        setSenha(senha);
        entrar();
    }
    
    public void reset(){
        clicarLink("reset");
    }
}
