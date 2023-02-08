package edu.wctc.SalesReportingTool;

import edu.wctc.SalesReportingTool.iface.ShippingPolicy;
import edu.wctc.SalesReportingTool.impl.FlatRateDomesticShipping;
import edu.wctc.SalesReportingTool.impl.FreeShipping;
import edu.wctc.SalesReportingTool.impl.OrderPriceShipping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc.SalesReportingTool")
public class AppConfig {
    @Bean
    public ShippingPolicy shippingPolicy(){
//        return new FreeShipping();
//        return new FlatRateDomesticShipping();
        return new OrderPriceShipping();
    }
}
