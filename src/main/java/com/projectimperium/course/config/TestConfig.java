package com.projectimperium.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectimperium.course.entities.Order;
import com.projectimperium.course.entities.OrderItem;
import com.projectimperium.course.entities.Payment;
import com.projectimperium.course.entities.Product;
import com.projectimperium.course.entities.User;
import com.projectimperium.course.entities.enums.OrderStatus;
import com.projectimperium.course.repositories.CategoryRepository;
import com.projectimperium.course.repositories.OrderItemRepository;
import com.projectimperium.course.repositories.OrderRepository;
import com.projectimperium.course.repositories.ProductRepository;
import com.projectimperium.course.repositories.UserRepository;
import com.projectimperium.course.entities.Category;

@Configuration
@Profile("test") // Perfil de testes do Spring Boot
public class TestConfig implements CommandLineRunner {
     
    @Autowired // Injeção de dependência do  Spring
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // Salvar tudo no Banco de Dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9919929290", "123456");

        Order o1 = new Order(null, Instant.parse("2025-07-22T22:00:10Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-09-25T14:13:09Z"), OrderStatus.WAITING_PAYMENT ,u2); 
        Order o3 = new Order(null, Instant.parse("2025-07-22T16:25:56Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2025-07-22T23:00:10Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }

}
