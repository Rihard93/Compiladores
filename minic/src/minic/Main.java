/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ricardo
 */
public class Main extends javax.swing.JFrame {
    
    public File Entrada,S1;
    public String Ruta,Ruta1;
    Reader Lector;
    

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnCarga = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniC");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Ruta");
        jLabel1.setToolTipText("");

        txtRuta.setEnabled(false);

        btnCarga.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCarga.setText("Cargar Archivo");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAnalizar.setText("Analizar Archivo");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Resultado Analizador Lexico");

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        txtInfo.setEnabled(false);
        jScrollPane2.setViewportView(txtInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtRuta))
                            .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        // TODO add your handling code here:

        String Direccion = System.getProperty("user.home");
        JFileChooser Seleccionar = new JFileChooser(Direccion + "/Desktop");
        Seleccionar.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de Texto (.frag)", "frag"));
        Seleccionar.addChoosableFileFilter(new FileNameExtensionFilter("Archivo de Texto (.txt)", "txt"));                
        Seleccionar.setAcceptAllFileFilterUsed(false);
        Seleccionar.showDialog(this,"Seleccionar");
        Entrada = Seleccionar.getSelectedFile();
        Ruta = Entrada.getAbsolutePath();
        txtRuta.setText(Ruta);
    }//GEN-LAST:event_btnCargaActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:

        try
        {
            AnalizarArchivo();
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    public void AnalizarArchivo() throws IOException
    {
        Archivos();
        FileInputStream Leer = new FileInputStream(Ruta);
        Lector = new InputStreamReader(Leer);
        Lexer lexer = new Lexer(Lector);
        String Resultado = "";
        
        while (true)
        {
            Token token = lexer.yylex();
            
            if (token == null) // Cuando el token sea nulo, se detiene el ciclo
            {
                Resultado = Resultado + "*** FIN DEL ARCHIVO ***";
                txtInfo.setText(Resultado);
                Finalizar(Resultado); //Metodo para escribir el archivo de salida
                JOptionPane.showMessageDialog(null, "Ubicacion del archivo .out:" + "\n" + Ruta1, "Informacion" , JOptionPane.INFORMATION_MESSAGE);
                break;                
            }
            else
            {
                switch (token) //Cases para cado token que retorne al analizador lexico
                {
                    case ERROR:
                        Resultado = Resultado + " *** ERROR LINEA " + (lexer.linea +1) + " ***" + "   " + "Caracter no reconocido: " + lexer.analizar + "\n";                        
                        break;
                        
                    case Palabra_Reservada:                        
                        Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: Palabra Reservada " + "\n";
                        break;
                        
                    case Constante_Booleana:
                        Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: Constante Booleana " + "\n";
                        break;
                        
                    case Identificador:
                        if (lexer.analizar.length() <= 31)
                        {
                            Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: Identificador " + "\n";
                        }
                        else
                        {
                            Resultado = Resultado + lexer.analizar.substring(0, 30) + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.substring(0,30).length()) + "   " + "Token: Identificador Truncado " + "\n"; 
                        }
                        break;
                        
                    case Numero_Entero:
                        Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: Numero Entero " + " " + "(Valor = " + lexer.analizar + ")" + "\n";
                        break;
                        
                    case Numero_Hexadecimal:
                        Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: Numero Hexadecimal "+ " " + "(Valor = " + lexer.analizar + ")" + "\n";
                        break;
                        
                    case Double:
                         Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: " +token+ " " + "(Valor = " + lexer.analizar + ")" + "\n";
                        break;
                        
                    case Comentario_Incompleto:
                        Resultado = Resultado + " *** ERROR LINEA " + (lexer.linea +1) + " ***" + "   " + "Comentario Incompleto - Falta cierre de comentario multilinea " + "\n";     
                        break;                    

                    default:
                        Resultado = Resultado + lexer.analizar + "   " + "Linea: " +(lexer.linea +1) + "   " + "Columna: " + (lexer.columna+1) + "-" + ((lexer.columna + 1) + lexer.analizar.length()-1) + "   " + "Token: " + token + "\n";
                        break;
                }                    
            }
        }
    }    

    public void Archivos() //Metodo que obtiene la ruta actual y crea el archivo .out;
    {
        Ruta1 = Ruta.substring(0, Ruta.length()-3);
        Ruta1 = Ruta1 + "out";
    }
    public void Finalizar(String Resultado) throws IOException //Metodo que escribe en el archivo de salida
    {       
        FileWriter Escritor = new FileWriter(new File(Ruta1));
        Escritor.write(Resultado);
        Escritor.close();              
    }    
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
