package edu.wctc.SalesReportingTool;

public class Sale {
    private String customer;
    private String country;
    private double saleAmount;
    private double saleTax;
    private double shippingCost;

    public Sale(String country, double saleAmount, double saleTax) {
        this.country = country;
        this.saleAmount = saleAmount;
        this.saleTax = saleTax;
    }
    public void setShippingCost(double shippingCost){
        this.shippingCost = shippingCost;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer){
        this.customer = customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public double getSaleTax() {
        return saleTax;
    }

    public void setSaleTax(double saleTax) {
        this.saleTax = saleTax;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}


