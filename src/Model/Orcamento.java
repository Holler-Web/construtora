package model;

import java.time.LocalDate;

public class Orcamento {
    private int codigo;
    private int obraCodigo;
    private LocalDate dataAprovacao;
    private String responsavelElaboracao;

    public Orcamento() { }

    public Orcamento(int codigo, int obraCodigo, LocalDate dataAprovacao,
                     String responsavelElaboracao) {
        this.codigo = codigo;
        this.obraCodigo = obraCodigo;
        this.dataAprovacao = dataAprovacao;
        this.responsavelElaboracao = responsavelElaboracao;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getObraCodigo() { return obraCodigo; }
    public void setObraCodigo(int obraCodigo) { this.obraCodigo = obraCodigo; }
    public LocalDate getDataAprovacao() { return dataAprovacao; }
    public void setDataAprovacao(LocalDate dataAprovacao) { this.dataAprovacao = dataAprovacao; }
    public String getResponsavelElaboracao() { return responsavelElaboracao; }
    public void setResponsavelElaboracao(String responsavelElaboracao) {
        this.responsavelElaboracao = responsavelElaboracao;
    }
}