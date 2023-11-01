package domain;

import random.Random;

public class Car {
    private String name;
    private int position = 0;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public Car(String name, int position, Random random) {
        this.name = name;
        this.position = position;
        this.random = random;
    }

    public void move() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return 4 <= random.create();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            distance.append("-");
        }
        return name + " : " + distance;
    }

}
