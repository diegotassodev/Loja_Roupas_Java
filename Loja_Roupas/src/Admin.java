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
            String genero = JOptionPane.showInputDialog("Digite o gênero do usuário:");
            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo do usuário:"));
            
            // Coletando a Data
            String dataNascimentoStr = JOptionPane.showInputDialog("Digite a data de nascimento do usuário (dd/MM/yyyy):");
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimentoDate = formatoData.parse(dataNascimentoStr); // Faz o parse para um objeto Date
            
            // Definindo a Data
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(dataNascimentoDate);
            
            // Voltando a coleta de dados comuns
            int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do usuário:"));
            int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do usuário:"));
            String tipoUsuario = JOptionPane.showInputDialog("Digite o tipo de usuário:");

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
}