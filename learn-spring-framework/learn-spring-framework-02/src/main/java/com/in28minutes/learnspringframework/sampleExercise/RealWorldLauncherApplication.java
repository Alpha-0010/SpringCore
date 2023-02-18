package com.in28minutes.learnspringframework.sampleExercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.sampleExercise")
public class RealWorldLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RealWorldLauncherApplication.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}

/*
* Requirements :-
* 1. Use Constructor Injection for dependencies.
* 2. Make MongoDbDataService as primary.
* 3. Create context and run BusinessCalculationApplication.
* */