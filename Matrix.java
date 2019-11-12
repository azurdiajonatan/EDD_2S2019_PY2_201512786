package proyectofinaledd2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Matrix {
    
    MatrixNode head;
    
    public Matrix(){
        MatrixNode first = new MatrixNode("Head");
        MatrixNode filesson = new MatrixNode("/");
        MatrixNode filesfather = new MatrixNode("/");
        head = first;
        head.right = filesson;
        head.down = filesfather;
        filesson.left = head;
        filesfather.up = head;
        String actual_path = "/";
    }
    
    public void Add(String fpath,String spath){
        Add_Headers(fpath);
        Add_Headers(spath);
        String path = fpath+"/"+spath;
        MatrixNode bodynode = new MatrixNode(spath,fpath,path);
    }
    
    private MatrixNode Search_Father(String fathername){
        MatrixNode toreturn = null;
        MatrixNode actualnode = head;
        while(actualnode != null){
            if(actualnode.getLocation().equals(fathername)){
                toreturn = actualnode;
                break;
            }
            actualnode = actualnode.down;
        }
        if(toreturn == null){
            return null;
        }else{
            return toreturn;
        }
    }
    
    private MatrixNode Search_Son(String sonname){
        MatrixNode toreturn = null;
        MatrixNode actualnode = head;
        while(actualnode != null){
            if(actualnode.getLocation().equals(sonname)){
                toreturn = actualnode;
                break;
            }
            actualnode = actualnode.right;
        }
        if(toreturn == null){
            return null;
        }else{
            return toreturn;
        }
    }
    
    private void Add_Headers(String name){
        MatrixNode newnodey = new MatrixNode(name);
        if(Search_Father(name) == null){
            MatrixNode temp = head;
            while(temp != null){
                if(temp.down == null){
                    temp.down = newnodey;
                    newnodey.up = temp;
                    break;
                }
                temp = temp.down;
            }
        }else{
            System.out.println("Exist");
        }
        
        MatrixNode newnodex = new MatrixNode(name);
        if(Search_Son(name) == null){
            MatrixNode temp = head;
            while(temp != null){
                if(temp.right == null){
                    temp.right = newnodex;
                    newnodex.left = temp;
                    break;
                }
                temp = temp.right;
            }
        }else{
            System.out.println("Exist");
        }
        
        
    }
    
    public void PrintX(){
        MatrixNode actualnode = head;
        while(actualnode != null){
            System.out.println(actualnode.getLocation());
            actualnode = actualnode.right;
        }
    }
    
    public void PrintY(){
        MatrixNode actualnode = head;
        while(actualnode != null){
            System.out.println(actualnode.getLocation());
            actualnode = actualnode.down;
        }
    }
    
    private void AddBodyX(MatrixNode newnode){
        
    }
    
    private void AddBodyY(MatrixNode newnode){
        
    }
    
    
}
