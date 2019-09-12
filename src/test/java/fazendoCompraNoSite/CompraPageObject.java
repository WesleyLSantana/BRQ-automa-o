package fazendoCompraNoSite;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import utilidades.Utilidades;

public class CompraPageObject extends Utilidades {

	private By btnAddToCard = By.name("Submit");
	private By btnProgressirParaOCheckout = By.xpath("//*[@title='Proceed to checkout']");
	private By btnAvancarCheckout = By.xpath("//*[@id='center_column']/p[2]/a[1]/span");
	private By cmpEmail = By.id("email_create");
	private By btnAdicionarNovaConta = By.id("SubmitCreate");
	private By cmpPrimeiroNome = By.id("customer_firstname");
	private By cmpUltimoNome = By.id("customer_lastname");
	private By cmpConfirmarEmail = By.id("email");
	private By cmpSenha = By.id("passwd");
	private By cmpDiaAniv = By.id("days");
	private By cmpMesAniv = By.id("months");
	private By cmpAnoAniv = By.id("years");
	private By cmpEndereco = By.id("address1");
	private By cmpCidade = By.id("city");
	private By cmpInfoAdicionais = By.id("other");
	private By cmpNumTel = By.id("phone_mobile");
	private By cmpAltEmail = By.id("alias");
	private By btnRegistrar = By.id("submitAccount");
	private By cmpCep = By.id("postcode");
	private By radioGeneroMasculino = By.id("id_gender1");
	private By radioGeneroFeminino = By.id("id_gender2");
	private By cmpEstado = By.id("id_state");
	private By cmpEnderecoEntrega = By.id("id_address_delivery");
	private By btnProsseguirParaOCheck3 = By.xpath("//*[@id=\'center_column\']/form/p/button/span");
	private By radioAceitarTermos = By.id("cgv");
	private By btnProsseguirParaOCheck4 = By.xpath("//*[@id=\'form\']/p/button/span");
	private By cmpConferirValorCompra = By.id("total_product");
	private By cmpTransferenciaBancaria = By.xpath("//*[@class='bankwire']");
	private By btnConfirmarCompra = By.xpath("//*[@id=\'cart_navigation\']/button/span");
	
	//variaveis com valores armazenados pelos metodos, para validacoes
	String produtoEscolhido;
	String emailEscolhido;
	String enderecoEscolhido;
	String valorDaCompra;
	
	
	
	
	public void acessarPaginaInicialDoSite() {
		servicos.Driver.getInstance();
	}

	public String escolherProduto(String produto) {
		By produtoEscolhidoParaCompra = By.xpath("//*[contains(text(),'" + produto + "')]");
		esperarAteElementoEstarClicavel(produtoEscolhidoParaCompra);
		clicar(produtoEscolhidoParaCompra);
		this.produtoEscolhido = produto;
		return produtoEscolhido;
	}

	public String adicionarProdutoAoCarrinho() {
		esperarAteElementoEstarClicavel(this.btnAddToCard);
		By cmpValor = By.xpath("//*[@itemprop='price']");
		String pegarValor = acharElemento(cmpValor).getText();
		scroll(btnAddToCard);
		clicar(this.btnAddToCard);
		this.valorDaCompra = pegarValor;
		return valorDaCompra;
		
	}

	public void prosseguirParaOCheckout() {
		espera(2000);
		esperarAteElementoEstarClicavel(this.btnProgressirParaOCheckout);
		clicar(this.btnProgressirParaOCheckout);
	}

	public void verificarStatusCarrinho() {
		espera(2000);
		By itemEscolhidoNoCarrinho = By.xpath("//*[contains(text(),'" + produtoEscolhido + "')]");

		if (acharElemento(itemEscolhidoNoCarrinho).isEnabled()) {
			System.out.println(produtoEscolhido + " Está no carrinho!");
		} else {
			System.out.println("Item escolhido não está no carrinho");
			assertTrue(false);
		}
	}

	public void avancarComCheckout() {
		esperarAteElementoEstarClicavel(this.btnAvancarCheckout);
		scroll(this.btnAvancarCheckout);
		clicar(this.btnAvancarCheckout);
	}

	public String preencherLoginRandom() {
		String loginRandom = geraStringRandomica(7) + "@teste.com.br";
		esperarAteElementoEstarClicavel(this.cmpEmail);
		limpaEInsereTexto(loginRandom, cmpEmail);
		this.emailEscolhido = loginRandom;
		return emailEscolhido;

	}

	public void clicarCriarNovaConta() {
		acharElemento(this.btnAdicionarNovaConta);
		clicar(this.btnAdicionarNovaConta);

		// procura o rádio button da próxima pagina, se encontrar, é porque não
		// encontrou impecílio de login invalido
		esperarAteAPresencaDoElementoDesejado(this.radioGeneroMasculino);
		if (acharElemento(this.radioGeneroMasculino).isDisplayed()) {
			System.out.println("E-mail válido");
		} else {
			System.out.println("E-mail inválido");
			assertTrue(false);	
		}
	}

