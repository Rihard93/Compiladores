/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;
import java.util.Stack;

/**
 *
 * @author Ricardo
 */
public class Solver {
    
    String Operacion;
    
    public Solver(String OP)
    {
        Operacion = Operar(OP);
    }
    
public static String Operar(String Op)
  {
      
     String[] post = Op.split(" ");   
   
    //Declaración de las pilas
    Stack < String > E = new Stack < String > (); //Pila entrada
    Stack < String > P = new Stack < String > (); //Pila de operandos

    //Añadir post (array) a la Pila de entrada (E)
    for (int i = post.length - 1; i >= 0; i--) {
      E.push(post[i]);
    }

    //Algoritmo de Evaluación Postfija
    String operadores = "+-*/%";
    while (!E.isEmpty()) {
      if (operadores.contains("" + E.peek())) {
        P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
      }else {
        P.push(E.pop());
      }
    }

    //Mostrar resultados:
    //System.out.println("Expresion: " + Op);
    String Result = Rev(P.peek()).toString();
    //System.out.println("Resultado: " + Result);
    return Result;
  }

  private static float evaluar(String op, String n2, String n1) {
    float num1 = Float.parseFloat(n1);
    float num2 = Float.parseFloat(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("%")) return (num1 % num2);
    return 0;
  }
  
  private static Object Rev(String Result)
  {
      float N = Float.parseFloat(Result);
      
      if(N % 1 == 0)
      {
         return Math.round(Float.parseFloat(Result));
      }
      else
      {
          return Result;
      }
  }
  
  public String getResult()
  {
      return Operacion;
  }
    
}

