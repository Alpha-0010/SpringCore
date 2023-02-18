package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.SuperContra;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        // If we use var in front of an object then the type of object is determined at compile time.
//        var game = new MarioGame();
        var game = new SuperContra(); // 1. Object creation.
        var gameRunner = new GameRunner(game);
        // 2. Object creation + wiring of dependencies. Here game is a dependency of gameRunner.
        // Here we are injecting the game dependency in the gameRunner object.
        gameRunner.run();
    }
}