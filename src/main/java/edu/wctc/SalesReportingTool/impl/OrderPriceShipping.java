package edu.wctc.SalesReportingTool.impl;

import edu.wctc.SalesReportingTool.Sale;
import edu.wctc.SalesReportingTool.iface.ShippingPolicy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderPriceShipping implements ShippingPolicy {
    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        try{
            File file = new File("sales.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String [] string = sc.nextLine().split(",");
                String customer = string[0];
                String country = string[1];
                double saleAmount = Double.parseDouble(string[2]);
                double saleTax = Double.parseDouble(string[3]);

                Sale newSale = new Sale(country,saleAmount,saleTax);
                newSale.setCustomer(customer);
                sales.add(newSale);
            }
            return sales;
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("SALES DETAIL REPORT");
        System.out.printf("%-25s %-20s %-10s %-10s %-4s\n", "Customer", "Country", "Amount", "Tax", "Shipping");
        for (Sale aSale: salesList) {
            System.out.printf("%-25s %-20s %-10.2f %-10.2f %-4.2f\n",aSale.getCustomer(),aSale.getCountry(), aSale.getSaleAmount(),
                    aSale.getSaleTax(), aSale.getShippingCost());
        }
    }

    @Override
    public void applyShipping(Sale sale) {
        if(sale.getSaleAmount()>100)
            sale.setShippingCost(0);
        else if(sale.getSaleAmount()>50)
            sale.setShippingCost(4.99);
        else
            sale.setShippingCost(9.99);
    }
}
