package tech.ada.sishab;

import tech.ada.sishab.io.EntradaDeDados;

public class SisHabOperations {

    private EntradaDeDados leitor;
    private final String DIGITE_OPCAO_DESEJADA = "Digite a opção desejada: ";
    private final String OPCAO_SAIR = "x";
    private final String OPCAO_CADASTRAR_FUNCIONARIO = "1";
    private final String OPCAO_LISTAR_FUNCIONARIOS = "2";
    private final String OPCAO_CADASTRAR_EM_LOTE = "3";
    private final String OPCAO_BUSCA_POR_ID = "4";
    private final String OPCAO_BUSCA_POR_NOME = "5";
    
    public SisHabOperations(EntradaDeDados leitor) {
        this.leitor = leitor;
        iniciaApp();
    }

    private void iniciaApp() {
        System.out.println("******************************************");
        System.out.println("*******          SISHAB          *********");
        System.out.println("******************************************");
    }

    public void processar() {
        String opcaoDigitada = obterEntradaDoUsuario(leitor);

        while(!escolheuSair(opcaoDigitada)){
            tratarOpcaoSelecionada(opcaoDigitada);
            opcaoDigitada = obterEntradaDoUsuario(leitor);
        }

        finalizaApp();
    }

    private void tratarOpcaoSelecionada(String opcaoDigitada) {
//        switch (opcaoDigitada){
//            case OPCAO_SAIR:
//                break;
//            case OPCAO_CADASTRAR_FUNCIONARIO:
//                this.inserirFuncionario(construirFuncionario(++ultimoIdFuncionario, leitor));
//                System.out.println("Cadastro realizado com sucesso!");
//                pularLinha(2);
//                break;
//            case OPCAO_LISTAR_FUNCIONARIOS:
//                listarFuncionarios();
//                pularLinha(2);
//                break;
//            case OPCAO_CADASTRAR_EM_LOTE:
//                carregarFuncionariosEmLote();
//                break;
//            case OPCAO_BUSCA_POR_ID:
//                buscaPorIdHashMap();
//                break;
//            case OPCAO_BUSCA_POR_NOME:
//                buscaPorNomeHashMap();
//                break;
//            default:
//                opcaoInvalida();
//                break;
//        }
    }

    private void finalizaApp() {
        System.out.println("flw");
    }

    private boolean escolheuSair(String opcaoDigitada) {
        return opcaoDigitada.equals(OPCAO_SAIR);
    }

    private String obterEntradaDoUsuario(EntradaDeDados leitor) {
        carregaMenu();
        System.out.print(DIGITE_OPCAO_DESEJADA);
        return leitor.obterEntrada().toLowerCase();
    }

    private void carregaMenu() {
        System.out.println("********  DIGITE A OPÇÃO DESEJADA   ******");
        System.out.println("1 - CADASTRAR FUNCIONÁRIO(A)");
        System.out.println("2 - LISTAR FUNCIONÁRIOS(AS)");
        System.out.println("3 - CADASTRO EM LOTE (CSV)");
        System.out.println("4 - PESQUISAR POR ID");
        System.out.println("5 - PESQUISAR POR NOME");
        System.out.println("X - SAIR");
    }

    
}
