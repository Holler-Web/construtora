package model;

import java.time.LocalDate;

public class EngenheiroObra {
    private int codigo;
    private int engenheiroCodigo;
    private int obraCodigo;
    private int funcaoCodigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public EngenheiroObra() { }

    public EngenheiroObra(int codigo, int engenheiroCodigo, int obraCodigo,
                          int funcaoCodigo, LocalDate dataInicio, LocalDate dataFim) {
        this.codigo = codigo;
        this.engenheiroCodigo = engenheiroCodigo;
        this.obraCodigo = obraCodigo;
        this.funcaoCodigo = funcaoCodigo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getEngenheiroCodigo() { return engenheiroCodigo; }
    public void setEngenheiroCodigo(int codigo) { this.engenheiroCodigo = codigo; }
    public int getObraCodigo() { return obraCodigo; }
    public void setObraCodigo(int obraCodigo) { this.obraCodigo = obraCodigo; }
    public int getFuncaoCodigo() { return funcaoCodigo; }
    public void setFuncaoCodigo(int funcaoCodigo) { this.funcaoCodigo = funcaoCodigo; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
}