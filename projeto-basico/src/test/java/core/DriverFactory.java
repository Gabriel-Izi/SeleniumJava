package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Propriedades.TipoExecucao;

public class DriverFactory {
//  private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){}

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver(){
        WebDriver driver = null;
        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL){
            switch (Propriedades.BROWSER){
                case CHROME: driver = new ChromeDriver(); break;
                case FIREFOX: driver = new FirefoxDriver(); break;
                case EDGE: driver = new EdgeDriver(); break;
            }
        }
        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID){
            DesiredCapabilities cap = null;
            switch (Propriedades.BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
                case EDGE: cap = DesiredCapabilities.edge(); break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.out.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }

        if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM){
            DesiredCapabilities cap = null;
            switch (Propriedades.BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
                case EDGE: cap = DesiredCapabilities.edge(); break;
            }
            try {
                driver = new RemoteWebDriver(new URL("https://oauth-izidoriozika89-8d45b:f6404397-bc6e-4d75-bdbd-205bd4bbce65@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.out.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }
        return driver;
    }
        //Selenium 4 GRID 4
        // if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID){
            
        //      DesiredCapabilities cap = new DesiredCapabilities();
        //      switch (Propriedades.BROWSER) {
        //          case CHROME: 
        //              cap.setPlatform(Platform.ANY);
        //              cap.setBrowserName("chrome"); 
        //              ChromeOptions optionsChrome = new ChromeOptions();
        //              optionsChrome.merge(cap);
        //              break;
                
        //          case FIREFOX:
        //              cap.setPlatform(Platform.ANY);
        //              cap.setBrowserName("firefox"); 
        //              FirefoxOptions optionsFirefox = new FirefoxOptions();
        //              optionsFirefox.merge(cap);
        //              break;

        //          case EDGE:
        //              cap.setPlatform(Platform.ANY);
        //              cap.setBrowserName("edge"); 
        //              EdgeOptions optionsEdge = new EdgeOptions();
        //              optionsEdge.merge(cap);
        //              break;
        //      }
        //     try {
        //         driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444/wd/hub"), cap);
        //     } catch (MalformedURLException e) {
        //         System.out.println("Falha na conexão com o GRID");
        //         e.printStackTrace();
        //     }
        // }
        // return driver;
        // }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if(driver != null){
            driver.quit();
            driver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }
}
