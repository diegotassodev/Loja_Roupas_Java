import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;

public class Admin extends Usuario {
    
    // Atributos Extras
    private int idFuncionario;
    
    // Criando Listas de Bancos de Dados
    private List<Usuario> bancoDeDadosUsuarios;
    private List<Roupas> bancoDeDadosRoupas;
     
    // Construtora puxando o banco de dados
    public Admin () {
        bancoDeDadosUsuarios = new ArrayList<>();
        bancoDeDadosRoupas = new ArrayList<>();
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
    
    // Método para ver o banco de dados de roupas
    public void visualizarBancoDeDadosRoupa() {
        // Criando objeto para formatação de data
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (bancoDeDadosRoupas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma roupa cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder lista = new StringBuilder("Lista de Roupas:\n");
            for (Roupas roupa : bancoDeDadosRoupas) {

                // Formatando a data de estoque
                String dataEstoqueFormatada = formatoData.format(roupa.getDataEstocada().getTime());

                // Mostrando a lista de roupas
                lista.append("ID: ").append(roupa.getId()).append("\n")
                     .append("Nome: ").append(roupa.getNome()).append("\n")
                     .append("Valor: ").append(roupa.getValor()).append("\n")
                     .append("Marca: ").append(roupa.getMarca()).append("\n")
                     .append("Tipo de Roupa: ").append(roupa.getTipo_roupa()).append("\n")
                     .append("Quantia Estocada: ").append(roupa.getQuantiaEstocada()).append("\n")
                     .append("Data de Estoque: ").append(dataEstoqueFormatada).append("\n")
                     .append("-----------------------------\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString(), "Banco de Dados de Roupas", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao visualizar o banco de dados de roupas", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
    
    // Método para buscar roupas por id
    public Roupas buscarRoupaPorId(int id) {
        for (Roupas roupa : bancoDeDadosRoupas) {
            if (roupa.getId() == id) {

                // Se o ID bater, retorna a roupa encontrada
                return roupa;
            }
        }
        // Se nenhum usuário com o ID for encontrado, retorna null
        return null;
    }
    // Método para adicionar um objeto de roupa.
    public void adicionarRoupa() {
        try {
            // Coleta os dados de entrada da roupa
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da roupa:"));
            String nome = JOptionPane.showInputDialog("Digite o nome da roupa:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da roupa:"));
            String marca = JOptionPane.showInputDialog("Digite a marca da roupa:");
            
            // Criando tipos Predefinidos para escolha com dropdown
            String[] tipoRoupas = {"Camisa", "Casaco", "Calça", "Tênis"};
            String tipoRoupa = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de roupa:", "Tipo Roupa", JOptionPane.QUESTION_MESSAGE, null, tipoRoupas, tipoRoupas[0]);
            
            int quantiaRoupa = Integer.parseInt(JOptionPane.showInputDialog("Selecione a quantia de roupas estocadas"));
            
            // Coletando a Data estocada
            String dataEstoqueStr = JOptionPane.showInputDialog("Digite a data de estoque da roupa (dd/MM/yyyy):");
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataEstoqueDate = formatoData.parse(dataEstoqueStr); 
            
            // Definindo a Data
            Calendar dataEstoque = Calendar.getInstance();
            dataEstoque.setTime(dataEstoqueDate);

            // Criação de um novo objeto Roupa
            Roupas roupa = new Roupas();
            roupa.setId(id);
            roupa.setNome(nome);
            roupa.setValor(valor);
            roupa.setMarca(marca);
            roupa.setTipo_roupa(tipoRoupa);
            roupa.setQuantiaEstocada(quantiaRoupa);
            roupa.setDataEstocada(dataEstoque);
            // Não ter o Tamanho é proposital porque vamos adicionar futuramente baseado em suas variáveis filhas.
            
            // Adiciona o usuário ao banco de dados
            bancoDeDadosRoupas.add(roupa);

            // Confirmação de sucesso
            JOptionPane.showMessageDialog(null, "Roupa adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar a Roupa", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println (ex);
        }
    }
        
    public void editarRoupa() {
        try {
            // Coleta o ID da roupa que deseja editar
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da roupa que deseja editar:"));

            // Verifica se a roupa existe no banco de dados
            Roupas roupa = buscarRoupaPorId(id);
            if (roupa == null) {
                JOptionPane.showMessageDialog(null, "Roupa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Opções de campos para o administrador editar
            String[] campos = {"Nome", "Valor", "Marca", "Tipo de Roupa", "Quantia Estocada", "Data de Estoque"};

            // Apresenta as opções para o admin escolher qual campo deseja editar
            String campoSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o campo que deseja editar:", "Editar Roupa", JOptionPane.QUESTION_MESSAGE, null, campos, campos[0]);

            // Verifica o campo selecionado e permite a edição do mesmo
            switch (campoSelecionado) {
                case "Nome":
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome da roupa:");
                    roupa.setNome(novoNome);
                    break;
                case "Valor":
                    double novoValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor da roupa:"));
                    roupa.setValor(novoValor);
                    break;
                case "Marca":
                    String novaMarca = JOptionPane.showInputDialog("Digite a nova marca da roupa:");
                    roupa.setMarca(novaMarca);
                    break;
                case "Tipo de Roupa":
                    String[] tipoRoupas = {"Camisa", "Casaco", "Calça", "Tênis"};
                    String novoTipoRoupa = (String) JOptionPane.showInputDialog(null, "Selecione o novo tipo de roupa:", "Tipo de Roupa", JOptionPane.QUESTION_MESSAGE, null, tipoRoupas, tipoRoupas[0]);
                    roupa.setTipo_roupa(novoTipoRoupa);
                    break;
                case "Quantia Estocada":
                    int novaQuantia = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantia estocada:"));
                    roupa.setQuantiaEstocada(novaQuantia);
                    break;
                case "Data de Estoque":
                    String novaDataEstoqueStr = JOptionPane.showInputDialog("Digite a nova data de estoque (dd/MM/yyyy):");
                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                    Date novaDataEstoqueDate = formatoData.parse(novaDataEstoqueStr);
                    Calendar novaDataEstoque = Calendar.getInstance();
                    novaDataEstoque.setTime(novaDataEstoqueDate);
                    roupa.setDataEstocada(novaDataEstoque);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Mensagem de sucesso após a edição
            JOptionPane.showMessageDialog(null, "Roupa atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar a roupa", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public void deletarRoupa() {
        try {
            // Coleta o ID da roupa que deseja remover
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da roupa que deseja remover:"));

            // Verifica se a roupa existe no banco de dados
            Roupas roupa = buscarRoupaPorId(id);
            if (roupa == null) {
                JOptionPane.showMessageDialog(null, "Roupa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Remove a roupa do banco de dados
            bancoDeDadosRoupas.remove(roupa);

            // Mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Roupa removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover a roupa", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
}