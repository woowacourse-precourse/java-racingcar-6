package domain;

import util.RandomGenerator;

public class Car {

    private String name;
    private String position = "";

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
        position += "-"; // 'this' 생략
    }

    public String getPosition() {
        return position;
    }

}
