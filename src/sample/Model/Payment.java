package sample.Model;

public class Payment {
    private int ReceiptNo;
    private String PaymentDate;
    private String AllocationCode;
    private double AmountPaid;
    private String PropertyCode;
    private String PropertyType;
    private double MonthlyRent;
    private String Location;
    private String TenantCode;
    private String TenantName;
    private int ContactNo;

    public Payment(int receiptNo, String paymentDate, String allocationCode, double amountPaid, String propertyCode, String propertyType, double monthlyRent, String location, String tenantCode, String tenantName, int contactNo) {
        ReceiptNo = receiptNo;
        PaymentDate = paymentDate;
        AllocationCode = allocationCode;
        AmountPaid = amountPaid;
        PropertyCode = propertyCode;
        PropertyType = propertyType;
        MonthlyRent = monthlyRent;
        Location = location;
        TenantCode = tenantCode;
        TenantName = tenantName;
        ContactNo = contactNo;
    }

    public int getReceiptNo() {
        return ReceiptNo;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public String getAllocationCode() {
        return AllocationCode;
    }

    public double getAmountPaid() {
        return AmountPaid;
    }

    public String getPropertyCode() {
        return PropertyCode;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    public double getMonthlyRent() {
        return MonthlyRent;
    }

    public String getLocation() {
        return Location;
    }

    public String getTenantCode() {
        return TenantCode;
    }

    public String getTenantName() {
        return TenantName;
    }

    public int getContactNo() {
        return ContactNo;
    }
}
