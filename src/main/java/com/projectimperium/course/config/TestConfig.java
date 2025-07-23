package com.projectimperium.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectimperium.course.entities.Order;
import com.projectimperium.course.entities.User;
import com.projectimperium.course.repositories.OrderRepository;
import com.projectimperium.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
     
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9919929290", "123456");

        Order o1 = new Order(null, Instant.parse("2025-07-22T22:00:10Z"), u1);
        Order o2 = new Order(null, Instant.parse("2025-09-25T14:13:09Z"), u2); 
        Order o3 = new Order(null, Instant.parse("2025-07-22T16:25:56Z"), u1);

       userRepository.saveAll(Arrays.asList(u1, u2));
       orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
