package domain;

import util.RandomGenerator;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drive() {
        if (shouldMove()) {
            move();
        }
    }

    private boolean shouldMove() {
        return RandomGenerator.generateNumber() >= 4;
    }

    private void move() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.println(name + " : " + "-".repeat(position)); // 'this' 생략
    }

}
