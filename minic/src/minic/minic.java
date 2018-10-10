/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author Ricardo
 */
public class minic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      
        GenerarLexer();
        GenerarSintaxis();
    }
    
    public static void GenerarLexer()
    {
        String[] Lexico = {"C:/Users/Ricardo/Documents/Universidad/Compiladores/Proyecto/minic/src/minic/Lexer.txt"}; 
        jflex.Main.main(Lexico);
        
    }
    
    public static  void GenerarSintaxis() throws IOException, Exception
    {
        String RutaCup ="C:/Users/Ricardo/Documents/Universidad/Compiladores/Proyecto/minic/src/minic/Cup.txt";
        String[] Sintactico = {"-parser", "Sintaxis", RutaCup};
        java_cup.Main.main(Sintactico);
        moverArch("Sintaxis.java");
        moverArch("sym.java");
    }
    
        public static void moverArch(String archNombre) {
        //boolean efectuado = false;
        File arch = new File(archNombre);
        if (arch.exists()) {
            System.out.println("\n*** Moviendo " + arch + " \n***");
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "minic" + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + archNombre + "***\n");
               // efectuado = true;
            } else {
                System.out.println("\n*** No movido " + archNombre + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo no existente ***\n");
        }
        //return efectuado;
    }
    
}
