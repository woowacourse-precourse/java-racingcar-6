package racingcar;

public class Car {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    private String name;
    private Integer move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void forward() {
        this.move += 1;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }
}
