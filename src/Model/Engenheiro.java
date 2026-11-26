package model;

import java.time.LocalDate;

public class Engenheiro {
    private int codigo;
    private String nome;
    private String crea;
    private LocalDate admissao;

    public Engenheiro() { }

    public Engenheiro(int codigo, String nome, String crea, LocalDate admissao) {
        this.codigo = codigo;
        this.nome = nome;
        this.crea = crea;
        this.admissao = admissao;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrea() { return crea; }
    public void setCrea(String crea) { this.crea = crea; }
    public LocalDate getAdmissao() { return admissao; }
    public void setAdmissao(LocalDate admissao) { this.admissao = admissao; }
}