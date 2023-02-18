package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
* A record class declares a sequence of fields, and then the appropriate accessors,
* constructors, equals , hashCode , and toString methods are created automatically.
* The fields are final because the class is intended to serve as a simple "data carrier".
* */
record Person(String name,int age,Address address) {}
record Address(String firstLine, String city){}
@Configuration
public class HelloWorldConfiguration {
    // Things that are managed by Spring container are called Spring Beans.
    @Bean
    public String name() {
        return "Shashwat";
    }

    @Bean
    public int age() {
        return 23;
    }

    @Bean
    public Person person() {
        var person = new Person("Ravi",28, new Address("Main Street","Bengaluru"));
        return person;
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("221B Baker Street","London");
    }

    @Bean(name = "address3")
    @Qualifier("Address3Qualifier")
    public Address address3() {
        return new Address("Main Lane","Chennai");
    }

    // Re-using the existing beans to create a new bean by using MethodCall.
    // Here we return the name of the method.
    @Bean
    public Person person2MethodCall() {
        return new Person(name(),age(),address());
    }

    // Auto-wiring or injecting existing bean in the new Spring bean as parameters.
    // Here we pass the name of the bean which can be different from the name of the method.
    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name,age,address3);
    }

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("Address3Qualifier") Address address) {
        return new Person(name,age,address);
    }
}