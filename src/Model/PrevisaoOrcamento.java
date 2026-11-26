package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrevisaoOrcamento {
    private int codigo;
    private int orcamentoCodigo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private BigDecimal valorPrevisto;
    private BigDecimal valorRealizado;

    public PrevisaoOrcamento() { }

    public PrevisaoOrcamento(int codigo, int orcamentoCodigo, LocalDate dataInicial,
                             LocalDate dataFinal, BigDecimal valorPrevisto,
                             BigDecimal valorRealizado) {
        this.codigo = codigo;
        this.orcamentoCodigo = orcamentoCodigo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorPrevisto = valorPrevisto;
        this.valorRealizado = valorRealizado;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getOrcamentoCodigo() { return orcamentoCodigo; }
    public void setOrcamentoCodigo(int codigo) { this.orcamentoCodigo = codigo; }
    public LocalDate getDataInicial() { return dataInicial; }
    public void setDataInicial(LocalDate dataInicial) { this.dataInicial = dataInicial; }
    public LocalDate getDataFinal() { return dataFinal; }
    public void setDataFinal(LocalDate dataFinal) { this.dataFinal = dataFinal; }
    public BigDecimal getValorPrevisto() { return valorPrevisto; }
    public void setValorPrevisto(BigDecimal valorPrevisto) { this.valorPrevisto = valorPrevisto; }
    public BigDecimal getValorRealizado() { return valorRealizado; }
    public void setValorRealizado(BigDecimal valorRealizado) { this.valorRealizado = valorRealizado; }
}