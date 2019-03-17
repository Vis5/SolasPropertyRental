package sample;

public class Tenant {
    int id;
    String code;
    String name;
    String stat;
    String number;

    public Tenant(int id,String code, String name, String stat, String number) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.stat = stat;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getStat() {
        return stat;
    }

    public String getNumber() {
        return number;
    }
}
