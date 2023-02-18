package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/* We can use any one of Field Injection, Setter Injection or Constructor Injection. In Constructor Injection alone @Autowired is
* not required. Out of these 3, Constructor Injection is recommended because all the initialisation can now take place at a single
* place while using Constructor Injection.*/
@Component
class YourBusinessClass {

    /* This is called Field Injection(@Autowired) where we are not using getter or constructor for injecting dependencies. */
    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;

    /* When we use @Autowired on Constructor then it is called Constructor Injection */
    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /* When we are using @Autowired on setter then it is called setter injection */
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection on Dependency-1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection on Dependency-2");
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {}

@Component
class Dependency2 {}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
