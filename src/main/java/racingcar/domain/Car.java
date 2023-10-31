package racingcar.domain;

public final class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void move(MoveRule moveRule) {
        distance += moveRule.tryMove();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
