package edu.wctc.SalesReportingTool.impl;

import edu.wctc.SalesReportingTool.Sale;
import edu.wctc.SalesReportingTool.iface.ShippingPolicy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatRateDomesticShipping implements ShippingPolicy {
    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        try{
            File file = new File("sales.txt");
            Scanner sc = new Scanner(file);
            String [] string = sc.nextLine().split(",");
            String country = string[1];
            double saleAmount = Double.parseDouble(string[2]);
            double saleTax = Double.parseDouble(string[3]);
            sales.add(new Sale(country,saleAmount,saleTax));
            while(sc.hasNextLine()){
                string = sc.nextLine().split(",");
                country = string[1];
                saleAmount = Double.parseDouble(string[2]);
                saleTax = Double.parseDouble(string[3]);
                String finalCountry = country;
                if(sales.stream().anyMatch(x->x.getCountry().equals(finalCountry))){
                    Sale currentSale = sales.stream().filter(x->x.getCountry().equals(finalCountry)).findAny().get();
                    currentSale.setSaleAmount(currentSale.getSaleAmount()+saleAmount);
                    currentSale.setSaleTax(currentSale.getSaleTax()+saleTax);
                }
                else
                    sales.add(new Sale(country,saleAmount,saleTax));
            }
            return sales;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("SALES SUMMARY REPORT");
        System.out.printf("%-20s %-10s %-10s %-4s\n", "Country", "Amount", "Tax", "Shipping");
        for (Sale aSale: salesList) {
            System.out.printf("%-20s %-10.2f %-10.2f %-4.2f\n",aSale.getCountry(), aSale.getSaleAmount(),
                    aSale.getSaleTax(), aSale.getShippingCost());
        }
    }

    @Override
    public void applyShipping(Sale sale) {
        switch(sale.getCountry()){
            case "United States":
                if(sale.getSaleAmount()>200)
                    sale.setShippingCost(29.95);
                else
                    sale.setShippingCost(14.99);
                break;
            case "Japan":
                if(sale.getSaleAmount()>100)
                    sale.setShippingCost(14.50);
                else
                    sale.setShippingCost(9.99);
                break;
            case "Scotland":
                sale.setShippingCost(13.99);
                break;
            case "India":
                sale.setShippingCost(19.99);
                break;
        }

    }
}
