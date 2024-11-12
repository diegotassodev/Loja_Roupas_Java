package loja.abas.administrativas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import loja.popups.CriarUsuario;
import loja.tabbed.TabbedForm;
import raven.toast.Notifications;
import loja.parentes_usuario.Admin;
import loja.parentes_usuario.Cliente;
import loja.popups.CriarCliente;
import loja.render.CellRenderer;

public class TabelaClientes extends TabbedForm {
    
    // Criando o  nome do arquivo texto.
    private static final String nomeArquivo = "clientes.txt";
    
    // Classe construtora iniciando os componentes
    public TabelaClientes() {
        initComponents();
        init();
    }
    
    public void init () {
              
        // Carregando os Dados do arquivo de texto para a tabela.
        carregarTabela();
            
       // Aplicando o renderer personalizado para centralizar os dados
       for (int i = 0; i < tabela.getColumnCount(); i++) {
           tabela.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
       }

       jSeparator1.setPreferredSize(new java.awt.Dimension(20, 0));

       textoBusca.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               textoBuscaActionPerformed(evt);
           }
       });
       
        // Iniciando as informações de design na tabela.
        painel.putClientProperty(FlatClientProperties.STYLE,""
            + "arc:25;"
            + "background:$Table.background");
        
        tabela.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
            + "height:30;"
            + "hoverBackground:null;"
            + "pressedBackground:null;"
            + "separatorColor:$TableHeader.background;"
            + "font:bold;");
        
        tabela.putClientProperty(FlatClientProperties.STYLE, ""
            + "rowHeight:30;"
            + "showHorizontalLines:true;"
            + "intercellSpacing:0,1;"
            + "cellFocusColor:$TableHeader.hoverBackground;"
            + "selectionBackground:$TableHeader.hoverBackground"
            + "selectionForeground:$Table.foreground;");
        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");
        
        tituloBusca.putClientProperty(FlatClientProperties.STYLE, ""
             + "font:bold +5;");

        textoBusca.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar por usuários...");
        textoBusca.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("loja/icones/search.svg"));
        textoBusca.putClientProperty(FlatClientProperties.STYLE, ""
            + "arc:15;"
            + "borderWidth:0;"
            + "focusWidth:0;"
            + "innerFocusWidth:0;"
            + "margin:5,20,5,20;"
            + "background:$Panel.background");
        
         // Confirmando seleção única
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Configurando o renderizador personalizado para a tabela
        tabela.setDefaultRenderer(Object.class, new CellRenderer());

        // Adicionando o MouseListener para seleção de linhas
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                Point point = evt.getPoint();
                int row = table.rowAtPoint(point);
                if (row >= 0) {
                    table.setRowSelectionInterval(row, row); // Seleciona a linha clicada
                }
            }
        });
    }
    
    // Função para carregar os dados do arquivo de texto para a tabela.
    public void carregarTabela() {
        String linha;
        DefaultTableModel dtm_cliente = (DefaultTableModel) tabela.getModel();
        
        try {
            BufferedReader r_cliente = new BufferedReader(new FileReader(nomeArquivo));
            while ((linha = r_cliente.readLine()) != null) { 
                String[] campos = linha.split(",");
                dtm_cliente.addRow(campos);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Erro: Formato de dados incorreto no arquivo." + e.getMessage());
        }
    }
    
    // Função que atualiza a tabela.
    public void atualizarTabela() {
        // Limpa a tabela antes de recarregar
        DefaultTableModel dtm_cliente = (DefaultTableModel) tabela.getModel();
        dtm_cliente.setRowCount(0);

        // Recarrega os dados do arquivo
        carregarTabela();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        textoBusca = new javax.swing.JTextField();
        tituloBusca = new javax.swing.JLabel();
        excluirUsuario = new loja.swing.ButtonAction();
        editarUsuario = new loja.swing.ButtonAction();
        cadastrarUsuario = new loja.swing.ButtonAction();

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Senha", "Gênero", "Nascimento", "CPF", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        jSeparator1.setPreferredSize(new java.awt.Dimension(20, 0));

        textoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoBuscaActionPerformed(evt);
            }
        });

        tituloBusca.setText("CLIENTES");

        excluirUsuario.setText("Excluir");
        excluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirUsuarioActionPerformed(evt);
            }
        });

        editarUsuario.setText("Editar");
        editarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarUsuarioActionPerformed(evt);
            }
        });

        cadastrarUsuario.setText("Cadastrar");
        cadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addComponent(tituloBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cadastrarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(excluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoBuscaActionPerformed

    private void excluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirUsuarioActionPerformed
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente remover este usuário?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Remove a linha da tabela
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                model.removeRow(row);

                // Atualiza o arquivo
                salvarDadosNoArquivo();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.");
        }
    }//GEN-LAST:event_excluirUsuarioActionPerformed

    private void editarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarUsuarioActionPerformed
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            // Obter os dados do cliente selecionado
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            String nome = (String) model.getValueAt(row, 0);
            String email = (String) model.getValueAt(row, 1);
            String senha = (String) model.getValueAt(row, 2);
            String genero = (String) model.getValueAt(row, 3);
            String data = (String) model.getValueAt(row, 4);
            String cpf = (String) model.getValueAt(row, 5);
            String telefone = (String) model.getValueAt(row, 6);

            // Criando objeto da nova janela e do usuario que realizará as ações.
            CriarCliente criar = new CriarCliente();
            criar.operacao = "edicao"; // Define a operação como edição
            criar.indiceCliente = row; // Passa o índice do cliente que está sendo editado

            // Preencher os campos com os dados do cliente selecionado
            criar.textoNome.setText(nome);
            criar.textoEmail.setText(email);
            criar.textoSenha.setText(senha);
            criar.textoGenero.setText(genero);
            criar.textoData.setText(data);
            criar.textoCPF.setText(cpf);
            criar.textoTelefone.setText(telefone);

            // Cria um JFrame para abrir a nova janela
            JFrame janelaEditar = new JFrame("Editar Usuário");
            janelaEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            janelaEditar.setSize(400, 500);
            janelaEditar.setLocationRelativeTo(null); 
            janelaEditar.setLayout(new BorderLayout());

            // Adiciona o painel de criação ao centro da janela
            janelaEditar.add(criar, BorderLayout.CENTER);

            // Cria o painel de botões
            JPanel painelBotoes = new JPanel();
            JButton btnCancel = new JButton("Cancelar");
            JButton btnSave = new JButton("Salvar");
            painelBotoes.add(btnCancel);
            painelBotoes.add(btnSave);

            // Adiciona o painel de botões ao sul da janela
            janelaEditar.add(painelBotoes, BorderLayout.SOUTH);

            // Ação do botão "Salvar"
            btnSave.addActionListener(e -> {
                criar.salvarDados(); // Salva os dados (atualiza ou cria)
                atualizarTabela(); // Atualiza a tabela para refletir as mudanças
                janelaEditar.dispose(); // Fecha a janela de edição
            });

            // Ação do botão "Cancelar"
            btnCancel.addActionListener(e -> janelaEditar.dispose()); 

            // Exibe a janela
            janelaEditar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para editar.");
        }
    }//GEN-LAST:event_editarUsuarioActionPerformed
    
    public void salvarDadosNoArquivo() {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    linha.append(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        linha.append(",");
                    }
                }
                writer.write(linha.toString());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + e.getMessage());
        }
    }
    
    private void cadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarUsuarioActionPerformed
        
        // Criando objeto da nova janela e do usuario que realizará as ações.
        CriarCliente criar = new CriarCliente();
        criar.operacao = "criacao"; // Define a operação como edição

        // Cria um JFrame para abrir a nova janela
        JFrame janelaCriar = new JFrame("Criar Usuário");
        janelaCriar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaCriar.setSize(400, 500);
        janelaCriar.setLocationRelativeTo(null); 
        janelaCriar.setLayout(new BorderLayout());

        // Adiciona o painel de criação ao centro da janela
        janelaCriar.add(criar, BorderLayout.CENTER);

        // Cria o painel de botões
        JPanel painelBotoes = new JPanel();
        JButton btnCancel = new JButton("Cancelar");
        JButton btnSave = new JButton("Salvar");
        painelBotoes.add(btnCancel);
        painelBotoes.add(btnSave);

        // Adiciona o painel de botões ao sul da janela
        janelaCriar.add(painelBotoes, BorderLayout.SOUTH);

        // Ação do botão "Salvar"
        btnSave.addActionListener(e -> {
            criar.salvarDados();
            atualizarTabela();
        });

        // Ação do botão "Cancelar"
        btnCancel.addActionListener(e -> janelaCriar.dispose()); 

        // Exibe a janela
        janelaCriar.setVisible(true);
    }//GEN-LAST:event_cadastrarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private loja.swing.ButtonAction cadastrarUsuario;
    private loja.swing.ButtonAction editarUsuario;
    private loja.swing.ButtonAction excluirUsuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane scroll;
    public javax.swing.JTable tabela;
    private javax.swing.JTextField textoBusca;
    private javax.swing.JLabel tituloBusca;
    // End of variables declaration//GEN-END:variables
}
