package testeComPlanilha;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;

public class PlanilhaSteps {

	private static PlanilhaObject planilhaObject;

	public PlanilhaSteps() {

		planilhaObject = new PlanilhaObject();
	}

	@Dado("que acesso a planilha \"([^\"]*)\"$")
	public void acessarPlanilha(String caminhoAbsoluto) {
		planilhaObject.abrindoPlanilha(caminhoAbsoluto);
		
	}
	@Quando("pego os dados da coluna do segredo")
	public void pegarSegredosGabriel() {
		planilhaObject.pegarSegredosGabriel();
	} 
	
}
