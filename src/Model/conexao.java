package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String URL =
        "jdbc:mysql://localhost:3306/balanca_mas_nao_cai";

    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(
                URL, USUARIO, SENHA
            );

            System.out.println("Conectado ao MySQL!");
            return conexao;

        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}