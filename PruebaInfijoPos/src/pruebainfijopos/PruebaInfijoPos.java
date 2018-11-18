/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebainfijopos;



/**
 *
 * @author Ricardo
 */
public class PruebaInfijoPos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("*Escribe una expresión algebraica: ");
    //Scanner leer = new Scanner(System.in);
    
    String Leer = "25+25+25+25*8";
    Posfijo Stage1 = new Posfijo(Leer);
    String Posfijo = Stage1.getPostFix();
    
    Solver Stage2 = new Solver(Posfijo);
    
    System.out.println("Conversion PosFijo: " + Stage1.getPostFix());
    System.out.println("Resultado Operacion: " + Stage2.getResult());

    //Depurar la expresion algebraica
    }
}
