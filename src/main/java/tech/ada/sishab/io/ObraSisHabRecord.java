package tech.ada.sishab.io;

import java.time.LocalDate;
import java.util.Objects;

public record ObraSisHabRecord(Integer id,
                               String txtUf,
                               String txtMunicipio,
                               String txtSituacaoObra,
                               String txtOrigemContrato,
                               String txtPrograma,
                               String txtModalidadePrograma,
                               String txtFaixaGrupoRenda,
                               String txtApfCodEmpreendimento,
                               String txtNomeEmpreendimento,
                               String txtAgenteFinanceiro,
                               LocalDate dteAssinaturaContrato,
                               Integer numAnoAssinaturaContrato,
                               Double prcObra,
                               Double vlrOperacao,
                               Double vlrContrapartida,
                               Double vlrLiberado,
                               LocalDate dteMaxLiberacao,
                               Integer qtdUhContratadas,
                               Integer qtdUhEntregues,
                               String txtCnpjProponente,
                               String txtRazaoSocialProponente,
                               String txtEndereco,
                               String txtCep,
                               String txtTipologia) implements Comparable<ObraSisHabRecord> {
    public ObraSisHabRecord(Integer id, String txtUf, String txtMunicipio, String txtSituacaoObra, String txtOrigemContrato, String txtPrograma, String txtModalidadePrograma, String txtFaixaGrupoRenda, String txtApfCodEmpreendimento, String txtNomeEmpreendimento, String txtAgenteFinanceiro, LocalDate dteAssinaturaContrato, Integer numAnoAssinaturaContrato, Double prcObra, Double vlrOperacao, Double vlrContrapartida, Double vlrLiberado, LocalDate dteMaxLiberacao, Integer qtdUhContratadas, Integer qtdUhEntregues, String txtCnpjProponente, String txtRazaoSocialProponente, String txtEndereco, String txtCep, String txtTipologia) {
        this.id = id;
        this.txtUf = txtUf;
        this.txtMunicipio = txtMunicipio;
        this.txtSituacaoObra = txtSituacaoObra;
        this.txtOrigemContrato = txtOrigemContrato;
        this.txtPrograma = txtPrograma;
        this.txtModalidadePrograma = txtModalidadePrograma;
        this.txtFaixaGrupoRenda = txtFaixaGrupoRenda;
        this.txtApfCodEmpreendimento = txtApfCodEmpreendimento;
        this.txtNomeEmpreendimento = txtNomeEmpreendimento;
        this.txtAgenteFinanceiro = txtAgenteFinanceiro;
        this.dteAssinaturaContrato = dteAssinaturaContrato;
        this.numAnoAssinaturaContrato = numAnoAssinaturaContrato;
        this.prcObra = prcObra;
        this.vlrOperacao = vlrOperacao;
        this.vlrContrapartida = vlrContrapartida;
        this.vlrLiberado = vlrLiberado;
        this.dteMaxLiberacao = dteMaxLiberacao;
        this.qtdUhContratadas = qtdUhContratadas;
        this.qtdUhEntregues = qtdUhEntregues;
        this.txtCnpjProponente = txtCnpjProponente;
        this.txtRazaoSocialProponente = txtRazaoSocialProponente;
        this.txtEndereco = txtEndereco;
        this.txtCep = txtCep;
        this.txtTipologia = txtTipologia;
    }

    @Override
    public String toString() {
        return "ObraSisHab{" +
                "id=" + id +
                ", txtUf='" + txtUf + '\'' +
                ", txtMunicipio='" + txtMunicipio + '\'' +
                ", txtSituacaoObra='" + txtSituacaoObra + '\'' +
                ", txtOrigemContrato='" + txtOrigemContrato + '\'' +
                ", txtPrograma='" + txtPrograma + '\'' +
                ", txtModalidadePrograma='" + txtModalidadePrograma + '\'' +
                ", txtFaixaGrupoRenda='" + txtFaixaGrupoRenda + '\'' +
                ", txtApfCodEmpreendimento='" + txtApfCodEmpreendimento + '\'' +
                ", txtNomeEmpreendimento='" + txtNomeEmpreendimento + '\'' +
                ", txtAgenteFinanceiro='" + txtAgenteFinanceiro + '\'' +
                ", dteAssinaturaContrato=" + dteAssinaturaContrato +
                ", numAnoAssinaturaContrato=" + numAnoAssinaturaContrato +
                ", prcObra=" + prcObra +
                ", vlrOperacao=" + vlrOperacao +
                ", vlrContrapartida=" + vlrContrapartida +
                ", vlrLiberado=" + vlrLiberado +
                ", dteMaxLiberacao=" + dteMaxLiberacao +
                ", qtdUhContratadas=" + qtdUhContratadas +
                ", qtdUhEntregues=" + qtdUhEntregues +
                ", txtCnpjProponente='" + txtCnpjProponente + '\'' +
                ", txtRazaoSocialProponente='" + txtRazaoSocialProponente + '\'' +
                ", txtEndereco='" + txtEndereco + '\'' +
                ", txtCep='" + txtCep + '\'' +
                ", txtTipologia='" + txtTipologia + '\'' +
                '}';
    }

    @Override
    public int compareTo(ObraSisHabRecord o) {

        int comparacao = numAnoAssinaturaContrato.compareTo(o.numAnoAssinaturaContrato);

        if (comparacao!=0)
            return comparacao;

        if (dteAssinaturaContrato==null)
            return -1;
        return dteAssinaturaContrato.compareTo(o.dteAssinaturaContrato);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObraSisHabRecord that = (ObraSisHabRecord) o;
        return Objects.equals(txtUf, that.txtUf) && Objects.equals(txtMunicipio, that.txtMunicipio) && Objects.equals(txtSituacaoObra, that.txtSituacaoObra) && Objects.equals(txtOrigemContrato, that.txtOrigemContrato) && Objects.equals(txtPrograma, that.txtPrograma) && Objects.equals(txtModalidadePrograma, that.txtModalidadePrograma) && Objects.equals(txtFaixaGrupoRenda, that.txtFaixaGrupoRenda) && Objects.equals(txtApfCodEmpreendimento, that.txtApfCodEmpreendimento) && Objects.equals(txtNomeEmpreendimento, that.txtNomeEmpreendimento) && Objects.equals(txtAgenteFinanceiro, that.txtAgenteFinanceiro) && Objects.equals(dteAssinaturaContrato, that.dteAssinaturaContrato) && Objects.equals(numAnoAssinaturaContrato, that.numAnoAssinaturaContrato) && Objects.equals(prcObra, that.prcObra) && Objects.equals(vlrOperacao, that.vlrOperacao) && Objects.equals(vlrContrapartida, that.vlrContrapartida) && Objects.equals(vlrLiberado, that.vlrLiberado) && Objects.equals(dteMaxLiberacao, that.dteMaxLiberacao) && Objects.equals(qtdUhContratadas, that.qtdUhContratadas) && Objects.equals(qtdUhEntregues, that.qtdUhEntregues) && Objects.equals(txtCnpjProponente, that.txtCnpjProponente) && Objects.equals(txtRazaoSocialProponente, that.txtRazaoSocialProponente) && Objects.equals(txtEndereco, that.txtEndereco) && Objects.equals(txtCep, that.txtCep) && Objects.equals(txtTipologia, that.txtTipologia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txtUf, txtMunicipio, txtSituacaoObra, txtOrigemContrato, txtPrograma, txtModalidadePrograma, txtFaixaGrupoRenda, txtApfCodEmpreendimento, txtNomeEmpreendimento, txtAgenteFinanceiro, dteAssinaturaContrato, numAnoAssinaturaContrato, prcObra, vlrOperacao, vlrContrapartida, vlrLiberado, dteMaxLiberacao, qtdUhContratadas, qtdUhEntregues, txtCnpjProponente, txtRazaoSocialProponente, txtEndereco, txtCep, txtTipologia);
    }
}
