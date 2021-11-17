package model;

public class Status {
    private int status_cod;
    private String status_desc;

    public Status(String status_desc) {
        this.status_desc = status_desc;
    }

    public Status(int status_cod, String status_desc) {
        this.status_cod = status_cod;
        this.status_desc = status_desc;
    }

    public Status() {
    }

    public int getStatus_cod() {
        return status_cod;
    }

    public void setStatus_cod(int status_cod) {
        this.status_cod = status_cod;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }
    
    
}
