package model;

import java.time.LocalDate;

public class FaseObra {
    private int codigo;
    private int obraCodigo;
    private int faseCodigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public FaseObra() { }

    public FaseObra(int codigo, int obraCodigo, int faseCodigo,
                    LocalDate dataInicio, LocalDate dataFim) {
        this.codigo = codigo;
        this.obraCodigo = obraCodigo;
        this.faseCodigo = faseCodigo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getObraCodigo() { return obraCodigo; }
    public void setObraCodigo(int obraCodigo) { this.obraCodigo = obraCodigo; }
    public int getFaseCodigo() { return faseCodigo; }
    public void setFaseCodigo(int faseCodigo) { this.faseCodigo = faseCodigo; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
}