package racingcar.racingGame;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        this.distance++;
    }

}
