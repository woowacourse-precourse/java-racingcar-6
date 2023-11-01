package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = String.valueOf(name);
    }


    // 자동차 전진
    public void moveForward(int distance) {
        position += distance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
