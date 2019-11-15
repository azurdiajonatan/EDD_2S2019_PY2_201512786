package proyectofinaledd2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Stack {
  
    private int count;
    NodeStack head;
    
    public Stack(){
        head = null;
        count = 1;
    }
    
    public void Insert_Node(String description,String user){
        Date date = new Date();
        DateFormat actualtime = new SimpleDateFormat("HH:mm:ss");
        String gettime = actualtime.format(date);
        DateFormat actualdate = new SimpleDateFormat("dd/MM/yyyy");
        String getdate = actualdate.format(date);
        NodeStack newnode = new NodeStack(getdate,gettime,description,user);
        if(head == null){
            head = newnode;
        }else{
            newnode.next = head;
            head = newnode;
        }
        count++;
    }
    
    public void Delete_Node(){
        if(head != null){
            NodeStack assistand = head;
            head = assistand.next;
            assistand = null;
        }else{
            System.out.println("Empty List");
        }
    }
    
    public void Show_Stack(){
        NodeStack actualnode = head;
        while (actualnode != null){
            System.out.println(actualnode.getUser());
            actualnode = actualnode.next;
        }
    }
    
    public void Graph_Stack(){
        try{
           String namefile = "Actions.dot";
            FileWriter fw = new FileWriter(namefile);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                pw.write("digraph action{\n");
                pw.write("rankdir = LR;\n");
                pw.write("node[shape=record,style=filled,fillcolor = mediumaquamarine];\n");
                String pt = "struct [ label = \" | ";
                NodeStack actualnode = head;
                while(actualnode != null){
                    if(actualnode.next == null){
                        pt += "Date: "+actualnode.getDate()+"\\n Time: "+actualnode.getTime()+"\\n Description: "
                                +actualnode.getDescription()+"\\n User: "+actualnode.getUser()+"\"];";
                        break;
                    }
                    pt += "Date: "+actualnode.getDate()+"\\n Time: "+actualnode.getTime()+"\\n Description: "
                            +actualnode.getDescription()+"\\n User: "+actualnode.getUser()+"|\n";
                    actualnode = actualnode.next;
                }
                pw.write(pt);
                pw.write("\n}");
            }
            String cmd = "dot -Tpng Actions.dot -o Actions.png";
            Runtime.getRuntime().exec(cmd);
        }catch(IOException ios){
            JOptionPane.showMessageDialog(null, ios);
        }
        
    }
    
    
}
