package racingcar.model;

public class Car {
    String name;
    Integer location;
    Boolean isWinner;
    Engine randomEngine;

    public Car(String name) {
        this.name = name;
        randomEngine = new RandomEngine();
        location = 0;
        isWinner = false;
    }

    public void move() {
        location += randomEngine.move();
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setWinner() {
        isWinner = true;
    }

    public Boolean isWinner() {
        return isWinner;
    }
}
