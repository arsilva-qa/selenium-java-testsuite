package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverSetup;

//CLASSE QUE REPRESENTA A PÁGINA INCICIAL DA APLICAÇÃO.
public class HomePage 
{
	protected WebDriver navegador;
	protected WebDriverWait espera;

	//SELETORES DOS ELEMENTOS DE TELA, DECLARADOS UTILIZANDO O PAGE FACTORY.
    @FindBy(css = "a.button")
    private WebElement btnAzul;

    @FindBy(css = "a.button.alert")
    private WebElement btnVermelho;

    @FindBy(css = "a.button.success")
    private WebElement btnVerde;
    
    @FindBy(xpath = "(//a[@href='#edit'])[1]")
    private WebElement opcEditar;
    
    @FindBy(xpath = "(//a[@href='#delete'])[1]")
    private WebElement opcDeletar;
    
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> linhasTabela;

    @FindBy(xpath = "(//a[@href='#edit'])")
    private List<WebElement> listaOpcEditar;
    
    @FindBy(xpath = "(//a[@href='#delete'])")
    private List<WebElement> listaOpcDeletar;
    
    @FindBy(xpath = "//body//script")
    private WebElement canvas;

    public HomePage(WebDriver navegador) 
    {
        this.navegador = navegador;
        this.espera = DriverSetup.getWebDriverWait();
        PageFactory.initElements(navegador, this);
    }

    //MÉTODO GENÉRICO PARA CLICAR NOS BOTÕES E RETORNAR O NOVO VALOR DO ELEMENTO CANVAS.
    private String clicarBotao(WebElement botao) 
    {
        espera.until(ExpectedConditions.elementToBeClickable(botao)).click();
        return recuperarAnswer();
    }

    public String clicarBotaoAzul() 
    {
        return clicarBotao(btnAzul);
    }

    public String clicarBotaoVermelho() 
    {
        return clicarBotao(btnVermelho);
    }

    public String clicarBotaoVerde() 
    {
        return clicarBotao(btnVerde);
    }
    
   //MÉTODO GENÉRICO PARA CLICAR NAS AÇÕES DA TABELA E RETORNAR A URL ATUALIZADA.
    private String clicarOpcaoTabela(WebElement opc) 
    {
    	espera.until(ExpectedConditions.elementToBeClickable(opc)).click();
    	return navegador.getCurrentUrl();
    }
    
    public String clicarOpcaoEdit() 
    {
    	return clicarOpcaoTabela(opcEditar);
    }
    
    public String clicarOpcaoDelete() 
    {
    	return clicarOpcaoTabela(opcDeletar);
    }
    
   //MÉTODO GENÉRICO PARA CLICAR EM TODAS AS AÇÕES DA TABELA E A CADA CLIQUE INCREMENTAR O CONTADOR EM 1.
    private int clicarEmTodasAsAcoesTabela(List<WebElement> opc) 
    {
    	int totalCliques = 0;
    	for (int i = 0; i < linhasTabela.size(); i++) 
    	{
    		espera.until(ExpectedConditions.elementToBeClickable(opc.get(i))).click();
    		navegador.navigate().back();
    		totalCliques = i+1;
    	}
    	return totalCliques;
    }
    
    public int clicarEmTodasAsOpcoesEdit() 
    {
    	return clicarEmTodasAsAcoesTabela(listaOpcEditar);
    }
    
    public int clicarEmTodasAsOpcoesDelete() 
    {
    	return clicarEmTodasAsAcoesTabela(listaOpcDeletar);
    }

    public String recuperarAnswer() 
    {
        String conteudoCanvas = canvas.getAttribute("innerHTML"); //CAPTURA TODO CONTEÚDO DO ELEMENTO CANVAS.
        return extrairNumeroDoElementoCanvas(conteudoCanvas);
    }

    private static String extrairNumeroDoElementoCanvas(String conteudoCanvas) //MÉTODO CRIADO PARA RETORNAR APENAS O NÚMERO DO ELEMENTO CANVAS.
    {
        Pattern pattern = Pattern.compile("Answer:\\s*(\\d+)"); //DEFINE A EXPRESSÃO REGULAR QUE SERÁ UTILIZADA PARA CAPTURAR APENAS OS DÍGITOS QUE ESTÃO APÓS A PALAVRA ANSWER.
        Matcher matcher = pattern.matcher(conteudoCanvas); //VALIDA SE O CONTEÚDO DO CANVAS ATENDE À CONDIÇÃO DA EXPRESSÃO REGULAR PARA RETORNAR ALGUM VALOR.
        return matcher.find() ? matcher.group(1) : null; //RETORNA O VALOR ENCONTRADO NO CONTEÚDO DO CANVAS OU RETORNA NULL, CASO NÃO SEJAM ENCONTRADOS OS DÍGITOS ESPERADOS.
    }
}