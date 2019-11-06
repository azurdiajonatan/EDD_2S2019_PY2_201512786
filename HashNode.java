package proyectofinaledd2019;


public class HashNode {
    private String name;
    private String password;
    private String timestamp;
    private String code;
    HashNode next;
    
    public HashNode(String name,String password,String timestamp){
        this.name = name;
        this.password = password;
        this.timestamp = timestamp;
        this.next = null;
    }

    
    public HashNode(String code){
        this.code = code;
        this.next = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }
    
}
