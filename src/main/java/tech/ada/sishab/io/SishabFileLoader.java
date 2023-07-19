package tech.ada.sishab.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SishabFileLoader {
    public static final int NUMBER_NOT_INFORMED_IDENTIFIER = -1;
    private static String CAMINHO_ARQUIVO = "src/main/resources/contratacoes_pcmv_pcva.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy");
    public List<ObraSisHabRecord> carregarFuncionariosCVS() {
        return carregarFuncionariosCVS(CAMINHO_ARQUIVO);
    }

    public List<ObraSisHabRecord> carregarFuncionariosCVS(String caminhoArquivo) {


        List<ObraSisHabRecord> obras = new ArrayList<>();
        int id = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            br.readLine(); // Remover o cabeçalho

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split("\\|");//gotta escape cause String.split() uses regex
//                System.out.println(id+1);

                String txtUf = dados[0].trim();
                String txtMunicipio = dados[1].trim();
                String txtSituacaoObra = dados[2].trim();
                String txtOrigemContrato = dados[3].trim();
                String txtPrograma = dados[4].trim();
                String txtModalidadePrograma = dados[5].trim();
                String txtFaixaGrupoRenda = dados[6].trim();
                String txtApfCodEmpreendimento = dados[7].trim();
                String txtNomeEmpreendimento = dados[8].trim();
                String txtAgenteFinanceiro = dados[9].trim();

                LocalDate dteAssinaturaContrato = processDateField(dados[10].trim());

                Integer numAnoAssinaturaContrato = replaceGarbage(dados[11].trim());

                Double prcObra = processDoubleValue(dados[12].trim());;
                Double vlrOperacao = processDoubleValue(dados[13].trim());;
                Double vlrContrapartida = processDoubleValue(dados[14].trim());;
                Double vlrLiberado = processDoubleValue(dados[15].trim());;

                LocalDate dteMaxLiberacao = processDateField(dados[16].trim());

                Integer qtdUhContratadas = replaceGarbage(dados[17].trim());
                Integer qtdUhEntregues = replaceGarbage(dados[18].trim());

                String txtCnpjProponente = dados[19].trim();
                String txtRazaoSocialProponente = dados[20].trim();;
                String txtEndereco = dados[21].trim();;
                String txtCep = dados[22].trim();;
                String txtTipologia = dados[23].trim();;

                ObraSisHabRecord obra = new ObraSisHabRecord(id, txtUf, txtMunicipio, txtSituacaoObra, txtOrigemContrato, txtPrograma, txtModalidadePrograma, txtFaixaGrupoRenda, txtApfCodEmpreendimento, txtNomeEmpreendimento, txtAgenteFinanceiro, dteAssinaturaContrato, numAnoAssinaturaContrato, prcObra, vlrOperacao, vlrContrapartida, vlrLiberado, dteMaxLiberacao, qtdUhContratadas, qtdUhEntregues, txtCnpjProponente, txtRazaoSocialProponente, txtEndereco, txtCep, txtTipologia);
                obras.add(obra);
                id = id+1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Could not parse line "+ id);
            e.printStackTrace();
        }

        return obras;
    }

    private Double processDoubleValue(String doubleValue) {
        if(doubleValue==null || doubleValue.isEmpty()){
            return Double.valueOf(NUMBER_NOT_INFORMED_IDENTIFIER);
        }
        try{
            return Double.parseDouble(doubleValue.replace(",","."));
        }catch (NumberFormatException e) {
            return Double.valueOf(NUMBER_NOT_INFORMED_IDENTIFIER);
        }
    }

    private int replaceGarbage(String value) {
        if (value == null || value.isEmpty()){
            return NUMBER_NOT_INFORMED_IDENTIFIER;
        }
        try{
            return Integer.parseInt(value.replaceAll("(\\d)+,.*","$1"));
        } catch (NumberFormatException e) {
            return NUMBER_NOT_INFORMED_IDENTIFIER;
        }
    }

    private LocalDate processDateField(String dateStr){
        String actualDate = !dateStr.isEmpty() ? dateStr.split(" ")[0] : "";
        return actualDate.isEmpty() ? null : LocalDate.parse(actualDate, FORMATTER);
    }
}
