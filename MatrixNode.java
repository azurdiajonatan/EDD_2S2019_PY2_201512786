package proyectofinaledd2019;


public class MatrixNode {
   
    private String location;
    private String father;
    private String son;
    private String folder;
    private int position;
    AVLTree inside_tree;
    MatrixNode up;
    MatrixNode down;
    MatrixNode right;
    MatrixNode left;
      
    //HEADER
    public MatrixNode(String location,int position){
        this.location = location;
        this.position = position;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }
    
    //BODY
    public MatrixNode(String son,String father,String folder){
        this.son = son;
        this.father = father;
        this.folder = folder;
        this.inside_tree = null;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    
    
    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
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
