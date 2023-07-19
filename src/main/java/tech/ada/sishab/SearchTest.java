package tech.ada.sishab;

import tech.ada.sishab.io.ObraSisHabRecord;
import tech.ada.sishab.io.SishabFileLoader;
import tech.ada.sishab.service.SisHabService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SearchTest {

    private static String CAMINHO_ARQUIVO = "src/main/resources/simplesample.csv";

    public static void main(String[] args) {
        SishabFileLoader fl = new SishabFileLoader();
        List<ObraSisHabRecord> obraSisHabRecords = fl.carregarFuncionariosCVS(CAMINHO_ARQUIVO);
        SisHabService service = new SisHabService();

        service.fillObraMap(obraSisHabRecords);
        List<ObraSisHabRecord> result = service.fulltextSearch("RESIDENCIAL");

        for (ObraSisHabRecord o:result){
            System.out.println(o);
        }
        System.out.println();

        obraSisHabRecords = fl.carregarFuncionariosCVS();
        service.fillObraMap(obraSisHabRecords);
        result = service.fulltextSearch("RESIDENCIAL");
        for (ObraSisHabRecord o:result){
            System.out.println(o);
        }

    }
}