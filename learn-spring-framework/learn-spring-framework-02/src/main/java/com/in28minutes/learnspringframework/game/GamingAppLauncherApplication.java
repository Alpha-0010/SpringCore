package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("package com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

//    @Bean
//    public GamingConsole game() {
//        var game = new MarioGame(); // Instead of this how can we make Spring call the MarioGame for us by using Component and ComponentScan.
//        return game;
//    }

//    We can also configure Spring to remove this as well by making GameRunner a Component.
//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        return new GameRunner(game);
//    }

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
