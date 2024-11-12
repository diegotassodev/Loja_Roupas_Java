package loja.render;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class CellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Centraliza o conteúdo
        setHorizontalAlignment(SwingConstants.CENTER);

        // Chama o método da superclasse para obter o componente padrão
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Se a linha estiver selecionada, escureça o fundo
        if (isSelected) {
            cell.setBackground(new Color(28, 28, 28)); // Cor de fundo quando selecionado
            cell.setForeground(Color.WHITE); // Cor do texto quando selecionado
        } else {
            cell.setBackground(new Color(40, 40, 40)); // Cor de fundo quando selecionado

        }

        return cell;
    }
}