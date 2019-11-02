package proyectofinaledd2019;


public class NodeAvl {
    
    //Properties AVL 
    private String filename;
    private String content;
    private int factor;
    private int heigth;
    private String timestamp;
    private String username;
    NodeAvl subleft;
    NodeAvl subright;
    
    
    public NodeAvl(String filename,String content,String timestamp,String username){
        this.filename = filename;
        this.content = content;
        this.timestamp = timestamp;
        this.username = username;
        this.factor = 0;
        this.heigth = 0;
        this.subleft = null;
        this.subright = null;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public NodeAvl getSubleft() {
        return subleft;
    }

    public void setSubleft(NodeAvl subleft) {
        this.subleft = subleft;
    }

    public NodeAvl getSubright() {
        return subright;
    }

    public void setSubright(NodeAvl subright) {
        this.subright = subright;
    }
    
}
