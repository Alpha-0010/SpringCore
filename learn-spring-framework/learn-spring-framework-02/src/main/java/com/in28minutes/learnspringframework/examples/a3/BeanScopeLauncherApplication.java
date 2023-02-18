package com.in28minutes.learnspringframework.examples.a3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
* If we use the NormalClass then we will get the same instance of Bean again and again. This means that classes in Spring are
* Singleton by default. On the other hand, if the class have a prototype scope then each time a bean is called a new instance will
* be returned. If we want a new instance of the bean when we call the bean then we can use Prototype scope on the bean.
* */
@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)) {
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
        }
    }
}
