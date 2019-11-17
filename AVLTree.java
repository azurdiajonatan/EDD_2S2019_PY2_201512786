package proyectofinaledd2019;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class AVLTree {

    NodeAvl root;
    String create = "";
   
    public AVLTree(){
        root = null; 
    } 
    
    public void Preorder(NodeAvl getnode){
        if(getnode != null){
            System.out.println(getnode.getFilename());
            Preorder(getnode.subleft);
            Preorder(getnode.subright);
        }
    }
    
    public void Inorder(NodeAvl getnode){
        if(getnode != null){
            Inorder(getnode.subleft);
            System.out.println(getnode.getFilename());
            Inorder(getnode.subright);
        }
    }
    
    /*
    private void Re_Factor(NodeAvl actualnode){
        if(actualnode != null){
            Re_Factor(actualnode.subleft);
            Re_Factor(actualnode.subright);
            update_factor(actualnode);
        }
    }
    */
    private int Get_Factor(NodeAvl actualnode){
        if(actualnode == null){
            return 0;
        }else{
            return actualnode.getFactor();
        }
    }
    
    private void update_factor(NodeAvl actualnode){
        if((actualnode.subleft == null) && (actualnode.subright != null)){
            actualnode.setFactor(actualnode.subright.getFactor()+1);
        }else if((actualnode.subright == null) && (actualnode.subleft != null)){
            actualnode.setFactor(actualnode.subleft.getFactor()+1);
        }else{
            actualnode.setFactor(Math.max(Get_Factor(actualnode.subleft), Get_Factor(actualnode.subright))+1);
        }
    }
    
    /*
    private void update_Height(NodeAvl actualnode){
        if(actualnode.subleft == null && actualnode.subright == null){
            actualnode.setFactor(0);
        }else if(actualnode.subright == null && actualnode.subleft != null ){
            actualnode.setFactor(-1);
        }else if(actualnode.subleft == null && actualnode.subright != null){
            actualnode.setFactor(1);
        }else{
            actualnode.setFactor(actualnode.subright.getFactor()-actualnode.subleft.getFactor());
        }
    }
    */
    private NodeAvl NormalLeft(NodeAvl actualnode){
        NodeAvl assistand = actualnode.getSubleft();
        actualnode.subleft = assistand.getSubright();
        assistand.subright = actualnode;
        actualnode.setFactor(Math.max(Get_Factor(actualnode.subleft),Get_Factor(actualnode.subright))+1);
        assistand.setFactor(Math.max(Get_Factor(actualnode.subleft),Get_Factor(actualnode.subright))+1);
        return assistand;
    }
    
    private NodeAvl NormalRight(NodeAvl actualnode){
        NodeAvl assistand = actualnode.getSubright();
        actualnode.subright = assistand.getSubleft();
        assistand.subleft = actualnode;
        actualnode.setFactor(Math.max(Get_Factor(actualnode.subleft),Get_Factor(actualnode.subright))+1);
        assistand.setFactor(Math.max(Get_Factor(actualnode.subleft),Get_Factor(actualnode.subright))+1);
        return assistand;
    }
    
    private NodeAvl DoubleLeft(NodeAvl actualnode){
        actualnode.subleft = NormalRight(actualnode.subleft);
        NodeAvl assistand = NormalLeft(actualnode);
        return assistand;
    }
    
    private NodeAvl DoubleRight(NodeAvl actualnode){
        actualnode.subright = NormalLeft(actualnode.subright);
        NodeAvl assistand = NormalRight(actualnode);
        return assistand;
    }
    
    private NodeAvl Insert_Place(NodeAvl newnode,NodeAvl actualnode){
        NodeAvl assistand = actualnode;
        if(newnode.getFilename().compareTo(actualnode.getFilename()) < 0){
            if(actualnode.subleft == null){
                actualnode.subleft = newnode;
            }else{
                actualnode.subleft = Insert_Place(newnode, actualnode.subleft);
                if((Get_Factor(actualnode.subleft) - Get_Factor(actualnode.subright))==2){
                    if(newnode.getFilename().compareTo(actualnode.subleft.getFilename())<0){
                        assistand = NormalLeft(actualnode);
                    }else{
                        assistand = DoubleLeft(actualnode);
                    }
                }
            }
        }else if(newnode.getFilename().compareTo(actualnode.getFilename())>0){
            if(actualnode.subright == null){
                actualnode.subright = newnode;
            }else{
                actualnode.subright = Insert_Place(newnode, actualnode.subright);
                if((Get_Factor(actualnode.subright) - Get_Factor(actualnode.subleft))==2){
                    if(newnode.getFilename().compareTo(actualnode.subright.getFilename())>0){
                        assistand = NormalRight(actualnode);
                    }else{
                        assistand = DoubleRight(actualnode);
                    }
                }
            }
        }else{
            
        }
        update_factor(actualnode);
        return assistand;
    }
    
    public void Insert_New_Node(String filename,String content){
        NodeAvl newnode = new NodeAvl(filename,content,"","");
        if(root == null){
            root = newnode;
        }else{
            root = Insert_Place(newnode,root);
        }
    }
    
    private void InsertModify(NodeAvl newnode){
        if(root == null){
            root = newnode;
        }else{
            root = Insert_Place(newnode, root);
        }
    }
    
    private int GetFactorBalance(NodeAvl actualnode){
        if(actualnode == null){
            return 0;
        }else{
            return Get_Factor(actualnode.subleft) - Get_Factor(actualnode.subright);
        }
    }
    
    public NodeAvl Delete_Node(NodeAvl actualnode,String filename){
        if(actualnode == null){
            return null;
        }
        if(filename.compareTo(actualnode.getFilename())<0){
            actualnode.setSubleft(Delete_Node(actualnode.getSubleft(), filename));
        }else if(filename.compareTo(actualnode.getFilename())>0){
            actualnode.setSubright(Delete_Node(actualnode.getSubright(), filename));
        }else{
            if(actualnode.getSubleft() == null || actualnode.getSubright() == null){
                NodeAvl assistand = null;
                if(assistand == actualnode.subleft){
                    assistand = actualnode.getSubright();
                }else{
                    assistand = actualnode.getSubleft();
                }
                
                if(assistand == null){
                    assistand = actualnode;
                    actualnode = null;
                }else{
                    actualnode = assistand;
                }
                
            }else{
                NodeAvl temporal = actualnode.getSubright();
                while(temporal.getSubleft() != null){
                    temporal = temporal.getSubleft();
                }
                actualnode.setFilename(temporal.getFilename());
                actualnode.setSubright(Delete_Node(actualnode.getSubright(),temporal.getFilename()));
            }        
        }
        
         if(actualnode == null){
            return actualnode;
        }
        
        actualnode.setFactor(Math.max(Get_Factor(actualnode.getSubleft()), Get_Factor(actualnode.getSubright()))+1);
        int newbalance = GetFactorBalance(actualnode);
        
        if(newbalance > 1 && GetFactorBalance(actualnode.subleft) >=0){
             NormalRight(actualnode);
        }
        
        if(newbalance > 1 && GetFactorBalance(actualnode.subleft) <0 ){
             DoubleLeft(actualnode);
        }
        
        if(newbalance < -1 && GetFactorBalance(actualnode.subright) <=0 ){
             NormalLeft(actualnode);
        }
        
        if(newbalance < -1 && GetFactorBalance(actualnode.subright) > 0){
             DoubleLeft(actualnode);
        }
        return actualnode;
    }
    
    private NodeAvl Search_File(NodeAvl actualnode, String namefile){
        if(root == null){
            return null;
        }else if(actualnode.getFilename().equals(namefile)){
            return actualnode;
        }else if(actualnode.getFilename().compareTo(namefile)<0){
            return Search_File(actualnode.subright, namefile);
        }else{
            return Search_File(actualnode.subleft, namefile);
        } 
    }
    
    
    public void Modify(NodeAvl actualnode,String filename,String newnamefile){
        NodeAvl temporal = Search_File(actualnode, filename);
        if(temporal != null){
            Delete_Node(temporal, filename);
            NodeAvl newnode = new NodeAvl(newnamefile,temporal.getContent(),temporal.getTimestamp(),temporal.getUsername());
            InsertModify(newnode);
        }else{
            
        }
    }
    
    public void Graph_Avl(String image_name,AVLTree actualtree){
        try{
            create = "";
            String path = image_name+".dot";
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter outprint = new PrintWriter(bw)) {
                outprint.print("digraph avltree{ \n");
                outprint.write("rankdir = TB; \n");
                outprint.write("node[shape=record,style=filled,fillcolor=tomato]; \n");
                Create_Nodes(actualtree.root);
                Link_Nodes(actualtree.root);
                outprint.write(create);
                outprint.write("\n}");
                String command = "dot -Tjpg "+image_name+".dot -o "+image_name+".jpg";
                Runtime.getRuntime().exec(command);
                //Desktop.getDesktop().open(new File(image_name+".jpg"));
            }
        }catch(IOException ios){
            JOptionPane.showMessageDialog(null, ios);
        }
    }
    
    private void Create_Nodes(NodeAvl actualnode){
        try{
            if(actualnode != null){
                String subcontent = actualnode.getContent();
                String factor = String.valueOf(actualnode.getFactor());
                String height = String.valueOf(actualnode.getHeigth());
                create += "node"+actualnode.getFilename()+" [label = \" <C0>|" + "File name: "+actualnode.getFilename()
                          +"\\n Content: "+subcontent+"\\n FE: "+factor+"\\n Height: "+height
                          +"\\n Timestamp: "+actualnode.getTimestamp()+"\\n User: "+actualnode.getUsername()+"|<C1>\"]; \n";
            }
            if(actualnode.subleft != null){
                Create_Nodes(actualnode.subleft);
            }
            if(actualnode.subright != null){
                Create_Nodes(actualnode.subright);
            }
        }catch(Exception ios){
           JOptionPane.showMessageDialog(null, ios); 
        }
    }
    
    private void Link_Nodes(NodeAvl actualnode){
        if(actualnode != null){
            create += "node"+actualnode.getFilename();
            create += ";\n";
        }
        if(actualnode.subleft != null){
            create += "node"+actualnode.getFilename()+":C0";
            create += "->";
            Link_Nodes(actualnode.subleft);
        }
        if(actualnode.subright != null){
            create += "node"+actualnode.getFilename()+":C1";
            create += "->";
            Link_Nodes(actualnode.subright);
        }
    }
    
}
