package core;

public class Propriedades {
    //Caso não tenha mais testes para executar ele fecha o browser
    //Estratégia complicada, pois é de boa prática sempre abrir e fechar
    // o browser entre um teste e outro para que não se influenciem
    //Indicada apenas na fase de desemvolvimento dos testes

    //false = fecha o browser somente após a execução de todos testes
    //true = abre e fecha o browser para cada teste único
    public static boolean FECHAR_BROWSER = true;

    public static Browsers BROWSER = Browsers.CHROME;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;

    public enum Browsers {
        CHROME,
        FIREFOX,
        EDGE
    }

    public enum TipoExecucao{
        LOCAL,
        GRID,
        NUVEM
    }
}
