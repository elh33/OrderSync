package ma.ensa.OrderSync;

import ma.ensa.services.OrderService;

public class App {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.parseJsonThread();
    }
}
