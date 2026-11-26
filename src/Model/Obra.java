package model;

import java.time.LocalDate;

public class Obra {
    private int codigo;
    private String numero;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int engenheiroResponsavelCodigo;

    public Obra() { }

    public Obra(int codigo, String numero, String descricao, LocalDate dataInicio,
                LocalDate dataFim, int engenheiroResponsavelCodigo) {
        this.codigo = codigo;
        this.numero = numero;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.engenheiroResponsavelCodigo = engenheiroResponsavelCodigo;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public int getEngenheiroResponsavelCodigo() { return engenheiroResponsavelCodigo; }
    public void setEngenheiroResponsavelCodigo(int codigo) { this.engenheiroResponsavelCodigo = codigo; }
}