import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;

public class Admin extends Usuario {
    
    // Atributos Extras
    private int idFuncionario;
    private List<Usuario> bancoDeDadosUsuarios;
     
    // Construtora puxando o banco de dados
    public Admin () {
        bancoDeDadosUsuarios = new ArrayList<>();
    }

    // Get e Sets
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    } 

    // Visualizar o banco de dados de usuários
    public void visualizarBancoDeDadosUsuario() {
        
        // Criando objeto para formatação de data
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            if (bancoDeDadosUsuarios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder lista = new StringBuilder("Lista de Usuários:\n");
            for (Usuario usuario : bancoDeDadosUsuarios) {
                
                // Formatando a data de nascimento
                String dataNascimentoFormatada = formatoData.format(usuario.getData_nascimento().getTime());
                
                // Mostrando a lista de usuários
                lista.append("ID: ").append(usuario.getId()).append("\n")
                     .append("Nome: ").append(usuario.getNome()).append("\n")
                     .append("Email: ").append(usuario.getEmail()).append("\n")
                     .append("Senha: ").append(usuario.getSenha()).append("\n")
                     .append("Genero: ").append(usuario.getGenero()).append("\n")
                     .append("Saldo: ").append(usuario.getSaldo()).append("\n")
                     .append("Data de Nascimento: ").append(dataNascimentoFormatada).append("\n") // Data formatada
                     .append("CPF: ").append(usuario.getCpf()).append("\n")
                     .append("Telefone: ").append(usuario.getTelefone()).append("\n")
                     .append("Tipo de Usuário: ").append(usuario.getTipo_usuario()).append("\n")
                     .append("-----------------------------\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString(), "Banco de Dados de Usuários", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para adicionar usuário
    public void adicionarUsuario() {
        try {
            // Coleta os dados de entrada do usuário
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário:"));
            String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
            String email = JOptionPane.showInputDialog("Digite o email do usuário:");
            String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");
            
            // Criando Gêneros Predefinidos para escolha com dropdown
            String[] generos = {"Masculino", "Feminino", "Outro"};
            String genero = (String) JOptionPane.showInputDialog(null, "Selecione o gênero do usuário:", "Gênero", JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
            
            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo do usuário:"));
            
            // Coletando a Data
            String dataNascimentoStr = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (dd/MM/yyyy):");
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimentoDate = formatoData.parse(dataNascimentoStr); // Faz o parse para um objeto Date
            
            // Definindo a Data
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(dataNascimentoDate);
            
            // Voltando a coleta de dados comuns
            String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do usuário:");
            
            String[] tipoUsuarios = {"Admin", "Cliente"};
            String tipoUsuario = (String) JOptionPane.showInputDialog(null, "Selecione o tipo do usuário:", "Tipo de Usuário", JOptionPane.QUESTION_MESSAGE, null, tipoUsuarios, tipoUsuarios[0]);

            // Criação de um novo objeto Usuario
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setGenero(genero);
            usuario.setSaldo(saldo);
            usuario.setData_nascimento(dataNascimento); 
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);
            usuario.setTipo_usuario(tipoUsuario);

            // Adiciona o usuário ao banco de dados
            bancoDeDadosUsuarios.add(usuario);

            // Confirmação de sucesso
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println (ex);
        }
    }
    
    // Método para buscar o usuário pelo ID, essencial para edição e remoção
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : bancoDeDadosUsuarios) {
            if (usuario.getId() == id) {

                // Se o ID bater, retorna o usuário encontrado
                return usuario;
            }
        }
        // Se nenhum usuário com o ID for encontrado, retorna null
        return null;
    }
    
    // Método para edição do usuário
    public void editarUsuario() {
        try {
            // Coleta o ID do usuário que deseja editar
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que deseja editar:"));

            // Verifica se o usuário existe no banco de dados
            Usuario usuario = buscarUsuarioPorId(id);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Opções de campos para o administrador editar
            String[] campos = {"Nome", "Email", "Senha", "Gênero", "Saldo", "Data de Nascimento", "CPF", "Telefone", "Tipo de Usuário"};

            // Apresenta as opções para o adm escolher qual campo deseja editar
            String campoSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o campo que deseja editar:", "Editar Usuário", JOptionPane.QUESTION_MESSAGE, null, campos, campos[0]);

            // Verifica o campo selecionado e permite a edição do mesmo
            switch (campoSelecionado) {
                case "Nome":
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
                    usuario.setNome(novoNome);
                    break;
                case "Email":
                    String novoEmail = JOptionPane.showInputDialog("Digite o novo email:");
                    usuario.setEmail(novoEmail);
                    break;
                case "Senha":
                    String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:");
                    usuario.setSenha(novaSenha);
                    break;
                case "Gênero":
                    String[] generos = {"Masculino", "Feminino", "Outro"};
                    String novoGenero = (String) JOptionPane.showInputDialog(null, "Selecione o novo gênero:", "Gênero", JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
                    usuario.setGenero(novoGenero);
                    break;
                case "Saldo":
                    double novoSaldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo saldo:"));
                    usuario.setSaldo(novoSaldo);
                    break;
                case "Data de Nascimento":
                    String novaDataNascimentoStr = JOptionPane.showInputDialog("Digite a nova data de nascimento (dd/MM/yyyy):");
                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                    Date novaDataNascimentoDate = formatoData.parse(novaDataNascimentoStr);
                    Calendar novaDataNascimento = Calendar.getInstance();
                    novaDataNascimento.setTime(novaDataNascimentoDate);
                    usuario.setData_nascimento(novaDataNascimento);
                    break;
                case "CPF":
                    String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF:");
                    usuario.setCpf(novoCpf);
                    break;
                case "Telefone":
                    String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:");
                    usuario.setTelefone(novoTelefone);
                    break;
                case "Tipo de Usuário":
                    String[] tiposUsuarios = {"Admin", "Cliente"};
                    String novoTipoUsuario = (String) JOptionPane.showInputDialog(null, "Selecione o novo tipo de usuário:", "Tipo de Usuário", JOptionPane.QUESTION_MESSAGE, null, tiposUsuarios, tiposUsuarios[0]);
                    usuario.setTipo_usuario(novoTipoUsuario);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Mensagem de sucesso após a edição
            JOptionPane.showMessageDialog(null, "Campo atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
    
    // Método para remoção de um usuário
    public void deletarUsuario() {
        try {
            // Coleta o ID do usuário que deseja remover
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que deseja remover:"));

            // Verifica se o usuário existe no banco de dados
            Usuario usuario = buscarUsuarioPorId(id);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Confirmação antes de remover
            int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                // Remove o usuário do banco de dados
                bancoDeDadosUsuarios.remove(usuario);
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
}