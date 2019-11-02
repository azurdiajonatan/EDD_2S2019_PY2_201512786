package proyectofinaledd2019;

public class ProyectoFinalEDD2019 {

    

    public static void main(String[] args) {
        /*Stack hola = new Stack();
        hola.Insert_Node("hola");
        hola.Insert_Node("perro");
        hola.Insert_Node("tras");
        hola.Insert_Node("tras");
        hola.Show_Stack();
        hola.Delete_Node();
        hola.Show_Stack();*/
        //Index listen = new Index();
        //listen.show();
        
        AVLTree avl =  new AVLTree();
        avl.Insert_New_Node("J");
        avl.Insert_New_Node("E");
        avl.Insert_New_Node("M");
        avl.Insert_New_Node("A");
        avl.Insert_New_Node("F");
        avl.Insert_New_Node("Q");
        avl.Insert_New_Node("P");
        avl.Preorder(avl.root);
        
        
    }
    
}
