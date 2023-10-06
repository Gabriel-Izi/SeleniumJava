package tests;

import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;
import utils.DataUtils;

public class MovimentacaoTest extends BaseTest{
    
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void validarInserirMovimentacao(){
        menuPage.acessarTelaCriarMovimentacao();

        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação Teste");
        movPage.setInteressado("Pessoa Aleatória");
        movPage.setValor("500");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvarMovimentacao();

        Assert.assertEquals("Movimentação adicionada com sucesso!",
            movPage.obterMensagemDeSucesso());

    }

    @Test
    public void validarCamposObrigatorios(){
        menuPage.acessarTelaCriarMovimentacao();

        movPage.salvarMovimentacao();
        List<String> erros = movPage.obterErros();

//      Assert.assertEquals("Data da Movimentação é obrigatorio", erros.get(0));
//      Assert.assertTrue(erros.conttains("Data da Movimentação é obrigatorio"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
            "Data da Movimentação é obrigatório",
            "Data do pagamento é obrigatório",
            "Descrição é obrigatório",
            "Interessado é obrigatório",
            "Valor é obrigatório",
            "Valor deve ser um número")));

        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void validarMovimentacaoFutura(){
        menuPage.acessarTelaCriarMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação Teste");
        movPage.setInteressado("Pessoa Aleatória");
        movPage.setValor("500");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvarMovimentacao();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains(
                "Data da Movimentação deve ser menor ou igual à data atual"));

        Assert.assertEquals(1, erros.size());
    }
}
