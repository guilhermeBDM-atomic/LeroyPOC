package br.com.atomicsolutions.appium.core;

import static br.com.atomicsolutions.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BasePage {
	public void escrever(By by, String texto)
	{
		getDriver().findElement(by).sendKeys(texto);;
		
	}
	public String obterTexto(By by)
	{
	
		return getDriver().findElement(by).getText();

	}
	public void selecionarCombo(By by, String valor)
	{
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
		
	}
	public void clicarPorTexto(String texto)
	{
		clicar(By.xpath("//*[@text='"+texto+"']"));

	}
	public void clicar(By by)
	{
		getDriver().findElement(by).click();
	}
	public String pegarAtributo(By by,String atributo)
	{
		return getDriver().findElement(by).getAttribute(atributo);
		
	}
	public boolean isCheckMarcado(By by)
	{
		return getDriver().findElement(by).getAttribute("checked").equals("true");
		
	}
	public void timeOut(int tempo,TimeUnit unidade)
	{
		getDriver().manage().timeouts().implicitlyWait(tempo, unidade);

		
	}
	public boolean existeElementoPorTexto(String texto)
	{
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}
	public void tap(int x, int y)
	{
		TouchAction touchAction = new TouchAction(getDriver());

		touchAction.tap(PointOption.point(x, y)).perform();

	}
	public void tapFavs()
	{
		tap(515,1499);
		tap(284,1495);
		tap(231,1622);
		tap(492,1503);
		tap(281,1507);
		tap(104,1730);
		tap(131,1614);
		tap(1011,1499);
		tap(1011,1499);
		tap(815,1507);
		tap(694,1507);
		tap(842,1726);
	}
	public String obterTituloAlerta()
	{
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagem()
	{
		return obterTexto(By.id("android:id/message"));
	}
	public MobileElement clicarSeekBar(By by) {
		return getDriver().findElement(by);
		
	}
	public void scroll(double inicio, double fim)
	{
		Dimension size = getDriver().manage().window().getSize();
		int x = size.width/2;
		int start_y = (int)(size.height * inicio);
		int end_y = (int)(size.height * fim);
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, end_y)).release().perform();
	}
	public void listarUmElemento()
	{
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//android.widget.EditText"));
		System.out.println("Chegou aqui");
		System.out.println(elementos.size());
		for(MobileElement elemento: elementos){
			   System.out.println(elemento.getText());
			}
	}
	
	public void scrollDown()
	{
		scroll(0.9,0.1);
	}
	public void scrollUp()
	{
		scroll(0.1,0.9);
	}
	
	public void swipeLeft()
	{
		scroll(0.1,0.9);
	}
	public void swipeRight()
	{
		scroll(0.9,0.1);
	}
	
	
	public void swipe(double inicio, double fim)
	{
		Dimension size = getDriver().manage().window().getSize();
		int y = size.height/2;
		int start_x = (int)(size.width * inicio);
		int end_x = (int)(size.width * fim);
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(end_x, y)).release().perform();
	}
	public void swipeElement(MobileElement elemento, double inicio, double fim)
	{
		int y = elemento.getLocation().y + (elemento.getSize().height /2);
		
		
		int start_x = (int)(elemento.getSize().width * inicio);
		int end_x = (int)(elemento.getSize().width * fim);
		
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(end_x, y)).release().perform();
	}
	public void esperar(int n)
	{
		WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(),10);
		try {
			wait.wait(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitUntilElementExists(By by) throws Exception
	{
		WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(),10);
		try {
			wait.until(presenceOfElementLocated(by));
		} catch (Exception e) {
			throw new Exception("Elemento não existe");
		}
		
	}
	public void cliqueLongo(By by)
	{
		AndroidTouchAction touchAction = new AndroidTouchAction(getDriver());
		
		touchAction.longPress(PointOption.point(getDriver().findElement(by).getCenter()))
              .perform ();		
	}
}

