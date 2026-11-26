package view;

import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

final class FormSupport {
    private FormSupport() { }

    static boolean camposObrigatorios(Component tela, String[] nomes, JTextField... campos) {
        if (nomes.length != campos.length) {
            throw new IllegalArgumentException("A lista de nomes deve corresponder aos campos.");
        }
        for (int i = 0; i < campos.length; i++) {
            if (campos[i].getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(tela,
                        "Preencha o campo " + nomes[i] + ".",
                        "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
                campos[i].requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    static boolean dataISOValida(Component tela, String nome, JTextField campo) {
        try {
            LocalDate.parse(campo.getText().trim());
            return true;
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(tela,
                    "Informe " + nome + " no formato AAAA-MM-DD.",
                    "Data inválida", JOptionPane.WARNING_MESSAGE);
            campo.requestFocusInWindow();
            return false;
        }
    }

    static boolean emailValido(Component tela, JTextField campo) {
        String email = campo.getText().trim();
        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            JOptionPane.showMessageDialog(tela,
                    "Informe um e-mail válido.",
                    "E-mail inválido", JOptionPane.WARNING_MESSAGE);
            campo.requestFocusInWindow();
            return false;
        }
        return true;
    }
    static void limpar(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
        if (campos.length > 0) {
            campos[0].requestFocusInWindow();
        }
    }

    static void informarPersistenciaPendente(Component tela) {
        JOptionPane.showMessageDialog(tela,
                "Os campos foram validados. O cadastro ainda não foi salvo: falta conectar o DAO ao banco.",
                "Banco de dados pendente", JOptionPane.INFORMATION_MESSAGE);
    }
}