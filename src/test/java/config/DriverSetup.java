package config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

//CLASSE RESPONSÁVEL PELA CONFIGURAÇÃO DO WEBDRIVER.
public class DriverSetup 
{
    private static WebDriver navegador;
    private static WebDriverWait espera;

    private static void criarDriver()
    {
    	// CONFIGURAÇÃO DO CHROMEDRIVER UTILIZANDO O WEBDRIVERMANAGER, NÃO SENDO NECESSÁRIO REALIZAR MANUALMENTE.
        WebDriverManager.chromedriver().setup();
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out) 
                .build();
        
        navegador = new ChromeDriver(service);
        espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
        
        navegador.get("https://the-internet.herokuapp.com/challenging_dom");
        navegador.manage().window().maximize();
    }
    
    public static WebDriver getDriver() 
    {
        if (navegador == null) 
        {
            criarDriver();
        }
        return navegador;
    }

    public static WebDriverWait getWebDriverWait() 
    {
        return espera;
    }

    public static void quitDriver() 
    {
        if (navegador != null) 
        {
            navegador.quit();
            navegador = null;
        }
    }
}