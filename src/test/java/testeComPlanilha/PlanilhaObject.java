package testeComPlanilha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import utilidades.Utilidades;

public class PlanilhaObject extends Utilidades {
	FileInputStream ARQUIVO;
	XSSFWorkbook PLANILHA;
	XSSFSheet GUIA;

	public void abrindoPlanilha(String caminhoAbsoluto) {
		try {
			//instancia��o do arquivo passando o caminho absoluto do parametro(examples)
			this.ARQUIVO = new FileInputStream(new File(caminhoAbsoluto));
			//instancia��o da planilha conforme o arquivo passado como par�metro
			this.PLANILHA = new XSSFWorkbook(ARQUIVO);
			//abre a aba espec�fica
			this.GUIA = PLANILHA.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pegarSegredosGabriel() {
		//indo pra linha 0
		Row linha = GUIA.getRow(0);
//		//indo pra celula 0
//		String v = linha.getCell(0).getStringCellValue();
		//percorrendo linha por linha e printando o conte�do da primeira c�lula
		Iterator<Row> rowIterator = GUIA.iterator();
		while (rowIterator.hasNext()) {
			// lendo linha por linha e descobrindo os segredos
			Row row = rowIterator.next();
			System.out.println(row.getCell(0));
		}

	}

}
