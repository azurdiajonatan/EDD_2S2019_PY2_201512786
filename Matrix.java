package proyectofinaledd2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class Matrix {
    
    private int position;
    MatrixNode head;
    ArrayList folder_names;
    
    public Matrix(){
        MatrixNode first = new MatrixNode("Head",0);
        MatrixNode filesson = new MatrixNode("/",1);
        MatrixNode filesfather = new MatrixNode("/",1);
        head = first;
        head.right = filesson;
        head.down = filesfather;
        filesson.left = head;
        filesfather.up = head;
        String actual_path = "/";
        position = 2;
        
        
    }
    
    public void Add(String path){
        folder_names = new ArrayList(Arrays.asList(path.split("/")));
        folder_names.set(0,"/");
        if(folder_names!=null){
            
            /*
            for(Object element : folder_names){
                System.out.println(element);
            }
            */
            
            for(int x = 1;x<folder_names.size();x++){
                    Add_HeadersX((String) folder_names.get(x)); 
                    Add_HeadersY((String) folder_names.get(x)); 
                    position++;
            }
            String getfather = "";
            String getson = "";
            for(int y = 1; y<folder_names.size();y++){
                getfather = (String) folder_names.get(y-1);
                getson = (String) folder_names.get(y);
            }
            MatrixNode newnode = new MatrixNode(getson,getfather,path);
            AddBodyX(newnode);
        }
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
    
    private MatrixNode Search_Folder(MatrixNode newnode){
        
        return null;
    }
    
    private void Add_HeadersY(String name){
        MatrixNode newnodey = new MatrixNode(name,position);
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
        }
    }
    
    private void Add_HeadersX(String name){
        MatrixNode newnodex = new MatrixNode(name,position);
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
        }
    }
    
    public void PrintX(){
        MatrixNode actualnode = head;
        while(actualnode != null){
            System.out.print(actualnode.getLocation());
            MatrixNode pt = actualnode.down;
            while(pt!=null){
                System.out.print(","+pt.getFolder());
                pt = pt.down;
            }
            System.out.println();
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
        MatrixNode getcolumn = Search_Son(newnode.getSon());
        if(getcolumn.down == null){
            getcolumn.down = newnode;
            newnode.up = getcolumn;
            AddBodyY(newnode);
        }
    }
    
    private void AddBodyY(MatrixNode newnode){
        MatrixNode getline = Search_Father(newnode.getFather());
        if(getline.right == null){
            getline.right = newnode;
            newnode.left = getline;
        }else{
            MatrixNode assistand = getline.right;
            while(assistand != null){
                if(assistand.right == null){
                    assistand.right = newnode;
                    break;
                }
                assistand = assistand.right;
            }
        }
    }
    
    
    

    public void GraphMatrix(String fileimage, Matrix mtx){
        try{
            String headers = "";
            String bodynodes = "";
            String body = "";
            String rank = "";
            String link = "";
            int i = 1;
            String namefile = fileimage+".txt";
            FileWriter fw = new FileWriter(namefile);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                pw.write("digraph mtx{ \n");
                pw.write("rankdir = TB; \n");
                pw.write("node[shape=rectangle]; \n");
                pw.write("graph [nodesep = 0.5]; \n");
                
                //######################HEADERS
                MatrixNode hxnode = mtx.head;
                while(hxnode != null){
                    headers += "nodeX_"+hxnode.getLocation()+" [ label = \""+hxnode.getLocation()+"\",style=filled];\n";
                    hxnode = hxnode.right;
                }
                
                hxnode = mtx.head.down;
                while(hxnode != null){
                    headers += "nodeY_"+hxnode.getLocation()+" [ label = \""+hxnode.getLocation()+"\",style=filled];\n";
                    hxnode = hxnode.down;
                }
                //#####################NODES
                MatrixNode temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    while(pointer != null){
                        bodynodes += "node"+pointer.getFather()+"_"+pointer.getSon()+" [ label = \""+pointer.getFolder()+"\"];\n";
                        pointer = pointer.down;
                    }
                    temporal = temporal.right;
                }
                
                temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    if(pointer != null){
                        body += "nodeX_"+temporal.getLocation()+"-> node"+pointer.getFather()+"_"+pointer.getSon()+"[dir=both,group="+String.valueOf(i)+"];\n";
                    }
                    i++;
                    temporal = temporal.right;
                }
                
                i = 1;
                /*
                temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    while(pointer.down != null){
                        body += "node"+pointer.getFather()+"_"+pointer.getSon()+"-> node"+pointer.down.getFather()+"_"+pointer.down.getSon()+"[dir=both,group="+String.valueOf(i)+"];\n";
                        pointer = pointer.down;
                    }
                    i++;
                    temporal = temporal.right;
                }
                */
                
                temporal = mtx.head.down;
                while(temporal != null){
                    MatrixNode pointer = temporal.right;
                    if(pointer != null){
                        body += "nodeY_"+temporal.getLocation()+"-> node"+pointer.getFather()+"_"+pointer.getSon()+"[constraint=false,dir=both];\n";
                    }
                    i++;
                    temporal = temporal.down;
                }
                /*
                temporal = mtx.head.down;
                while(temporal != null){
                    MatrixNode pointer = temporal.right;
                    while(pointer != null){
                        body += "node"+pointer.getFather()+"_"+pointer.getSon()+"-> node"+pointer.right.getFather()+"_"+pointer.right.getSon()+"[constraint=false,dir=both];\n";
                        pointer = pointer.right;
                    }
                    i++;
                    temporal = temporal.down;
                }
                */
                //#################RANK SAME
                hxnode = mtx.head;
                rank += "{ rank=same; ";
                while(hxnode != null){
                    rank += "nodeX_"+hxnode.getLocation()+" ";
                    hxnode = hxnode.right;
                }
                rank += "}\n";
                
                hxnode = mtx.head.down;
                while(hxnode != null){
                    MatrixNode assistand = hxnode.right;
                    rank += "{ rank=same; ";
                    rank += "nodeY_"+hxnode.getLocation()+" ";
                    while(assistand != null){
                        rank += "node"+assistand.getFather()+"_"+assistand.getSon()+" ";
                        assistand = assistand.right;
                    }
                    rank += "}\n";
                    hxnode = hxnode.down;
                }
                
                //##################LINK NODES
                hxnode = mtx.head.right;
                link += "nodeX_"+mtx.head.getLocation()+"-> "+"nodeX_"+hxnode.getLocation()+"[dir=both];\n";
                while(hxnode.right != null){
                    link += "nodeX_"+hxnode.getLocation()+"-> "+"nodeX_"+hxnode.right.getLocation()+"[dir=both];\n";
                    hxnode = hxnode.right;
                }
                
                hxnode = mtx.head.down;
                link += "nodeX_"+mtx.head.getLocation()+"-> "+"nodeY_"+hxnode.getLocation()+"[dir=both,group=0];\n";
                while(hxnode.down != null){
                    link += "nodeY_"+hxnode.getLocation()+"-> "+"nodeY_"+hxnode.down.getLocation()+"[dir=both,group=0];\n";
                    hxnode = hxnode.down;
                }
                
                pw.write(headers);
                pw.write(bodynodes);
                pw.write(rank);
                pw.write(link);
                pw.write(body);
                pw.write("\n}");
                pw.close();
            }
        }catch(IOException ios){
            JOptionPane.showMessageDialog(null,ios);
        }
    }
    
    
}
