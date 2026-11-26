package model;

public class Fase {
    private int codigo;
    private int numero;
    private String descricao;

    public Fase() { }

    public Fase(int codigo, int numero, String descricao) {
        this.codigo = codigo;
        this.numero = numero;
        this.descricao = descricao;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}