package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForwad(){
        this.distance += 1;
    }

    public String showDistance(){
        return "-".repeat(this.distance);
    }
}
