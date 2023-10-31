package racingcar.games.racing.domain;

public class Car {
    private static final String MOVE_DISTANCE = "-";
    private final String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public void move() {
        position += MOVE_DISTANCE;
    }

    public String getMoveResult() {
        return name + " : " + position;
    }
}
