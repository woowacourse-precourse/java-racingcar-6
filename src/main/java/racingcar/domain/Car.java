package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void moveForwad(int distance){
        this.distance += distance;
    }
}
