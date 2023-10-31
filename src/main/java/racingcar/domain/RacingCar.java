package racingcar.domain;

import racingcar.service.RacingCarService;

public class RacingCar {
    private static final int minMoveNumber = 4;
    private final String name;
    private int moveNumber;

    public RacingCar(String name) {
        this.name = name;
        this.moveNumber = 0;
    }

    public void moveCar() {
        if (isMoreThanMinMoveNumber()) {
            moveNumber++;
        }
    }

    private boolean isMoreThanMinMoveNumber() {
        return RacingCarService.getRandomNumber() >= minMoveNumber;
    }

    public String getName() {
        return name;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public String getDashString() {
        return "-".repeat(moveNumber);
    }
}
