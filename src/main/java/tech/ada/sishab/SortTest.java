package tech.ada.sishab;

import tech.ada.sishab.io.ObraSisHabRecord;
import tech.ada.sishab.io.SishabFileLoader;
import tech.ada.sishab.service.SisHabService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SortTest {

    private static String CAMINHO_ARQUIVO = "src/main/resources/simplesample.csv";

    public static void main(String[] args) {
        SishabFileLoader fl = new SishabFileLoader();
        List<ObraSisHabRecord> obraSisHabRecords = fl.carregarFuncionariosCVS(CAMINHO_ARQUIVO);

        SisHabService.sortByDate(obraSisHabRecords);
        for(ObraSisHabRecord obraSisHabRecord: obraSisHabRecords)
            System.out.println(obraSisHabRecord);

        System.out.println();

        SisHabService.sortByState(obraSisHabRecords);
        for(ObraSisHabRecord obraSisHabRecord: obraSisHabRecords)
            System.out.println(obraSisHabRecord);

        obraSisHabRecords = fl.carregarFuncionariosCVS();
        SisHabService.sortByDate(obraSisHabRecords);
        SisHabService.sortByState(obraSisHabRecords);
    }
}