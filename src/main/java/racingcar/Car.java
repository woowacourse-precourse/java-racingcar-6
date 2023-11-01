package racingcar;

public class Car {
    String name;
    int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
