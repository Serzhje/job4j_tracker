package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Ball kolobok = new Ball();
        wolf.tryEat(kolobok);
        hare.tryEat(kolobok);
        fox.tryEat(kolobok);
    }
}