	public void preenchoRadioGenero(String genero) {
		if (genero.equals("masculino")) {
			acharElemento(this.radioGeneroMasculino);
			clicar(this.radioGeneroMasculino);
		}
		else{
			acharElemento(this.radioGeneroFeminino);
			clicar(this.radioGeneroFeminino);
		}
	}

	public void preencherPrimeiroNome(String primeiroNome) {
		esperarAteElementoEstarClicavel(this.cmpPrimeiroNome);
		limpaEInsereTexto(primeiroNome, this.cmpPrimeiroNome);
	}

	public void preencherUltimoNome(String ultimoNome) {
		limpaEInsereTexto(ultimoNome, this.cmpUltimoNome);
	}

	public void repetirLoginInformado() {
		limpaEInsereTexto(emailEscolhido, this.cmpConfirmarEmail);

	}

	public void informarSenha(String senha) {
		limpaEInsereTexto(senha, this.cmpSenha);

	}

	public void informarDiaAniv(int diaAniv) {	
		selecionarComboPorIndex(this.cmpDiaAniv, diaAniv);
	}

	public void informarMesAniv(int mesAniv) {
		selecionarComboPorIndex(this.cmpMesAniv, mesAniv);
	}

	public void informarAnoAniv(int anoAniv) {
		selecionarComboPorIndex(this.cmpAnoAniv, 2020-anoAniv);
	}

	public String informarEndereco(String endereco) {
		limpaEInsereTexto(endereco, this.cmpEndereco);
		this.enderecoEscolhido = endereco;
		return enderecoEscolhido;
	}

	public void informarCidade(String cidade) {
		limpaEInsereTexto(cidade, this.cmpCidade);

	}

	public void adicionarInformacoesAdicionais() {
		String informacoesAdicionais = geraStringRandomica(40);
		limpaEInsereTexto(informacoesAdicionais, cmpInfoAdicionais);

	}

	public void adicionarNumTel(String numTel) {
		limpaEInsereTexto(numTel, this.cmpNumTel);

	}

	public void adicionarEmailAlternativo(String altEmail) {
		limpaEInsereTexto(altEmail, cmpAltEmail);
	}

	public void clicarRegistrar() {
		clicar(this.btnRegistrar);
	}

	public void preencherCep(String cep) {
		limpaEInsereTexto(cep, this.cmpCep);

	}

	public void informarEstado() {
		selecionarComboPorIndex(this.cmpEstado, 1);
		
	}

	public void conferirEnderecoEProsseguir() {
		esperarAteAPresencaDoElementoDesejado(this.cmpEnderecoEntrega);
		By enderecoDeEntregaConfirmacao = By.xpath("//li[contains(text(),'"+enderecoEscolhido+"')]");
		if(acharElemento(enderecoDeEntregaConfirmacao).isDisplayed()) {
			System.out.println("Endereço de entrega é valido, "+ enderecoEscolhido);
			acharElemento(this.btnProsseguirParaOCheck3);
			clicar(this.btnProsseguirParaOCheck3);
		}
		else {
			System.out.println("Dados inválidos");
			assertTrue(false);
			
		}
		
	}

	public void aceitarOsTermosEProsseguir() {
		acharElemento(this.radioAceitarTermos);
		clicar(this.radioAceitarTermos);
		clicar(this.btnProsseguirParaOCheck4);
	}

	public void conferirValorCompra() {
		espera(3000);
		String cmpValorCompraConferencia = acharElemento(this.cmpConferirValorCompra).getText();
		
		if(cmpValorCompraConferencia.equals(valorDaCompra)) {
			System.out.println( "valor do produto de: " +valorDaCompra+ " válido.");
		}
		else {
			System.out.println("Valor inválido");
		}
		
	}

	public void selecionarFormaPagamento() {
		clicar(this.cmpTransferenciaBancaria);
		
	}

	public void clicarBotaoConfirmarCompra() {
		esperarAteElementoEstarClicavel(this.btnConfirmarCompra);
		clicar(this.btnConfirmarCompra);	
	}

	public void finalizarCompra() {
		By validaCompra = By.xpath("//*[contains(text(),'Your order on My Store is complete.')]");
		By cmpPrecoTotalCompra = By.xpath("//*[@class='price']");
		By centralizaTela = By.id("order_step");
		scroll(centralizaTela);
		espera(1000);
		try {
			String precoTotalDaCompra = acharElemento(cmpPrecoTotalCompra).getText();
			if(acharElemento(validaCompra).isDisplayed() && precoTotalDaCompra.equals(valorDaCompra)) {
				assertTrue(true);
			}
		} catch (Exception e) {
			assertTrue(false);
		}
		
	}

}
