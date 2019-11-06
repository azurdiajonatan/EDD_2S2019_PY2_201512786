package proyectofinaledd2019;

public class NodeStack {

    private String user;
    private String action;
    private String date;
    private String namefile;
    private String description;
    NodeStack next;
    
    public NodeStack(String user,String action,String date,String namefile,String description){
        this.user = user;
        this.action = action;
        this.date = date;
        this.namefile = namefile;
        this.description = description;
        this.next = null;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
