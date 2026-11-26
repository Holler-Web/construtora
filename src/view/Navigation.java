package view;

import java.util.function.Supplier;
import javax.swing.JFrame;

/** Centraliza a troca de telas acionada pelos botões de navegação. */
final class Navigation {
    private Navigation() { }

    static void abrir(JFrame atual, Supplier<? extends JFrame> destino) {
        JFrame proxima = destino.get();
        proxima.setLocationRelativeTo(atual);
        proxima.setVisible(true);
        atual.dispose();
    }
}