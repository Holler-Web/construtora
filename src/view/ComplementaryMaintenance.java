package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/** Telas de apoio para os cadastros que ainda não possuem DAO. */
public class ComplementaryMaintenance extends JFrame {
    private static final String DATE = "Data (AAAA-MM-DD)";
    private static final String[] OBRA = {"Código", "Número", "Descrição", "Início", "Fim", "Código do engenheiro responsável"};
    private static final String[] FASE_OBRA = {"Código", "Código da obra", "Código da fase", "Início", "Fim"};
    private static final String[] EQUIPE = {"Código", "Código do engenheiro", "Código da obra", "Código da função", "Início", "Fim"};
    private static final String[] ORCAMENTO = {"Código", "Código da obra", "Data de aprovação", "Responsável pela elaboração"};
    private static final String[] PREVISAO = {"Código", "Código do orçamento", "Data inicial", "Data final", "Valor previsto", "Valor realizado"};

    public ComplementaryMaintenance() {
        super("Obras, equipe e orçamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Obras", createTab(OBRA, new String[]{"Código", "Número", "Descrição", "Data de início", "Data de fim", "Código do engenheiro responsável"}, new String[]{"integer", "text", "text", "date", "date", "integer"}));
        tabs.addTab("Fases da obra", createTab(FASE_OBRA, new String[]{"Código", "Código da obra", "Código da fase", "Data de início", "Data de fim"}, new String[]{"integer", "integer", "integer", "date", "date"}));
        tabs.addTab("Equipe", createTab(EQUIPE, new String[]{"Código", "Código do engenheiro", "Código da obra", "Código da função", "Data de início", "Data de fim"}, new String[]{"integer", "integer", "integer", "integer", "date", "date"}));
        tabs.addTab("Orçamentos", createTab(ORCAMENTO, new String[]{"Código", "Código da obra", "Data de aprovação", "Responsável pela elaboração"}, new String[]{"integer", "integer", "date", "text"}));
        tabs.addTab("Previsões", createTab(PREVISAO, new String[]{"Código", "Código do orçamento", "Data inicial", "Data final", "Valor previsto", "Valor realizado"}, new String[]{"integer", "integer", "date", "date", "decimal", "decimal"}));
        add(tabs, BorderLayout.CENTER);
        setSize(1050, 560);
        setLocationRelativeTo(null);
    }

    private JPanel createTab(String[] columns, String[] prompts, String[] types) {
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton add = new JButton("Inserir");
        JButton consult = new JButton("Consultar");
        JButton edit = new JButton("Alterar");
        JButton delete = new JButton("Excluir");
        actions.add(add); actions.add(consult); actions.add(edit); actions.add(delete);
        panel.add(actions, BorderLayout.SOUTH);
        add.addActionListener(e -> insert(model, prompts, types));
        consult.addActionListener(e -> consult(table, model));
        edit.addActionListener(e -> edit(table, model, prompts, types));
        delete.addActionListener(e -> delete(table, model));
        return panel;
    }

    private void insert(DefaultTableModel model, String[] prompts, String[] types) {
        Map<String, String> values = form(prompts, types, null);
        if (values == null) return;
        model.addRow(values.values().toArray());
        pending();
    }

    private void edit(JTable table, DefaultTableModel model, String[] prompts, String[] types) {
        int row = table.getSelectedRow();
        if (row < 0) { message("Selecione uma linha para alterar."); return; }
        row = table.convertRowIndexToModel(row);
        Map<String, String> initial = new LinkedHashMap<>();
        for (int i = 0; i < prompts.length; i++) initial.put(prompts[i], String.valueOf(model.getValueAt(row, i)));
        Map<String, String> values = form(prompts, types, initial);
        if (values == null) return;
        for (int i = 0; i < values.size(); i++) model.setValueAt(values.values().toArray()[i], row, i);
        pending();
    }

    private void delete(JTable table, DefaultTableModel model) {
        int row = table.getSelectedRow();
        if (row < 0) { message("Selecione uma linha para excluir."); return; }
        row = table.convertRowIndexToModel(row);
        if (JOptionPane.showConfirmDialog(this, "Excluir este item da lista temporária?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            model.removeRow(row);
            pending();
        }
    }

    private void consult(JTable table, DefaultTableModel model) {
        String term = JOptionPane.showInputDialog(this, "Digite um texto para localizar na tabela (deixe vazio para mostrar todos):", "Consultar", JOptionPane.QUESTION_MESSAGE);
        if (term == null) return;
        table.clearSelection();
        int found = 0;
        String search = term.trim().toLowerCase();
        for (int r = 0; r < model.getRowCount(); r++) {
            boolean match = search.isEmpty();
            for (int c = 0; c < model.getColumnCount() && !match; c++) match = String.valueOf(model.getValueAt(r, c)).toLowerCase().contains(search);
            if (match) { int viewRow = table.convertRowIndexToView(r); table.addRowSelectionInterval(viewRow, viewRow); if (found == 0) table.scrollRectToVisible(table.getCellRect(viewRow, 0, true)); found++; }
        }
        message(found + " registro(s) encontrado(s) na lista desta sessão. O banco ainda não está conectado.");
    }

    private Map<String, String> form(String[] prompts, String[] types, Map<String, String> initial) {
        Map<String, JTextField> fields = new LinkedHashMap<>();
        JPanel form = new JPanel(new java.awt.GridLayout(prompts.length, 2, 8, 6));
        for (String prompt : prompts) {
            JTextField field = new JTextField(initial == null ? "" : initial.get(prompt), 22);
            fields.put(prompt, field);
            form.add(new JLabel(prompt + ":")); form.add(field);
        }
        while (true) {
            int result = JOptionPane.showConfirmDialog(this, form, initial == null ? "Inserir registro" : "Alterar registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result != JOptionPane.OK_OPTION) return null;
            Map<String, String> values = new LinkedHashMap<>();
            String error = null;
            for (int i = 0; i < prompts.length; i++) {
                String value = fields.get(prompts[i]).getText().trim();
                if (value.isEmpty()) { error = "Preencha o campo " + prompts[i] + "."; break; }
                try {
                    if (types[i].equals("integer")) Integer.parseInt(value);
                    if (types[i].equals("date")) LocalDate.parse(value);
                    if (types[i].equals("decimal") && new BigDecimal(value.replace(',', '.')).signum() < 0) error = "O valor não pode ser negativo.";
                } catch (NumberFormatException ex) { error = "Informe um número válido em " + prompts[i] + "."; }
                  catch (DateTimeParseException ex) { error = "Informe a data no formato AAAA-MM-DD em " + prompts[i] + "."; }
                if (error != null) break;
                values.put(prompts[i], value);
            }
            if (error == null) return values;
            JOptionPane.showMessageDialog(this, error, "Verifique os dados", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void pending() {
        JOptionPane.showMessageDialog(this, "A alteração está apenas nesta sessão. Para gravar no banco, ainda falta implementar e conectar o DAO.", "DAO pendente", JOptionPane.INFORMATION_MESSAGE);
    }
    private void message(String text) { JOptionPane.showMessageDialog(this, text, "Aviso", JOptionPane.INFORMATION_MESSAGE); }
}
