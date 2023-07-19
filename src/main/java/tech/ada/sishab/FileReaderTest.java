package tech.ada.sishab;

import tech.ada.sishab.io.EntradaDeDados;
import tech.ada.sishab.io.ObraSisHabRecord;
import tech.ada.sishab.io.SishabFileLoader;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class FileReaderTest {

    private static String CAMINHO_ARQUIVO = "src/main/resources/simplesample.csv";

    public static void main(String[] args) {
        SishabFileLoader fl = new SishabFileLoader();
        List<ObraSisHabRecord> obraSisHabRecords = fl.carregarFuncionariosCVS(CAMINHO_ARQUIVO);
//        System.out.println(obraSisHabRecords);

        obraSisHabRecords = fl.carregarFuncionariosCVS();

        for(ObraSisHabRecord obraSisHabRecord: obraSisHabRecords)
            System.out.println(obraSisHabRecord);

    }
}