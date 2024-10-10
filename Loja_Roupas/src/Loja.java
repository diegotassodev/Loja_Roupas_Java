import javax.swing.JOptionPane;

public class Loja {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Usuario usuario = new Usuario();
        Roupas roupa = new Roupas();
        
        boolean continuar = true;

        while (continuar) {
            
            // Menu inicial com duas categorias para banco de dados: "Usuários" e "Roupas"
            String[] categorias = {"Banco de Dados dos Usuários", "Banco de Dados das Roupas", "Sair"};
            int escolhaCategoria = JOptionPane.showOptionDialog(null, "Escolha uma categoria:", "Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, categorias, categorias[0]);
            
            // Escolha Categoria 2 equivale a opção de saída do sistema.
            if (escolhaCategoria == JOptionPane.CLOSED_OPTION || escolhaCategoria == 2) {
                continuar = false;
            } 
            
            // Escolha Categoria 0 equivale a opções dos usuários
            else if (escolhaCategoria == 0) { 
                String[] opcoesUsuarios = {"Visualizar Usuários", "Adicionar Usuários", "Editar Usuário", "Deletar Usuário", "Voltar"};
                int escolhaUsuario = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu de Usuários", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesUsuarios, opcoesUsuarios[0]);
                
                // Opção de Saída do Sistema
                if (escolhaUsuario == JOptionPane.CLOSED_OPTION || escolhaUsuario == 4) {
                    continue; 
                }
                
                // Switch com as opções no banco de dados do usuários
                switch (escolhaUsuario) {
                    case 0:
                        admin.visualizarBancoDeDadosUsuario();
                        break;
                    case 1:
                        admin.adicionarUsuario();
                        break;
                    case 2:
                        admin.editarUsuario(); 
                        break;
                    case 3:
                        admin.deletarUsuario();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } 
            
            // Escolha Categoria 1 equivale a opções das roupas
            else if (escolhaCategoria == 1) { 
                String[] opcoesRoupas = {"Visualizar Roupas", "Adicionar Roupas", "Editar Roupa", "Deletar Roupa", "Voltar"};
                int escolhaRoupa = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu de Roupas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesRoupas, opcoesRoupas[0]);
                
                // Opção de Saída do Sistema
                if (escolhaRoupa == JOptionPane.CLOSED_OPTION || escolhaRoupa == 4) {
                    continue; 
                }
                
                // Switch com as opções no banco de dados de roupas 
                switch (escolhaRoupa) {
                    case 0:
                        admin.visualizarBancoDeDadosRoupa();
                        break;
                    case 1:
                        admin.adicionarRoupa();
                        break;
                    case 2:
                        admin.editarRoupa(); 
                        break;
                    case 3:
                        admin.deletarRoupa();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Sistema encerrado.", "Encerramento", JOptionPane.INFORMATION_MESSAGE);
    }
}
