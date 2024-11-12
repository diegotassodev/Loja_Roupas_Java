package loja.popups;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import loja.abas.administrativas.TabelaClientes;
import loja.parentes_usuario.Cliente;

public class CriarCliente extends javax.swing.JPanel {
    
    private static final String nomeArquivo = "clientes.txt";
    
    public int indiceCliente;
    public String operacao;
    
    TabelaClientes tabelaclientes = new TabelaClientes();

    public CriarCliente() {
        initComponents();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(textoData);
    }
    
    public void salvarDados() {
        // Verificando se os dados escritos são válidos.
        if (!validarDados()) {
            JOptionPane.showMessageDialog(this, "Por favor, corrija os erros antes de salvar.", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            // Captura os dados dos campos de texto da janela de criação.
            String nome = textoNome.getText();
            String email = textoEmail.getText();
            String data = textoData.getText(); 
            String genero = textoGenero.getText();
            String senha = textoSenha.getText();
            String cpf = textoCPF.getText();
            String telefone = textoTelefone.getText();

            if (operacao.equals("criacao")) {
                // Grava os dados em um arquivo de texto no formato correto
                FileWriter writer = new FileWriter(nomeArquivo, true);
                writer.write(nome + "," + email + "," + senha + "," + genero + "," + data + "," + cpf + "," + telefone + "\n");
                writer.close();
            } 
            else if (operacao.equals("edicao")) {
                // Atualiza os dados do cliente na tabela
                DefaultTableModel model = (DefaultTableModel) tabelaclientes.tabela.getModel(); // Acesso à tabela
                model.setValueAt(nome, indiceCliente, 0);
                model.setValueAt(email, indiceCliente, 1);
                model.setValueAt(senha, indiceCliente, 2);
                model.setValueAt(genero, indiceCliente, 3);
                model.setValueAt(data, indiceCliente, 4);
                model.setValueAt(cpf, indiceCliente, 5);
                model.setValueAt(telefone, indiceCliente, 6);

                // Atualiza o arquivo
                tabelaclientes.salvarDadosNoArquivo(); // Chama o método para atualizar o arquivo com os dados editados
            }

            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar campos após salvar
            textoNome.setText("");
            textoEmail.setText("");
            textoData.setText("");
            textoGenero.setText("");
            textoSenha.setText("");
            textoCPF.setText("");
            textoTelefone.setText("");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Validação de dados automaticamente.
    public boolean validarDados() {
        // Verifica se o nome não está vazio
        if (textoNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro: Nome não pode estar vazio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o email não está vazio e tem um formato válido
        String email = textoEmail.getText();
        if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Erro: E-mail inválido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

         // Verifica se a data não está vazia e tem um formato válido (exemplo: DD/MM/AAAA)
         String data = textoData.getText();
         if (data.isEmpty() || !data.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Erro: Data inválida. Use o formato DD/MM/AAAA.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o gênero não está vazio
        if (textoGenero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro: Gênero não pode estar vazio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se a senha não está vazia e tem no mínimo 6 caracteres
        String senha = textoSenha.getText();
        if (senha.isEmpty() || senha.length() < 6) {
            JOptionPane.showMessageDialog(this, "Erro: A senha deve ter pelo menos 6 caracteres.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o CPF não está vazio e tem exatamente 11 dígitos
        String cpf = textoCPF.getText();
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro: CPF inválido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o telefone não está vazio e tem pelo menos 10 dígitos
        String telefone = textoTelefone.getText();
        if (telefone.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Erro: Telefone inválido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
             return false;
         }

        // Se todas as validações passarem, retorna true
        return true;
    }
    
    // Preenchimento de dados automático para edição.
    public void preencherDados(Cliente cliente) {
        textoNome.setText(cliente.getNome());
        textoEmail.setText(cliente.getEmail());
        textoSenha.setText(cliente.getSenha());
        textoGenero.setText(cliente.getGenero());
        textoData.setText(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getData_nascimento().getTime()));
        textoCPF.setText(cliente.getCpf());
        textoTelefone.setText(cliente.getTelefone());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        textoData = new javax.swing.JFormattedTextField();
        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        labelGenero = new javax.swing.JLabel();
        textoGenero = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        textoSenha = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        textoCPF = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        textoTelefone = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setRequestFocusEnabled(false);

        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelNome.setText("Nome");

        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelEmail.setText("Email");

        labelData.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelData.setText("Nascimento");

        labelGenero.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelGenero.setText("Gênero");

        labelSenha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSenha.setText("Senha");

        labelCPF.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelCPF.setText("CPF");

        labelTelefone.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelTelefone.setText("Telefone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(textoSenha)
                    .addComponent(textoEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCPF)
                    .addComponent(textoTelefone)
                    .addComponent(textoGenero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoData, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelNome))
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelEmail))
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelSenha))
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelData))
                    .addComponent(textoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelGenero))
                    .addComponent(textoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.datetime.component.date.DatePicker datePicker;
    public javax.swing.JLabel labelCPF;
    public javax.swing.JLabel labelData;
    public javax.swing.JLabel labelEmail;
    public javax.swing.JLabel labelGenero;
    public javax.swing.JLabel labelNome;
    public javax.swing.JLabel labelSenha;
    public javax.swing.JLabel labelTelefone;
    public javax.swing.JTextField textoCPF;
    public javax.swing.JFormattedTextField textoData;
    public javax.swing.JTextField textoEmail;
    public javax.swing.JTextField textoGenero;
    public javax.swing.JTextField textoNome;
    public javax.swing.JTextField textoSenha;
    public javax.swing.JTextField textoTelefone;
    // End of variables declaration//GEN-END:variables
}
