package proyectofinaledd2019;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    ///////////////////////////////////////////////////////////////
    private int ActualHeight(NodeAvl actualnode){
        if(actualnode == null){
            return 0;
        }else{
            return actualnode.getHeigth();
        }
    }

    private int MaxHeight(int node1,int node2){
        if(node1 > node2){
            return node1;
        }else{
            return node2;
        }
    }

    private NodeAvl NormalLeft(NodeAvl actualnode){
        NodeAvl temporal = actualnode.getSubright();
        NodeAvl temporal2 = temporal.getSubleft();
        temporal.subleft = actualnode;
        actualnode.subright = temporal2;
        actualnode.setHeigth(Math.max(ActualHeight(actualnode.getSubleft()),ActualHeight(actualnode.getSubright()))+1);
        temporal.setHeigth(Math.max(ActualHeight(temporal.getSubleft()),ActualHeight(temporal.getSubright()))+1);
        return temporal;
    }

    private NodeAvl NormalRight(NodeAvl actualnode){
        NodeAvl temporal = actualnode.getSubleft();
        NodeAvl temporal2 = temporal.getSubright();
        temporal.subright = actualnode;
        actualnode.subleft = temporal2;
        actualnode.setHeigth(Math.max(ActualHeight(actualnode.getSubleft()),ActualHeight(actualnode.getSubright()))+1);
        temporal.setHeigth(Math.max(ActualHeight(temporal.getSubleft()),ActualHeight(temporal.getSubright()))+1);
        return temporal;
    }
    
    private NodeAvl DoubleLeft(NodeAvl actualnode){
        actualnode.subright = NormalRight(actualnode.getSubright());
        return NormalLeft(actualnode);
    }
    
    private NodeAvl DoubleRight(NodeAvl actualnode){
        actualnode.subleft = NormalLeft(actualnode.getSubleft());
        return NormalRight(actualnode);
    }

    private int Height_Balance(NodeAvl actualnode){
        if(actualnode == null){
            return 0;
        }else{
            return (ActualHeight(actualnode.getSubleft()) - ActualHeight(actualnode.getSubright()));
        }
    }
    
    private NodeAvl MinLevel(NodeAvl actualnode){
        NodeAvl temporal = actualnode;
        while(temporal.getSubleft() != null){
            temporal = temporal.subleft;
        }
        return temporal;
    }
            

    private NodeAvl Insert_Node(NodeAvl ptroot,NodeAvl newnode){       
        if(ptroot == null){
            return newnode;
        }
        
        if(newnode.getFilename().compareTo(ptroot.getFilename())<0){
            ptroot.subleft = Insert_Node(ptroot.subleft, newnode);
        }else if(newnode.getFilename().compareTo(ptroot.getFilename())>0){
            ptroot.subright = Insert_Node(ptroot.subright,newnode);
        }else{
            return ptroot;
        }
        
        ptroot.setHeigth(1+MaxHeight(ActualHeight(ptroot.getSubleft()),ActualHeight(ptroot.getSubright())));
        int newheigth = Height_Balance(ptroot);
        
        if((newheigth > 1) && (newnode.getFilename().compareTo(ptroot.getSubleft().getFilename())<0)){
            return NormalRight(ptroot);
        }
        if((newheigth < -1) && (newnode.getFilename().compareTo(ptroot.getSubright().getFilename())>0)){
            return NormalLeft(ptroot);
        }
        
        if((newheigth > 1) && (newnode.getFilename().compareTo(ptroot.getSubleft().getFilename())>0)){
            return DoubleRight(ptroot);
        }
        if((newheigth < -1) && (newnode.getFilename().compareTo(ptroot.getSubright().getFilename())<0)){
            return DoubleLeft(ptroot);
        }
        return ptroot;
    }
    
    public void Insert_New_Node(String filename,String content,String user){
        String timestamp = GetTimesTamp();
        NodeAvl newnode = new NodeAvl(filename,content,timestamp,user);
        root = Insert_Node(root, newnode);
    }
    
    private String GetTimesTamp(){
        Date date = new Date();
        DateFormat actualtime = new SimpleDateFormat("HH:mm:ss");
        String gettime = actualtime.format(date);
        DateFormat actualdate = new SimpleDateFormat("dd/MM/yyyy");
        String getdate = actualdate.format(date);
        String getall = gettime+" "+getdate;
        return getall;
    }
    
    public NodeAvl Delete_File(NodeAvl actualnode,String filename){
        if(actualnode == null){
            return actualnode;
        }
        if(filename.compareTo(actualnode.getFilename())<0){
            actualnode.subleft = Delete_File(actualnode.subleft, filename);
        }else if(filename.compareTo(actualnode.getFilename())>0){
            actualnode.subright = Delete_File(actualnode.subright, filename);
        }else{
            if(actualnode.subleft == null || actualnode.subright == null){
                NodeAvl temporal = null;
                if(temporal == actualnode.subleft){
                    temporal = actualnode.subright;
                }else{
                    temporal = actualnode.subleft;
                }
                
                if(temporal == null){
                    temporal = actualnode;
                    actualnode = null;
                }else{
                    actualnode = temporal;
                }
                
            }else{
                NodeAvl assistand = MinLevel(actualnode.subright);
                actualnode.setFilename(assistand.getFilename());
                actualnode.subright = Delete_File(actualnode.subright,assistand.getFilename());
            }
        }
        
        if(actualnode == null){
            return actualnode;
        }
        actualnode.setHeigth(MaxHeight(ActualHeight(actualnode.subleft), ActualHeight(actualnode.subright))+1);
        int newbalance = Height_Balance(actualnode);
        if(newbalance > 1 && Height_Balance(actualnode.subleft)>=0){
            return NormalRight(actualnode);
        }
        if(newbalance > 1 && Height_Balance(actualnode.subleft)<0){
            return DoubleRight(actualnode);
        }
        if(newbalance < -1 && Height_Balance(actualnode.subright)<=0){
            return NormalLeft(actualnode);
        }
        if(newbalance < -1 && Height_Balance(actualnode.subright)>0){
            return DoubleLeft(actualnode);
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
    
    public void Modify(NodeAvl actualnode,String filename,String newname){
        NodeAvl temporal = Search_File(actualnode,filename);
        if(temporal != null){
            String content = temporal.getContent(); 
            String getime = temporal.getTimestamp();
            String getuser = temporal.getUsername();
            System.out.println(content + getime+getuser);
            root = Delete_File(root, filename);
            NodeAvl newnode = new NodeAvl(newname,content,getime,getuser);
            InsertModify(newnode);
        }else{
            JOptionPane.showMessageDialog(null,"Este nodo no existe");
        }
    }
    
    private void InsertModify(NodeAvl newnode){
        if(root == null){
            root = newnode;
        }else{
            root = Insert_Node(root,newnode);
        }
    }
    
    
    public void Graph_Avl(String image_name,AVLTree actualtree){
        try{
            create = "";
            String path = "avl_"+image_name+".dot";
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
                String command = "dot -Tjpg avl_"+image_name+".dot -o avl_"+image_name+".jpg";
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
                String[] realname = actualnode.getFilename().split("\\.");
                String subcontent = actualnode.getContent();
                String factor = String.valueOf(actualnode.getFactor());
                String height = String.valueOf(actualnode.getHeigth());
                create += "node"+realname[0]+" [label = \" <C0>|" + "File name: "+actualnode.getFilename()
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
