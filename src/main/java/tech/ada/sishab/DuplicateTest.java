package tech.ada.sishab;

import tech.ada.sishab.io.ObraSisHabRecord;
import tech.ada.sishab.io.SishabFileLoader;
import tech.ada.sishab.service.SisHabService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class DuplicateTest {

    private static String CAMINHO_ARQUIVO = "src/main/resources/duplicatesample.csv";

    public static void main(String[] args) {
        SishabFileLoader fl = new SishabFileLoader();
        List<ObraSisHabRecord> obraSisHabRecords = fl.carregarFuncionariosCVS(CAMINHO_ARQUIVO);

        List<ObraSisHabRecord> listaqSemDuplicatas = SisHabService.removerDuplicatas(obraSisHabRecords);
        for(ObraSisHabRecord obraSisHabRecord: listaqSemDuplicatas)
            System.out.println(obraSisHabRecord);

    }
}