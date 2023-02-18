package com.in28minutes.learnspringframework.examples.a4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;


@Component
class SomeClass {
    private SomeDependency someDependency;

    @Autowired
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    /* @PostConstruct will ensure that the initialise method is called as soon as the dependency injection is done. */
    @PostConstruct
    public void initialise() {
        someDependency.getReady();
    }

    /* @PreDestroy on a method will call the method when the bean is going to be removed from the context/Container. In the cleanup we generally
    * free something. */
    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up...");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using someDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
