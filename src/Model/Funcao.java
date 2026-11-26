package model;
<<<<<<< HEAD

=======
>>>>>>> e63b041ec7fa2f77c6ebd62d91e50965504b1a9e

public class Funcao {
    private int codigo;
    private String nome;

<<<<<<< HEAD

    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }
    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }
=======
    public Funcao() { }

    public Funcao(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
>>>>>>> e63b041ec7fa2f77c6ebd62d91e50965504b1a9e
}