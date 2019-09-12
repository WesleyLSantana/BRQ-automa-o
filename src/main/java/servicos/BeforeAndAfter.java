package servicos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilidades.Utilidades;

public class BeforeAndAfter extends Driver {
	 static ExtentReports extent;
	 static ExtentTest logger;
	@Before
	public static void inicializaBrowser() {
		Driver.getInstance().get("http://www.automationpractice.com");
		System.out.println("Início do teste");
	}
		
	@After
	public static void finalizarTeste(Scenario teste){
		new Utilidades().screenshot(teste.getStatus(),teste.getName());
		encerraDriver();
		System.out.println("Teste finalizado");
	}
}
