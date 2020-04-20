package br.com.atomicsolutions.appium.pages.leroy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import br.com.atomicsolutions.appium.core.BasePage;

public class HomePage extends BasePage {

	
	public void configurarApp() throws Exception 
	{
		
		for (int i = 1; i < 4; i++) {
			waitUntilElementExists(By.xpath("//*[@text='Próximo']"));
			clicarPorTexto("Próximo");
		}								
		clicarPorTexto("Finalizar");
	}
	
	public void login(String email, String senha) throws InterruptedException
	{
		clicar(By.xpath("(//android.view.ViewGroup//android.view.ViewGroup)[3]"));
		clicarPorTexto("Entrar");
		Thread.sleep(3000);
		clicar(By.xpath("//*[@text='Digite aqui seu e-mail']/.."));
		escrever(By.xpath("//*[@text='Digite aqui seu e-mail']/../android.widget.EditText"),email);
		clicar(By.xpath("//*[@text='Digite aqui sua senha']/.."));
		escrever(By.xpath("//*[@text='Digite aqui sua senha']/../android.widget.EditText"),senha);
		clicarPorTexto("Entrar");

	}
	public void pesquisar() throws InterruptedException 
	{
		escrever(By.xpath("//*[@text='Buscar']"),"Lixas");
		clicar(By.xpath("//*[@text='Lixas']/../android.view.ViewGroup"));
		Thread.sleep(8000);
	}
	
	
	
	
}
