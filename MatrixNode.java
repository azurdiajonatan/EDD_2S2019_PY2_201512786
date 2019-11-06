package proyectofinaledd2019;


public class MatrixNode {
   
    private int location;
    private int folder;
    private int father;
    private int son;
    AVLTree inside_tree;
    MatrixNode up;
    MatrixNode down;
    MatrixNode right;
    MatrixNode left;
      
    //HEADER
    public MatrixNode(int location){
        this.location = location;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }
    
    //BODY
    public MatrixNode(int son, int father,int folder){
        this.son = son;
        this.father = father;
        this.folder = folder;
        //this.inside_tree = inside_tree;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getFolder() {
        return folder;
    }

    public void setFolder(int folder) {
        this.folder = folder;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getSon() {
        return son;
    }

    public void setSon(int son) {
        this.son = son;
    }

    public AVLTree getInside_tree() {
        return inside_tree;
    }

    public void setInside_tree(AVLTree inside_tree) {
        this.inside_tree = inside_tree;
    }

    public MatrixNode getUp() {
        return up;
    }

    public void setUp(MatrixNode up) {
        this.up = up;
    }

    public MatrixNode getDown() {
        return down;
    }

    public void setDown(MatrixNode down) {
        this.down = down;
    }

    public MatrixNode getRight() {
        return right;
    }

    public void setRight(MatrixNode right) {
        this.right = right;
    }

    public MatrixNode getLeft() {
        return left;
    }

    public void setLeft(MatrixNode left) {
        this.left = left;
    }

    
    
}
