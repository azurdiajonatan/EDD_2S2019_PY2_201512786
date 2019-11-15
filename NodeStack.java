package proyectofinaledd2019;

public class NodeStack {

    private String date;
    private String time;
    private String description;
    private String user;
    NodeStack next;
    
    public NodeStack(String date,String time,String description,String user){
        this.date = date;
        this.time = time;
        this.description = description;
        this.user = user;
        this.next = null;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public NodeStack getNext() {
        return next;
    }

    public void setNext(NodeStack next) {
        this.next = next;
    }

    
    
}
