/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Anne Livia da Fonseca Macedo

//******************************************************

package cadastroDisciplina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author annel
 */
public class ListaDisciplinas extends javax.swing.JFrame {

    /**
     * Creates new form ListaDisciplinas
     */
    public ListaDisciplinas() {
        initComponents();
        loadTable(); 
    }
    // Este é um jFrame extra no qual irá mostrar uma tabela contendo os campos do banco de dados com exceção do id
    private void loadTable()
    {
        try{
            String cmd = "SELECT * FROM Disciplina"; // Utilizando select para obter todos os dados da tabela
            Connection con = ConexaoMySQL.getInstance().getConnection(); // criando a conexão com o banco de dados
            ResultSet res = con.createStatement().executeQuery(cmd); // obtendo os dados da tabela
            while(res.next()) // enquanto houver valores o loop será executado
            {
                String nomeDisDB = res.getString("nomeDisciplina"); // da coluna nomeDisciplina do banco de dados, será capturado os valores ao decorrer do loop, e estes valores serão armazenados nesta variavel
                int cargaDB = res.getInt("cargaHoraria"); // O mesmo que ocorre com a linha de codigo acima
                String cursoDB = res.getString("curso");  // ** 
                int vagasDB = res.getInt("vagas");  // **
                String periodoDB = res.getString("periodo"); // **
                Vector v = new Vector(); // Criando um vector para armazenar todos os dados que foram armazenados nas variaveis acima
                v.add(nomeDisDB); // Armazenando no vector
                v.add(cursoDB); // Armazenando no vector
                v.add(vagasDB); // Armazenando no vector
                v.add(cargaDB); // Armazenando no vector
                v.add(periodoDB); // Armazenando no vector
                ((DefaultTableModel)jTableDisciplinas.getModel()).addRow(v); // Colocando as informações do vector na table.
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisciplinas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(480, 477));
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Disciplinas Cadastradas");

        jTableDisciplinas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableDisciplinas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Curso", "Vagas", "Carga Horária", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDisciplinas);

        jMenu1.setText("Opções");

        jMenuItem1.setText("Cadastrar Disciplinas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Deletar Disciplinas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         // Botão utilizado para poder com ele alterar de frame, ao apertar neste botão, este frame será fechado e 
        // o frame no qual contem a tela telaCadastro será aberto.
        TelaCadastro newTela = new TelaCadastro(); // Criando uma instancia da frame telaCadastro
        newTela.setVisible(true); // deixando ela vizivel
        dispose(); // fechando o frame atual
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        // Botão utilizado para poder com ele alterar de frame, ao apertar neste botão, este frame será fechado e 
        // o frame DeleteDisciplinas será aberto.
        DeleteDisciplinas newTela = new DeleteDisciplinas(); // Criando uma instancia da frame DeleteDisciplinas
        newTela.setVisible(true); // deixando ela vizivel
        dispose();  // fechando o frame atual
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDisciplinas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisciplinas;
    // End of variables declaration//GEN-END:variables
}
