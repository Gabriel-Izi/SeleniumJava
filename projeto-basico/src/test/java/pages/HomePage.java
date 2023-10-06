package pages;

import core.BasePage;

public class HomePage extends BasePage{
    
    public String obterSaldoConta(String nomeConta){
        return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo")
            .getText();
    }

}
