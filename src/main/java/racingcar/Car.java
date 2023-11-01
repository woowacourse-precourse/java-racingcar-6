package racingcar;

public class Car {//TEST
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
