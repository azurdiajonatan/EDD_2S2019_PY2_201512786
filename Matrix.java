package proyectofinaledd2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Matrix {
    
    MatrixNode head;
    
    public Matrix(){
        MatrixNode first = new MatrixNode(0);
        head = first;
    }
    
    public void Add(int spath,int fpath, int path){
        addXHeader(spath); //sons
        addYHeader(fpath); //fathers
        MatrixNode newnode = new MatrixNode(spath,fpath,path);
        AddSon(newnode);
    }
    
    private MatrixNode getFather(int name){
        MatrixNode returnode = null;
        MatrixNode pointer = head;
        while(pointer != null){
            if(pointer.getLocation() == name){
                returnode = pointer;
                break;
            }
            pointer = pointer.down;
        }
        if(returnode == null){
            return null;
        }else{
            return returnode;
        }
    }
    
    private MatrixNode getSon(int name){
        MatrixNode returnode = null;
        MatrixNode pointer = head;
        while(pointer != null){
            if(pointer.getLocation() == name){
                returnode = pointer;
                break;
            }
            pointer = pointer.right;
        }
        if(returnode == null){
            return null;
        }else{
            return returnode;
        }
    }
    
    private void addXHeader(int namex){
        if(getSon(namex) == null){
            MatrixNode newnode = new MatrixNode(namex);
            if(head.right == null){
                head.right = newnode;
                newnode.left = head;
            }else{
                MatrixNode pointernode = head;
                while(pointernode != null){
                    if(pointernode.right == null){
                        pointernode.right = newnode;
                        newnode.left = pointernode;
                        break;
                    }
                    pointernode = pointernode.right;
                }
            } 
        }
    }
    
    private void addYHeader(int namey){
        if(getFather(namey) == null){
            MatrixNode newnode = new MatrixNode(namey);
            if(head.down == null){
                head.down = newnode;
                newnode.up = head;
            }else{
                MatrixNode pointernode = head;
                while(pointernode != null){
                    if(pointernode.down == null){
                        pointernode.down = newnode;
                        newnode.up = pointernode;
                        break;
                    }
                    pointernode = pointernode.down;
                }
            } 
        }   
    }
    
    public void PrintX(){
        MatrixNode nodex = head.right;
        while(nodex != null){
            System.out.print(nodex.getLocation()+"->");
            MatrixNode temp = nodex.down;
            while(temp != null){
                System.out.print(temp.getFolder());
                temp = temp.down;
            }
            System.out.println();
            nodex = nodex.right;
        }
    }
    
    public void PrintY(){
        MatrixNode nodex = head.down;
        while(nodex != null){
            System.out.print(nodex.getLocation()+"->");
            MatrixNode temp = nodex.right;
            while(temp != null){
                System.out.print(temp.getFolder());
                temp = temp.right;
            }
            System.out.println();
            nodex = nodex.down;
        }
    }
    
    private void AddSon(MatrixNode actualnode){
        MatrixNode getcolumn = getSon(actualnode.getSon());
        if(getcolumn.down == null){
            getcolumn.down = actualnode;
            actualnode.up = getcolumn;
            AddFather(actualnode);
        }else{
            MatrixNode temporal = getcolumn.down;
            if(actualnode.getFather()<temporal.getFather()){
                actualnode.down = temporal;
                temporal.up = actualnode;
                getcolumn.down = actualnode;
                actualnode.up = getcolumn;
                AddFather(actualnode);
            }else{
                MatrixNode temporaltwo = temporal.down;
                while(actualnode.getFather() > temporal.getFather() && temporaltwo != null){
                    if(temporaltwo == null){
                        break;
                    }
                    if(actualnode.getFather() > temporal.getFather() && actualnode.getFather() < temporaltwo.getFather()){
                        break;
                    }
                    temporal = temporal.down;
                    temporaltwo = temporaltwo.down;
                }
                if(temporaltwo == null){
                    temporal.down = actualnode;
                    actualnode.up = temporal;
                }else{
                    temporal.down = actualnode;
                    actualnode.up = temporal;
                    actualnode.down = temporaltwo;
                    temporaltwo.up = actualnode;
                }
                AddFather(actualnode);
            }
        }
    }
    
    private void AddFather(MatrixNode actualnode){
        MatrixNode getline = getFather(actualnode.getFather());
        if(getline.right == null){
            getline.right = actualnode;
            actualnode.left = getline;
        }else{
            MatrixNode assistand = getline.right;
            if(actualnode.getSon() < assistand.getSon()){
                actualnode.right = assistand;
                assistand.left = actualnode;
                getline.right = actualnode;
                actualnode.left = getline;
            }else{
                MatrixNode assistandtwo = assistand.right;
                while(actualnode.getSon() > assistand.getSon() && assistandtwo !=  null){
                    if(assistandtwo == null){
                        break;
                    }
                    if(actualnode.getSon() > assistand.getSon() && actualnode.getSon() < assistandtwo.getSon()){
                        break;
                    }
                    assistand = assistand.right;
                    assistandtwo = assistandtwo.right;
                }
                if(assistandtwo == null){
                    assistand.right = actualnode;
                    actualnode.left = assistand;
                }else{
                    assistand.right = actualnode;
                    actualnode.left = assistand;
                    actualnode.right = assistandtwo;
                    assistandtwo.left = actualnode;
                }
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
                    headers += "nodeX_"+String.valueOf(hxnode.getLocation())+" [ label = \""+String.valueOf(hxnode.getLocation())+"\",style=filled];\n";
                    hxnode = hxnode.right;
                }
                
                hxnode = mtx.head.down;
                while(hxnode != null){
                    headers += "nodeY_"+String.valueOf(hxnode.getLocation())+" [ label = \""+String.valueOf(hxnode.getLocation())+"\",style=filled];\n";
                    hxnode = hxnode.down;
                }
                //#####################NODES
                MatrixNode temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    while(pointer != null){
                        bodynodes += "node"+String.valueOf(pointer.getFather())+"_"+String.valueOf(pointer.getSon())+" [ label = \""+ String.valueOf(pointer.getFolder())+"\"];\n";
                        pointer = pointer.down;
                    }
                    temporal = temporal.right;
                }
                
                temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    if(pointer != null){
                        body += "nodeX_"+String.valueOf(temporal.getLocation())+"-> node"+String.valueOf(pointer.getFather())+"_"+String.valueOf(pointer.getSon())+"[dir=both,group="+String.valueOf(i)+"];\n";
                    }
                    i++;
                    temporal = temporal.right;
                }
                
                i = 1;
                temporal = mtx.head.right;
                while(temporal != null){
                    MatrixNode pointer = temporal.down;
                    while(pointer.down != null){
                        body += "node"+String.valueOf(pointer.getFather())+"_"+String.valueOf(pointer.getSon())+"-> node"+String.valueOf(pointer.down.getFather())+"_"+String.valueOf(pointer.down.getSon())+"[dir=both,group="+String.valueOf(i)+"];\n";
                        pointer = pointer.down;
                    }
                    i++;
                    temporal = temporal.right;
                }
                
                temporal = mtx.head.down;
                while(temporal != null){
                    MatrixNode pointer = temporal.right;
                    if(pointer != null){
                        body += "nodeY_"+String.valueOf(temporal.getLocation())+"-> node"+String.valueOf(pointer.getFather())+"_"+String.valueOf(pointer.getSon())+"[constraint=false,dir=both];\n";
                    }
                    i++;
                    temporal = temporal.down;
                }
                
                temporal = mtx.head.down;
                while(temporal != null){
                    MatrixNode pointer = temporal.right;
                    while(pointer.right != null){
                        body += "node"+String.valueOf(pointer.getFather())+"_"+String.valueOf(pointer.getSon())+"-> node"+String.valueOf(pointer.right.getFather())+"_"+String.valueOf(pointer.right.getSon())+"[constraint=false,dir=both];\n";
                        pointer = pointer.right;
                    }
                    i++;
                    temporal = temporal.down;
                }
                
                //#################RANK SAME
                hxnode = mtx.head;
                rank += "{ rank=same; ";
                while(hxnode != null){
                    rank += "nodeX_"+String.valueOf(hxnode.getLocation())+" ";
                    hxnode = hxnode.right;
                }
                rank += "}\n";
                
                hxnode = mtx.head.down;
                while(hxnode != null){
                    MatrixNode assistand = hxnode.right;
                    rank += "{ rank=same; ";
                    rank += "nodeY_"+String.valueOf(hxnode.getLocation())+" ";
                    while(assistand != null){
                        rank += "node"+String.valueOf(assistand.getFather())+"_"+String.valueOf(assistand.getSon())+" ";
                        assistand = assistand.right;
                    }
                    rank += "}\n";
                    hxnode = hxnode.down;
                }
                
                //##################LINK NODES
                hxnode = mtx.head.right;
                link += "nodeX_"+String.valueOf(mtx.head.getLocation())+"-> "+"nodeX_"+String.valueOf(hxnode.getLocation())+"[dir=both];\n";
                while(hxnode.right != null){
                    link += "nodeX_"+String.valueOf(hxnode.getLocation())+"-> "+"nodeX_"+String.valueOf(hxnode.right.getLocation())+"[dir=both];\n";
                    hxnode = hxnode.right;
                }
                
                hxnode = mtx.head.down;
                link += "nodeX_"+String.valueOf(mtx.head.getLocation())+"-> "+"nodeY_"+String.valueOf(hxnode.getLocation())+"[dir=both,group=0];\n";
                while(hxnode.down != null){
                    link += "nodeY_"+String.valueOf(hxnode.getLocation())+"-> "+"nodeY_"+String.valueOf(hxnode.down.getLocation())+"[dir=both,group=0];\n";
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
