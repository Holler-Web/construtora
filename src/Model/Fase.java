package model;
<<<<<<< HEAD


public class Fase {
    private int codigo;
    private String descricao;


    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }
    public String getDescricao() { 
        return descricao; 
    }
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
=======

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
>>>>>>> e63b041ec7fa2f77c6ebd62d91e50965504b1a9e
}