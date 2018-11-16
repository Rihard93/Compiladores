/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minic;

import java.util.*;
import minic.Info;

public class Env
{
    static Env root = new Env(null);
    static Env top = root;
    HashMap table;
    Env prev;
    
    public Env (Env p)
    {
        table = new HashMap();
        prev = p;
    }
    
    public static int putClass(String c, String sc, sym s)
    {
        if(root.table.containsKey(c))
        {
            System.out.println("Entrando a la Clase: " + c);
            push();
            return 1;
        }
        if(sc == null)
        {
            root.table.put(c, s);
            System.out.println("Entrando a la Clase: " + c);
            top.table.put(c, s);
            push();
            return 0;
        }
        if (!root.table.containsKey(sc))
        {
            System.out.println("Entrando a la Clase: " + c);
            push();
            return 2;
        }
        else
        {
            root.table.put(c, s);
            System.out.println("Entrando a la Clase: " + c);
            top.table.put(c, s);
            push();
            return 0;
        }
    }
    
    public static boolean put(Object name, Object tipo)
    {
        if(!top.table.containsKey(name))
        {
            Info Data = new Info(tipo.toString(),null);            
            top.table.put(name, Data);
            System.out.println("  Nuevo Identificador: "+name+" -> Ambito Actual: "+top);
            return true;
        }
        return false;
    }
    
    public static sym get(String name)
    {
        for(Env e = top; e != null; e = e.prev)
        {
            sym found = (sym) (e.table.get(name));
            if (found != null)
            {
                return found;
            }            
        }
        return null;
    }
    
    public static void push()
    {
        top = new Env(top);
        System.out.println(" -> Current Enviroment: "+top);
    }
    
    public static void pop()
    {
        top = top.prev;
        System.out.println(" -> Current Enviroment: "+top);
    }
    

    public String toString()
    {
        if(prev != null)
        {
            return prev.toString() + table;            
        }
        else
        {
            return ""+table;
        }
    }

}