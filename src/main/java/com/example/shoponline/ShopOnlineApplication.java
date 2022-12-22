package com.example.shoponline;

import com.example.shoponline.model.*;
import com.example.shoponline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ShopOnlineApplication implements CommandLineRunner {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private NaturalStoneRepository naturalStoneRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShopOnlineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        NaturalStone naturalStone1 = new NaturalStone("Piatra puritatii si a sufletului", "Ametist");
        NaturalStone naturalStone2 = new NaturalStone("Piatra care protejeaza de spirite", "Onix");
        NaturalStone naturalStone3 = new NaturalStone("Piatra care contribuie la atingerea scopului", "Carneol");
        NaturalStone naturalStone4 = new NaturalStone("Piatra care impulsioneaza sistemul imunitar", "Turcoaz");

        naturalStoneRepository.save(naturalStone1);
        naturalStoneRepository.save(naturalStone2);
        naturalStoneRepository.save(naturalStone3);
        naturalStoneRepository.save(naturalStone4);

        User user1 = new User("tcaragea", "pass1234");
        User user2 = new User("TestUser","test1234");
        User user3= new User("Tester", "pass1234");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Product product1 = new Product(Product.Type.Bratara, 5.00);
        Product product2 = new Product(Product.Type.Lantisor, 12.00);
        Product product3 = new Product(Product.Type.Bratara, 5.00);
        Product product4 = new Product(Product.Type.Bratara, 5.00);
        Product product5 = new Product(Product.Type.Bratara, 12.00);

        product1.setNaturalStone(naturalStone1);
        product2.setNaturalStone(naturalStone1);
        product3.setNaturalStone(naturalStone2);
        product4.setNaturalStone(naturalStone3);
        product5.setNaturalStone(naturalStone3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        Order order1 = new Order(product1.getPrice() + product2.getPrice(), Set.of(product1,product2));
        Order order2 = new Order(product1.getPrice() + product2.getPrice() + product5.getPrice(), Set.of(product1,product2,product5));
        Order order3 = new Order(product1.getPrice() + product4.getPrice() + product5.getPrice(), Set.of(product1,product4,product5));

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        orders.add(order2);
        Delivery delivery1 = new Delivery(orders,false,user1);
        orders.remove(order2);
        orders.add(order3);
        Delivery delivery2 = new Delivery(orders,true,user2);

        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);

        Date d1 = new Date(2022,12,20);
        Date d2 = new Date(2022, 11, 22);
        History history1 = new History(delivery1, History.Status.Preg,d1);
        History history2 = new History(delivery2, History.Status.Livrat,d2);

        historyRepository.save(history1);
        historyRepository.save(history2);

    }
}
