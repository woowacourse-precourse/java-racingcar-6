package racingcar.car;

public class RacingCar {
    private static final Integer MOVE_COUNT_INITIAL_NUMBER = 0;
    private String name;

    private Integer moveCount;

    public RacingCar(String name) {
        this.name = name;
        this.moveCount = MOVE_COUNT_INITIAL_NUMBER;
    }
}
