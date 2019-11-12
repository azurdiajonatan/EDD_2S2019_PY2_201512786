package proyectofinaledd2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HashTable {

    private int actual_size;
    private int count;
    private int actual_position;
    private final int [] positions;
    private double percentage;
    private final double limit;
    private static HashNode[] structure;
   
    private int Calculate(){
        return ((count*100)/actual_size);
    }
            
    public HashTable(){
        this.positions = new int[] {7,11,17,19,29,37,59,67,71,79,89,97,109,127,137,149,157,167,179,191,211,229,239,263,307,313,347,383,509};
        this.actual_position = 0;
        this.limit = 75.00;
        this.count = 0;
        this.actual_size = positions[actual_position];
        this.structure = new HashNode[actual_size];
        this.percentage = Calculate();
    }
    
    private int Code_Ascii(String name){
        int total = 0;
        for(int x = 0;x<name.length();x++){
            total += (int)name.charAt(x);
        }
        return total;
    }
    
    private String Generate_Timestamp(){
       String timestamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
       return timestamp;
    }
    
    private int Generate_Key(HashNode actualnode){
        String name = actualnode.getName();
        int get_number = Code_Ascii(name);
        int key = (get_number&0x7fffffff)%actual_size;
        return key;
    }
    
    private int Crash(HashNode actualnode, int position){
        int getkey = Generate_Key(actualnode);
        int getpow = (int) Math.pow(position+1,2);
        int newkey = getkey + getpow;
        return newkey;
    }
    
    public void Add_New(String name,String password){
        String datetime = Generate_Timestamp();
        HashNode newnode = new HashNode(name,password,datetime);
        if(percentage <= limit){
            for(int x = 0; x < actual_size;x++){
                int new_position = Crash(newnode,x);
                if(new_position >= actual_size){
                    new_position -= actual_size;
                }
                if(structure[new_position] == null){
                    structure[new_position] = newnode;
                    count += 1;
                }else{
                    //System.out.println("Crash");
                    if(structure[new_position].next == null){
                        structure[new_position].next = newnode;
                    }else{
                        HashNode temporal = structure[new_position];
                        while(temporal != null){
                            if(temporal.next == null){
                                temporal.next = newnode;
                                break;
                            }
                            temporal = temporal.next;
                        }
                    }
                }
                percentage = Calculate();
                break;
            }
            
            /*
            if(verify == true){
                System.out.println("Insert");
            }else{
                System.out.println("No insert");
            }
            */
        }else{
            //System.out.println("Array "+ percentage);
            Get_New_Array();
            Add_New(name, password);
        }
    }
    
    private void Get_New_Array(){
        HashNode[] save_all = structure;
        boolean check = true;
        int actual = actual_size;
        if(actual_position < positions.length){
            actual_position += 1;
            check = true;
            if(actual_position == positions.length-1){
                System.out.println("FULL");
                check = false;
            }
        }
        if(check == true){
           actual_size = positions[actual_position];
           structure = new HashNode[actual_size];
           count = 0;
           percentage = Calculate();
           for(int x = 0; x < actual;x++){
               if(save_all[x]!= null){
                   HashNode temp_node = save_all[x];
                   while(temp_node!=null){
                       Add_New(temp_node.getName(),temp_node.getPassword());
                       temp_node = temp_node.next;
                   }
               }
           }
            System.out.println("New vector Created");
        }  
    }
    
    public boolean Search_user(String username){
        boolean verify = false;
        for(int y = 0;y<actual_size;y++){
            if(structure[y] != null){
                HashNode node = structure[y];
                while(node!= null){
                    if(node.getName().equals(username)){
                        verify = true;
                    }
                    node = node.next;
                }
            }
        }
        return verify;
    }
    
    public boolean Verify_user(String name,String password){
        boolean verify = false;
        for(int y = 0;y<actual_size;y++){
            if(structure[y]!= null){
                HashNode node = structure[y];
                while(node!=null){
                    if(node.getName().equals(name) && node.getPassword().equals(password)){
                        verify = true;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        return verify;
    }
     
    public void Show_Table(){
        int position = 0;
        while(position != actual_size){
            if(structure[position]!=null){
                String pass = structure[position].getPassword().substring(0,10);
                System.out.print(structure[position].getName()+","+pass);
                HashNode assistand = structure[position].next;
                while(assistand != null){
                    System.out.print(assistand.getName()+","+assistand.getPassword().substring(0,10));
                    assistand = assistand.next;
                }
                System.out.println();
            }
            position++;
        }
    }
    
    public void Graph_Hash(){
        try{
            String principalvector = "";
            String nodes = "";
            String link = "";
            String filename = "Users.dot";
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                pw.write("digraph users{\n");
                pw.write("rankdir = LR;\n");
                pw.write("node[shape=record,fontsize=9];\n");
                principalvector += "node0 [ label = \"";
                for(int i = 0;i<actual_size;i++){
                    principalvector += "<f"+String.valueOf(i)+"> "+String.valueOf(i)+"|" ;
                }
                principalvector += "\"];\n";
                pw.write(principalvector);
                
                for(int x = 0;x<actual_size;x++){
                    if(structure[x] != null){
                        HashNode assistand = structure[x];
                        nodes += "node"+String.valueOf(x)+"_"+String.valueOf(x)+"[shape = record,label=\"{";
                        while(assistand != null){
                            nodes += "Name: "+assistand.getName()+"\\n Password: "+assistand.getPassword().substring(0,10)+"\\n Timestamp: "+assistand.getTimestamp()+"|";
                            assistand = assistand.next;
                        }
                        nodes+= "}\"];\n";
                    }
                }
                
                pw.write(nodes);
                for(int y = 0;y<actual_size;y++){
                    if(structure[y]!= null){
                        link += "node0:f"+String.valueOf(y)+" -> node"+String.valueOf(y)+"_"+String.valueOf(y)+";\n";
                    }
                }
                pw.write(link);
                
                pw.write("\n}");
            }
            
            try{
                String cmd = "dot -Tpng Users.dot -o Users.png";
                Runtime.getRuntime().exec(cmd);
            }catch(Exception pt){
                
            }
        
        }catch(IOException ios){
            
        }
    }
    
}
