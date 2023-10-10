package be.archilios.demos.ticketsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class TicketSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketSalesApplication.class, args);
    }

}
