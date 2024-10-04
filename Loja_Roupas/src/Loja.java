import javax.swing.JOptionPane;
public class Loja {
    public static void main (String [] args) {
        Admin admin = new Admin();
        Usuario usuario = new Usuario ();
        Roupas roupa = new Roupas();
        
        boolean continuar = true;

        while (continuar) {
            String[] opcoes = {"Visualizar Usuários", "Adicionar Usuários", "Editar Usuário", "Deletar Usuário", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    admin.visualizarBancoDeDadosUsuario();
                    break;
                case 1:
                    admin.adicionarUsuario();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema encerrado.", "Encerramento", JOptionPane.INFORMATION_MESSAGE);
    }
}

