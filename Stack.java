package proyectofinaledd2019;


public class Stack {
  
    NodeStack head;
    
    public Stack(){
        head = null;
    }
    
    public void Insert_Node(String name){
        NodeStack newnode = new NodeStack(name,"","","","");
        if(head == null){
            head = newnode;
        }else{
            newnode.next = head;
            head = newnode;
        }
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
}
