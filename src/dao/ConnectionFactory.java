package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abre conexões JDBC quando as configurações do banco do professor forem fornecidas.
 * Configuração por propriedades Java (construtora.db.url/user/password) ou por
 * variáveis de ambiente (CONSTRUTORA_DB_URL/USER/PASSWORD).
 */
public final class ConnectionFactory {
    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        String url = setting("construtora.db.url", "CONSTRUTORA_DB_URL");
        if (url == null || url.isBlank()) {
            throw new SQLException(
                    "Configure construtora.db.url ou CONSTRUTORA_DB_URL com a URL do banco.");
        }

        String user = setting("construtora.db.user", "CONSTRUTORA_DB_USER");
        String password = setting("construtora.db.password", "CONSTRUTORA_DB_PASSWORD");

        if (user == null || user.isBlank()) {
            return DriverManager.getConnection(url);
        }
        return DriverManager.getConnection(url, user, password == null ? "" : password);
    }

    private static String setting(String property, String environmentVariable) {
        String value = System.getProperty(property);
        if (value == null || value.isBlank()) {
            value = System.getenv(environmentVariable);
        }
        return value;
    }
}