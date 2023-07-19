package tech.ada.sishab.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SishabFileLoader {
    private static String CAMINHO_ARQUIVO = "src/main/resources/contratacoes_pcmv_pcva.csv";

    public List<ObraSisHab> carregarFuncionariosCVS(){

        List<ObraSisHab> obras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {

            br.readLine(); // Remover o cabeçalho

            String linha;
            int id = 0;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("|");

                id = id++;
                String stringValue = dados[0].trim();
                double doubleValue = Double.parseDouble(dados[2].trim());
                double intValue = Integer.parseInt(dados[2].trim());

                String txtUf = "";
                String txtMunicipio = null;
                String txtSituacaoObra = null;
                String txtOrigemContrato = null;
                String txtPrograma = null;
                String txtModalidadePrograma = null;
                String txtFaixaGrupoRenda = null;
                String txtApfCodEmpreendimento = null;
                String txtNomeEmpreendimento = null;
                String txtAgenteFinanceiro = null;
                LocalDate dteAssinaturaContrato = null;
                Integer numAnoAssinaturaContrato = null;
                Double prcObra = null;
                Double vlrOperacao = null;
                Double vlrContrapartida = null;
                Double vlrLiberado = null;
                LocalDate dteMaxLiberacao = null;
                Integer qtdUhContratadas = null;
                Integer qtdUhEntregues = null;
                String txtCnpjProponente = null;
                String txtRazaoSocialProponente = null;
                String txtEndereco = null;
                String txtCep = null;
                String txtTipologia = null;

                ObraSisHab obra = new ObraSisHab(id, txtUf, txtMunicipio, txtSituacaoObra, txtOrigemContrato, txtPrograma, txtModalidadePrograma, txtFaixaGrupoRenda, txtApfCodEmpreendimento, txtNomeEmpreendimento, txtAgenteFinanceiro, dteAssinaturaContrato, numAnoAssinaturaContrato, prcObra, vlrOperacao, vlrContrapartida, vlrLiberado, dteMaxLiberacao, qtdUhContratadas, qtdUhEntregues, txtCnpjProponente, txtRazaoSocialProponente, txtEndereco, txtCep, txtTipologia);
                obras.add(obra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return obras;

    }
}
