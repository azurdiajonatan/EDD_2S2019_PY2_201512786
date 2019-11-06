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
    
    private int Get_Height(NodeAvl actualnode){
        if(actualnode == null){
            return -1;
        }else{
            return actualnode.getHeigth();
        }
    }
    
    private void update_height(NodeAvl actualnode){
        if(actualnode.subleft == null && actualnode.subright != null){
            actualnode.setHeigth(actualnode.subright.getHeigth()+1);
        }else if(actualnode.subright == null && actualnode.subleft != null){
            actualnode.setHeigth(actualnode.subleft.getHeigth()+1);
        }else{
            actualnode.setHeigth(Math.max(Get_Height(actualnode.subleft), Get_Height(actualnode.subright)+1));
        }
    }
    
    private void update_factor(NodeAvl actualnode){
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
    
    private NodeAvl NormalLeft(NodeAvl actualnode){
        NodeAvl assistand = actualnode.getSubleft();
        actualnode.subleft = assistand.getSubright();
        assistand.subright = actualnode;
        actualnode.setHeigth(Math.max(Get_Height(actualnode.subleft),Get_Height(actualnode.subright))+1);
        assistand.setHeigth(Math.max(Get_Height(actualnode.subleft),Get_Height(actualnode.subright))+1);
        return assistand;
    }
    
    private NodeAvl NormalRight(NodeAvl actualnode){
        NodeAvl assistand = actualnode.getSubright();
        actualnode.subright = assistand.getSubleft();
        assistand.subleft = actualnode;
        actualnode.setHeigth(Math.max(Get_Height(actualnode.subleft),Get_Height(actualnode.subright))+1);
        assistand.setHeigth(Math.max(Get_Height(actualnode.subleft),Get_Height(actualnode.subright))+1);
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
                if((Get_Height(actualnode.subleft) - Get_Height(actualnode.subright))==2){
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
                if((Get_Height(actualnode.subright) - Get_Height(actualnode.subleft))==2){
                    if(newnode.getFilename().compareTo(actualnode.subright.getFilename())>0){
                        assistand = NormalRight(actualnode);
                    }else{
                        assistand = DoubleRight(actualnode);
                    }
                }
            }
        }else{
            
        }
        update_height(actualnode);
        update_factor(actualnode);
        return assistand;
    }
    
    public void Insert_New_Node(String hola){
        NodeAvl newnode = new NodeAvl(hola,"","","");
        if(root == null){
            root = newnode;
        }else{
            root = Insert_Place(newnode,root);
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
