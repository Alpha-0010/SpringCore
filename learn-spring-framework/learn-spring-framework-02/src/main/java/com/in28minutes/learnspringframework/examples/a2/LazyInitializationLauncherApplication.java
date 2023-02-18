package com.in28minutes.learnspringframework.examples.a2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class A {

}

/*
* Lazy makes sure that the bean is loaded only when it is used.
* Eager initialization is recommended because if have some error in beans then eager will make sure that we get it during the start-up
* of the application.
* */
@Component
@Lazy
class B {

    private A a;

    @Autowired
    public B(A a) {
        System.out.println("Some Initialization Logic");
        this.a = a;
    }

    public void doSomething() {
        System.out.println("Do Something...");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            System.out.println("...Lazy Initialization...");
            context.getBean(B.class).doSomething();
        }
    }
}

