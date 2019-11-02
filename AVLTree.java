package proyectofinaledd2019;

public class AVLTree {

    NodeAvl root;
   
    public AVLTree(){
        root = null;
        String create = "";
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
    
}
