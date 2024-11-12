/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package loja.popups;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import loja.parentes_usuario.Cliente;

/**
 *
 * @author Administrator
 */
public class CriarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form Criar
     */
    public CriarUsuario() {
        initComponents();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(textoData);
    }
    
    public CriarUsuarior() {
        try {
                // Captura os dados dos campos de texto da janela de criação.
                String nome = textoNome.getText();
                String email = textoEmail.getText();
                Calendar data = textoData.getText();
                String genero = textoGenero.getText();
                String senha = textoSenha.getText();
                String cpf = textoCPF.getText();
                String telefone = textoTelefone.getText();
                String saldo = textoSaldo.getText();

                if (validarDados()){
                    Cliente cliente = new Cliente (Integer.valueOf(criar.texto.getText()),txtNome.getText());
                    DefaultTableModel tabela = (DefaultTableModel) tabela.getModel();
                    tabela.addRow(cliente.obterDados()); //insere uma linha na tabela
                }

                // Grava os dados em um arquivo de texto
                FileWriter writer = new FileWriter("usuarios.txt", true);
                writer.write("Nome: " + nome + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Data: " + data + "\n");
                writer.write("Gênero: " + genero + "\n");
                writer.write("Senha: " + senha + "\n");
                writer.write("CPF: " + cpf + "\n");
                writer.write("Telefone: " + telefone + "\n");
                writer.write("Tipo: " + tipo + "\n");
                writer.write("Saldo: " + saldo + "\n");
                writer.write("---------------\n");
                writer.close();

            } catch (IOException ex) {
                System.out.println ("Erro!");
            }
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
        labelSaldo = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        textoCPF = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        textoTelefone = new javax.swing.JTextField();
        labelTipo = new javax.swing.JLabel();
        textoTipo = new javax.swing.JComboBox<>();
        textoSaldo = new javax.swing.JFormattedTextField();

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

        labelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSaldo.setText("Saldo");

        labelCPF.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelCPF.setText("CPF");

        labelTelefone.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelTelefone.setText("Telefone");

        labelTipo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelTipo.setText("Tipo de Usuário");

        textoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cliente" }));
        textoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTipoActionPerformed(evt);
            }
        });

        textoSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        textoSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNome)
                    .addComponent(textoTipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 243, Short.MAX_VALUE)
                    .addComponent(textoSenha)
                    .addComponent(textoEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCPF)
                    .addComponent(textoSaldo, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelSaldo))
                    .addComponent(textoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTipoActionPerformed

    private void textoSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoSaldoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTextField textoCPF;
    private javax.swing.JFormattedTextField textoData;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoGenero;
    private javax.swing.JTextField textoNome;
    private javax.swing.JFormattedTextField textoSaldo;
    private javax.swing.JTextField textoSenha;
    private javax.swing.JTextField textoTelefone;
    private javax.swing.JComboBox<Object> textoTipo;
    // End of variables declaration//GEN-END:variables
}
