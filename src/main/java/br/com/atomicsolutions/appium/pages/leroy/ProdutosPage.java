package br.com.atomicsolutions.appium.pages.leroy;

import static br.com.atomicsolutions.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.atomicsolutions.appium.core.BasePage;

public class ProdutosPage extends BasePage {

//	public void entrarContextoWeb() throws InterruptedException
//	{
//		Set<String> contextHandles = getDriver().getContextHandles();
//		System.out.println((String)contextHandles.toArray()[0]);
//		System.out.println((String)contextHandles.toArray()[1]);
//
//		getDriver().context((String)contextHandles.toArray()[1]);
//		Thread.sleep(2000);
//	}
//	public void sairContextoWeb() throws InterruptedException
//	{
//		Set<String> contextHandles = getDriver().getContextHandles();
//		getDriver().context((String)contextHandles.toArray()[0]);
//		Thread.sleep(2000);
//
//	}

	public void escolherTipoLixa() throws InterruptedException {

		clicarPorTexto("Lixa Manual Lixa Manual");
	}

	public void escolherMaterialLixa() throws InterruptedException {
		clicarPorTexto("Material a ser Lixado");
		clicar(By.xpath("//*[starts-with(@text,'Metal')]"));
	}

	public void ordenar() throws InterruptedException {
		
		clicar(By.xpath("(//android.widget.Button)[2]"));
		Thread.sleep(2000);
		clicarPorTexto("Maior preço");
	}

	public void escolherLixa() throws InterruptedException {
		
		clicar(By.xpath("(//android.view.View[@text='Folha De Lixa Para Ferros Grão 36 Pacote Com...'])[1]"));
	}
	public void ClicarNoFavorito() throws InterruptedException {
		Thread.sleep(6000);
		
		scroll(0.9,0.4);
		Thread.sleep(6000);
		clicar(By.xpath("(//android.widget.Button)[2]"));
	}
	public void CriarListaFav() throws InterruptedException {
		tap(530,1620);
		Thread.sleep(2000);
		tap(520,930);
		Thread.sleep(1000);
		tapFavs();
		Thread.sleep(500);
		tap(510,830);
	}
}

