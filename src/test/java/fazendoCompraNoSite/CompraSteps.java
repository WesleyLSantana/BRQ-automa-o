package fazendoCompraNoSite;

import cucumber.api.java.es.Dado;
import cucumber.api.java.gl.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

public class CompraSteps {

	private static CompraPageObject compraPage;

	public CompraSteps() {

		compraPage = new CompraPageObject();
	}

	@Dado("que acesso o site")
	public void acessarOSite() {
		compraPage.acessarPaginaInicialDoSite();
	}

	@Quando("escolho um produto \"([^\"]*)\"$")
	public void escolherProduto(String produto) {
		compraPage.escolherProduto(produto);

	}

	@E("adiciono o produto escolhido ao carrinho")
	public void adicionarProdutoAoCarrinho() {
		compraPage.adicionarProdutoAoCarrinho();
	}

	@E("prossigo para o checkout")
	public void prosseguirParaOCheckout() {
		compraPage.prosseguirParaOCheckout();
	}

	@E("confirmo se o produto esta no carrinho para continuar a compra")
	public void verificoStatusCarrinho() {
		compraPage.verificarStatusCarrinho();
	}

	@E("clico no botao para avancar")
	public void darContinuidadeComCheckout() {
		compraPage.avancarComCheckout();
	}

	@E("forneco um endereco de email para criar uma conta")
	public void preencherLoginRandom() {
		//email para login sendo gerado de forma aleatoria
		compraPage.preencherLoginRandom();
	}

	@E("clico no botao para criar uma nova conta")
	public void clicoNoBotaoAdicionarNovaConta() {
		compraPage.clicarCriarNovaConta();
	}

	@E("preencho minhas informacoes pessoais comecando por genero \"([^\"]*)\"$")
	public void preenchoRadioGenero(String genero) {
		compraPage.preenchoRadioGenero(genero);
	}

	@E("informo meu primeiro nome \"([^\"]*)\"$")
	public void preencherPrimeiroNome(String primeiroNome) {
		compraPage.preencherPrimeiroNome(primeiroNome);
	}

	@E("informo meu ultimo nome \"([^\"]*)\"$")
	public void preencherUltimoNome(String ultimoNome) {
		compraPage.preencherUltimoNome(ultimoNome);
	}

	@E("informo novamente o endereco de mesmo endereco de email que escolhi")
	public void repetirLoginInformado() {
		compraPage.repetirLoginInformado();
	}

	@E("informo uma senha \"([^\"]*)\"$")
	public void informarSenha(String senha) {
		compraPage.informarSenha(senha);
	}

	@E("informo meu dia de aniversario \"([^\"]*)\"$")
	public void informarDiaAniversario(int diaAniv) {
		compraPage.informarDiaAniv(diaAniv);
	}

	@E("informo meu mes de aniversario \"([^\"]*)\"$")
	public void informarMesAniversario(int mesAniv) {
		compraPage.informarMesAniv(mesAniv);
	}

	@E("informo meu ano de nascimento \"([^\"]*)\"$")
	public void informarAnoNascimento(int anoNasc) {
		compraPage.informarAnoAniv(anoNasc);
	}

	@E("informo o endereco \"([^\"]*)\"$")
	public void informarEndereco(String endereco) {
		compraPage.informarEndereco(endereco);
	}

	@E("informo a cidade \"([^\"]*)\"$")
	public void indormarCidade(String cidade) {
		compraPage.informarCidade(cidade);
	}
	@E("informo o estado")
	public void informarEstado() {
		compraPage.informarEstado();
	}
	@E("preencho o Cep \"([^\"]*)\"$")
	public void preencherCep(String cep) {
		compraPage.preencherCep(cep);
	}
	@E("adiciono informacoes adicionais")
	public void adicionarInformacoesAdicionais() {
		// campo sendo preenchido com caracteres random
		compraPage.adicionarInformacoesAdicionais();
	}
	@E("adiciono um numero de telefone \"([^\"]*)\"$")
	public void adicionarNumTelefone(String numTel) {
		compraPage.adicionarNumTel(numTel);
	}
	@E("adiciono um email alternativo \"([^\"]*)\"$")
	public void informarEmailAlternativo(String altEmail) {
		compraPage.adicionarEmailAlternativo(altEmail);
	}
	@E("clico em 'registrar'")
	public void clicarRegistrar() {
		compraPage.clicarRegistrar();
	}
	@E("confiro se o endereco de entrega esta correto e prossigo")
	public void conferirEnderecoEProsseguir() {
		compraPage.conferirEnderecoEProsseguir();
	}
	@E("aceito os termos de servico e prossigo")
	public void aceitarOsTermosEProsseguir() {
		compraPage.aceitarOsTermosEProsseguir();
	}
	@E("confiro o valor da compra")
	public void conferirValorCompra() {
		compraPage.conferirValorCompra();
	}
	@E("seleciono a forma de pagamento como transferencia bancaria")
	public void selecionarFormaPagamento() {
		compraPage.selecionarFormaPagamento();
	}
	@E("clico no botao para confirmar a compra")
	public void clicarBotaoConfirmarCompra() {
		compraPage.clicarBotaoConfirmarCompra();
	}
	@Então("minha compra foi realizada com sucesso")
	public void finalizarCompra() {
		compraPage.finalizarCompra();
	}
}
