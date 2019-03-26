package sample.Model;

public class Rent_Alloc {
    int id;
    String loc_Code;
    String loc_Date;
    String prop_Code;
    String tenantCode;
    String start_Date;
    String contract_length;
    int monthlyRent;

    public Rent_Alloc(int id, String loc_Code, String loc_Date, String prop_Code, String tenantCode, String start_Date, String contract_length, int monthlyRent) {
        this.id = id;
        this.loc_Code = loc_Code;
        this.loc_Date = loc_Date;
        this.prop_Code = prop_Code;
        this.tenantCode = tenantCode;
        this.start_Date = start_Date;
        this.contract_length = contract_length;
        this.monthlyRent = monthlyRent;
    }

    public int getId() {
        return id;
    }

    public String getLoc_Code() {
        return loc_Code;
    }

    public String getLoc_Date() {
        return loc_Date;
    }

    public String getProp_Code() {
        return prop_Code;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public String getStart_Date() {
        return start_Date;
    }

    public String getContract_length() {
        return contract_length;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }
}
