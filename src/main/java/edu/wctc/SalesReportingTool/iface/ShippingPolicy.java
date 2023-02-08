package edu.wctc.SalesReportingTool.iface;

import edu.wctc.SalesReportingTool.Sale;

import java.io.FileNotFoundException;
import java.util.List;

public interface ShippingPolicy {
    List<Sale> getSales();
    void generateReport(List<Sale> salesList);
    void applyShipping(Sale sale);

}

