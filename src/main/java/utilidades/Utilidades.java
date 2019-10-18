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
	 * m�todo de clique no elemento desejado
	 * 
	 * @param elemento
	 */
	public static void clicar(By elemento) {
		acharElemento(elemento).click();
	}
	/**
	 * m�todo de espera impl�cita at� o elemento estar clic�vel
	 * 
	 * @param elemento
	 */
	public void esperarAteElementoEstarClicavel(By elemento) {
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	/**
	 * m�todo de espera impl�cita at� o elemento estar localizado na tela
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
	 * m�todo de espera expl�cita
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
	 * acha o campo desejado, limpa e insere o texto passado como par�metro
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
	 * seleciona a op��o de um combo pelo seu texto vis�vel
	 * 
	 * @param elemento
	 *            combo
	 * @param texto
	 *            vis�vel
	 */
	public static void selecionarComboPorTextoVisivel(By by, String visibleText) {
		WebElement element = acharElemento(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(visibleText);
	}
	/**
	 * seleciona a op��o de um combo pelo seu index
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
	 * gera string de caracteres rand�micos conforme a quantidade desejada.
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
	 * rola a barra at� o elemento passado como par�metro.
	 * 
	 * @param elemento
	 */
	public static void scroll(By elemento) {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
		jse.executeScript("arguments[0].scrollIntoView();", Driver.getInstance().findElement(elemento));
	}

	/**
	 * tira screenshot e armazena na pasta Evid�ncias segmentado pelo status do
	 * teste
	 * 
	 */
	public void screenshot(String status, String nomeTeste) {
		try {
			TakesScreenshot fonte = (TakesScreenshot) servicos.Driver.getInstance();
			File fnt = fonte.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(fnt,
					new File("Evid�ncias" + File.separator + status + File.separator + nomeTeste + ".jpg"));
		} catch (Exception e) {
			System.out.println("Erro na Escrita de arquivo.");
		}
	}
}
