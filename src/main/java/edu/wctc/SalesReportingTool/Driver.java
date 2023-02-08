package edu.wctc.SalesReportingTool;

import edu.wctc.SalesReportingTool.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;
@Component
public class Driver {
    private ShippingPolicy shippingPolicy;

    @Autowired
    public Driver(ShippingPolicy shippingPolicy){
        this.shippingPolicy = shippingPolicy;
    }
    public void generateReport() {
        List<Sale> allSales = shippingPolicy.getSales();
        for(Sale aSale : allSales)
            shippingPolicy.applyShipping(aSale);
        shippingPolicy.generateReport(allSales);
    }

}
