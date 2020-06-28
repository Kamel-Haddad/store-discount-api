package org.shop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shop.model.Order;
import org.shop.repository.OrderRepository;
import org.shop.service.OrderService;
import org.shop.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
 
    @TestConfiguration
    static class OrderServiceTestContextConfiguration {
  
        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl();
        }
    }
 
    @Autowired
    private OrderService orderService;
    
 
    @MockBean
    private OrderRepository orderRepository;
 
    @Before
    public void setUp() {
    	Mockito.when(orderRepository.findById(2l).get().getUser().getFirstName()).thenReturn("Amer");
    }
    
    @Test
    public void orderID_1_belongs_to_Kamel_User() {
        String name = "Kamel";
        Optional<Order> found = orderService.getOrder(1l);
         assertThat(found.get().getUser().getFirstName())
          .isEqualTo(name);
     }
    
    
}