package racingcar;

public class Car {
    private final String name;
    private final int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        // TODO: 자동차 이동 기능 구현
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
