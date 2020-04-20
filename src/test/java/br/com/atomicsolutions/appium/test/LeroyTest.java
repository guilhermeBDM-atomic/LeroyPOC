package br.com.atomicsolutions.appium.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.atomicsolutions.appium.core.BaseTest;
import br.com.atomicsolutions.appium.pages.leroy.HomePage;
import br.com.atomicsolutions.appium.pages.leroy.ProdutosPage;

public class LeroyTest extends BaseTest {

	private HomePage home = new HomePage();
	private ProdutosPage produtos = new ProdutosPage();
	
	@Test
	public void testScenario() throws Exception 
	{
		home.configurarApp();
		home.login("guilhermeborba79@gmail.com","guigui47");
		home.pesquisar();
		produtos.escolherTipoLixa();
		produtos.escolherMaterialLixa();
		produtos.ordenar();
		produtos.escolherLixa();
		produtos.ClicarNoFavorito();
		produtos.CriarListaFav();
	}
	
	
}
