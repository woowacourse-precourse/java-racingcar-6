package racingcar;

public class Car {
    private String name; // 자동차의 이름

    private int distance; // 자동차가 이동한 거리

    public Car(String name) {
        this.name = name;
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
