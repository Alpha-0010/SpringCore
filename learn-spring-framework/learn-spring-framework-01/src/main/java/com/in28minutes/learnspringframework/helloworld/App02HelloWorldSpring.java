package com.in28minutes.learnspringframework.helloworld;

import com.in28minutes.learnspringframework.helloworld.Address;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // 1. Launch a Spring Context.
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. Configure the things that we want Spring Framework to manage -
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3. Retrieving Beans managed by Spring.
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            // Retrieving bean by the bean name.
            System.out.println(context.getBean("address2"));
            // Retrieving the bean by the type of the bean
//        System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            System.out.println("..........................................................................");

            // Printing all the beans in the Context.
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(s -> System.out.println(s));

            // If we have multiple matching beans(Candidates) then Spring will throw exception. We can fix this by making one of the bean as primary.
            // @Primary
            System.out.println(context.getBean(Address.class));

            // If we have multiple matching beans then we can also fix this by making use of Qualifiers.
            System.out.println(context.getBean("person4Qualifier"));
        }

    }
}