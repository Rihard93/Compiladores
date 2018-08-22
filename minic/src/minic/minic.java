/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;
import java.io.File;

/**
 *
 * @author Ricardo
 */
public class minic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String Ruta ="C:/Users/Ricardo/Documents/Universidad/Compiladores/Proyecto/minic/src/minic/Lexer.txt";
        GenerarLexer(Ruta);
    }
    
    public static void GenerarLexer(String Path)
    {
        File file = new File(Path);
        jflex.Main.generate(file);
    }
    
}
