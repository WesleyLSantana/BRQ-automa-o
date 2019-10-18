package utilidades;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import servicos.Driver;

/**
 * @author wesley.santana
 *
 */
public class Utilidades extends Driver {

	

	static java.util.Random randomico = new java.util.Random();
	static String caracteres = "abcdefghijklmnopqrstuvwxyz";
	static String stringRandomica = "";

	/**
	 * método de clique no elemento desejado
	 * 
	 * @param elemento
	 */
	public static void clicar(By elemento) {
		acharElemento(elemento).click();
	}
	/**
	 * método de espera implícita até o elemento estar clicável
	 * 
	 * @param elemento
	 */
	public void esperarAteElementoEstarClicavel(By elemento) {
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	/**
	 * método de espera implícita até o elemento estar localizado na tela
	 * 
	 * @param elemento
	 */
	public void esperarAteAPresencaDoElementoDesejado(By elemento) {
		wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
	}
	/**
	 * encontra o elemento By desejado
	 * 
	 * @param elemento
	 *            desejado
	 * @return o elemento encontrado
	 */
	public static WebElement acharElemento(By elemento) {
		return driver.findElement(elemento);
	}

	/**
	 * método de espera explícita
	 * 
	 * @param tempo
	 *            em milissegundos
	 */
	public static void espera(int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * acha o campo desejado, limpa e insere o texto passado como parâmetro
	 * 
	 * @param texto
	 *            a ser inserido,
	 * @param campo
	 *            a ser preenchido
	 */
	public static void limpaEInsereTexto(String texto, By campo) {
		if (acharElemento(campo).isDisplayed()) {
			acharElemento(campo).clear();
			acharElemento(campo).sendKeys(texto);
		}
	}

	/**
	 * seleciona a opção de um combo pelo seu texto visível
	 * 
	 * @param elemento
	 *            combo
	 * @param texto
	 *            visível
	 */
	public static void selecionarComboPorTextoVisivel(By by, String visibleText) {
		WebElement element = acharElemento(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(visibleText);
	}
	/**
	 * seleciona a opção de um combo pelo seu index
	 * 
	 * @param elemento
	 *            combo
	 * @param index
	 *            
	 */
	public static void selecionarComboPorIndex(By by, int index) {
		WebElement element = acharElemento(by);
		Select combo = new Select(element);
		combo.selectByIndex(index);
	}
	/**
	 * gera string de caracteres randômicos conforme a quantidade desejada.
	 * 
	 * @param quantidade
	 *            de caracteres a ser gerada
	 */
	public static String geraStringRandomica(int quantidadeCaracteres) {
		char[] text = new char[quantidadeCaracteres];

		for (int i = 0; i < quantidadeCaracteres; i++) {
			text[i] = caracteres.charAt(randomico.nextInt(caracteres.length()));
		}
		for (int i = 0; i < text.length; i++) {
			stringRandomica += text[i];
		}
		return stringRandomica;
	}

	/**
	 * rola a barra até o elemento passado como parâmetro.
	 * 
	 * @param elemento
	 */
	public static void scroll(By elemento) {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
		jse.executeScript("arguments[0].scrollIntoView();", Driver.getInstance().findElement(elemento));
	}

	/**
	 * tira screenshot e armazena na pasta Evidências segmentado pelo status do
	 * teste
	 * 
	 */
	public void screenshot(String status, String nomeTeste) {
		try {
			TakesScreenshot fonte = (TakesScreenshot) servicos.Driver.getInstance();
			File fnt = fonte.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(fnt,
					new File("Evidências" + File.separator + status + File.separator + nomeTeste + ".jpg"));
		} catch (Exception e) {
			System.out.println("Erro na Escrita de arquivo.");
		}
	}
}
